package m2j.ds.hr.stacks;

import java.io.IOException;
import java.util.Arrays;
import java.util.Stack;

/**
 * @author m2j
 * @see https://www.hackerrank.com/challenges/waiter/problem
 * 
 *
 */
public class Waiter {

	static int[] waiterq1(int[] number, int q) {
		int[] pic = new int[number.length];

//    	Stack<Integer> stack = pushToStack(number);

		// System.out.println(stack.peek());

		Stack<Integer> A1 = new Stack<Integer>();
		Stack<Integer> B1 = new Stack<Integer>();
		// int iter = 1;
		for (int i = number.length - 1; i >= 0; i--) {
			int p = getQthPrime(q);
//			System.out.println(iter+"th prime number is: "+ p);
			if (number[i] % p == 0) {
				B1.push(number[i]);
			} else {
				A1.push(number[i]);
			}
			System.out.print(number[i] + " ");
		}
		System.out.println();
		int k = 0;
		while (!B1.isEmpty()) {
			pic[k] = B1.pop();
			k++;
		}
		while (!A1.isEmpty()) {
			pic[k] = A1.pop();
			k++;
		}
		return pic;
	}

	static int[] waiter(int[] number, int q) {
		int[] plates = new int[number.length];

		Stack<Integer> A = new Stack<Integer>();
		for (int i = 0; i < number.length; i++) {
			A.push(number[i]);
		}

		int k = 0;

		for (int i = 1; i <= q; i++) {
			int p = getQthPrime(i);

			Stack<Integer> B1 = new Stack<Integer>();
			Stack<Integer> Anth = new Stack<Integer>();

			while (!A.isEmpty()) {
				int num = A.pop();
				if (num % p == 0) {
					B1.push(num);
				} else {
					Anth.push(num);
				}
			}
			while (!B1.isEmpty()) {
				plates[k] = B1.pop();
				k++;
			}

			A = Anth;
		}
		while (!A.isEmpty()) {
			plates[k] = A.pop();
			k++;
		}
		return plates;
	}

	static void printStack(Stack<Integer> s) {
		while (!s.empty()) {
			System.out.println(s.pop());
		}
	}

	private static int getQthPrime(int qth) {
		int i;
		int prime = 1;
		int count = 0;

		while (count < qth) {
			prime++;
			for (i = 2; i <= prime; i++) {
				if (prime % i == 0) {
					break;
				}
			}
			if (i == prime) {
				count++;
			}
		}
		return prime;
	}

	public static void main(String[] args) throws IOException {
//
		test0();
		test1();

	}

//    4
//    6
//    3
//    7
//    5
	private static void test0() {
		int[] number = { 3, 4, 7, 6, 5 };
		int q = 1;
		int[] result = waiter(number, q);
		Arrays.stream(result).forEach(i -> System.out.println(i + " "));
	}

//	4
//	4
//	9
//	3
//	3
	private static void test1() {
		int[] number = { 3, 3, 4, 4, 9 };
		int q = 2;
//		waiter(number, q);
		int[] result = waiter(number, q);
		Arrays.stream(result).forEach(i -> System.out.println(i + " "));
	}
}
