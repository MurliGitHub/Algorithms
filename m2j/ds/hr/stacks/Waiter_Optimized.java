package m2j.ds.hr.stacks;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Waiter_Optimized {
	
	static int MAX_SIZE = 1000005;

	static ArrayList<Integer> primes = new ArrayList<Integer>();
	
	static int[] waiter(int[] number, int q) {
		SieveOfEratosthenes();
		int[] plates = new int[number.length];

		Stack<Integer> A = new Stack<Integer>();
		for (int i = 0; i < number.length; i++) {
			A.push(number[i]);
		}

		int k = 0;

		for (int i = 0; i < q; i++) {
			int p = primes.get(i);
			System.out.println("prime: "+p);
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
	
	static void SieveOfEratosthenes() {
		boolean[] IsPrime = new boolean[MAX_SIZE];

		for (int i = 0; i < MAX_SIZE; i++)
			IsPrime[i] = true;

		for (int p = 2; p * p < MAX_SIZE; p++) {
			if (IsPrime[p] == true) {
				for (int i = p * p; i < MAX_SIZE; i += p)
					IsPrime[i] = false;
			}
		}

		for (int p = 2; p < MAX_SIZE; p++)
			if (IsPrime[p] == true)
				primes.add(p);
	}
	

	public static void main(String[] args) throws IOException {
		//
		test0();
		test1();

	}

//		    4
//		    6
//		    3
//		    7
//		    5
	private static void test0() {
		int[] number = { 3, 4, 7, 6, 5 };
		int q = 1;
		int[] result = waiter(number, q);
		Arrays.stream(result).forEach(i -> System.out.println(i + " "));
	}

//			4
//			4
//			9
//			3
//			3
	private static void test1() {
		int[] number = { 3, 3, 4, 4, 9 };
		int q = 2;
//				waiter(number, q);
		int[] result = waiter(number, q);
		Arrays.stream(result).forEach(i -> System.out.println(i + " "));
	}
	

}
