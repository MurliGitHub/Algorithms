package m2j.ds.hr.stacks;

import java.util.Stack;

public class Games {

	static int twoStacks(int x, int[] a, int[] b) {

		int count = 0;
		int sum = 0;
		Stack<Integer> as = new Stack<Integer>();
		Stack<Integer> bs = new Stack<Integer>();

		getStack(a, as);

		getStack(b, bs);

		while (sum <= x) {
			if (as.empty() && bs.empty())
				break;

			Integer peeka = as.peek();
			Integer peekb = bs.peek();
			if (peeka <= peekb) {
				if (sum + peeka <= x) {
					sum += as.pop();
					count++;
				} else {
					break;
				}
			} else {
				if (sum + peekb <= x) {
					sum += bs.pop();
					count++;
				} else {
					break;
				}
			}

		}

		return count;
	}

	private static void getStack(int[] a, Stack<Integer> stack) {
		for (int i = a.length - 1; i >= 0; i--) {
			stack.push(a[i]);
		}
	}
	
	static int solve(int x, int[] a, int[] b) {
		int lengthB = 0;
		int sum = 0;
		while (lengthB < b.length && sum + b[lengthB] <= x) {
			sum += b[lengthB];
			lengthB++;
		}

		int maxScore = lengthB;
		for (int lengthA = 1; lengthA <= a.length; lengthA++) {
			sum += a[lengthA - 1];

			while (sum > x && lengthB > 0) {
				lengthB--;
				sum -= b[lengthB];
			}

			if (sum > x) {
				break;
			}

			maxScore = Math.max(maxScore, lengthA + lengthB);
		}
		return maxScore;
	}

	public static void main(String[] args) {
		// int result = caseNon();
//		casef1();
//		int result = casef2();
//		casef3();
//		casef4();
		casef5();
//		casef6();
//		casef7();
	}

	// 6
	private static int casef1() {
		int x = 62;
		int[] a = { 7, 15, 12, 0, 5, 18, 17, 2, 10, 15, 4, 2, 9, 15, 13, 12, 16 };
		int[] b = { 12, 16, 6, 8, 16, 15, 18, 3, 11, 0, 17, 7, 6, 11, 14, 13, 15, 6, 18, 6, 16, 12, 16, 11, 16, 11 };

		int result = twoStacks(x, a, b);
		System.out.println(result);
		return result;
	}
	
	//1
	private static int casef2() {
		int x = 5;
		int[] a = {4, 11, 16, 0, 18, 17, 9, 13, 7, 12, 16, 19, 2, 15, 5, 13, 1, 10, 0, 8, 0, 6, 16, 12, 15, 7, 1, 6, 19, 16, 2};
		int[] b = {15, 8, 11, 16, 6, 0, 5, 11, 7, 9, 8, 6, 3, 3, 4, 8, 17, 14, 9, 5, 15, 15, 1, 19, 10, 0, 12, 8, 11, 9, 11, 18, 17, 14};

		int result = twoStacks(x, a, b);
		System.out.println(result);
		return result;
	}
	
	//6
	private static int casef3() {
		int x = 55;
		int[] a = {11, 6, 1, 13, 14, 7, 8, 10, 3, 17, 7, 18, 6, 4, 5, 13, 17, 4, 16, 9, 17, 16, 12, 6, 7};
		int[] b = {10, 15, 13, 17, 10, 7, 0, 16, 8, 13, 11, 8, 14, 13};

		int result = twoStacks(x, a, b);
		System.out.println(result);
		
		return result;
	}
	
	//1
	private static int casef4() {
		int x = 13;
		int[] a = {13, 9, 16, 18, 2, 5, 15, 10, 14, 4, 7, 18, 2, 6, 8, 17, 0, 5, 7, 7, 6, 3, 8, 11, 6, 8, 5, 19, 11, 8, 3, 5, 17, 19, 15, 12, 16, 10, 2, 2, 6, 9, 0, 8};
		int[] b = {16, 9, 17, 16, 6, 4, 15, 12, 0, 3, 16, 6, 11, 1, 18, 15, 10, 13, 12, 19, 5, 7, 11, 1, 10, 14, 4, 16, 3, 4, 17, 11, 5, 14, 19, 12, 19, 15, 4, 11, 10, 12};

		int result = twoStacks(x, a, b);
		System.out.println(result);
		return result;
	}
	
	private static int casef5() {
		int x = 67;
		int[] a = {19, 9, 8, 13, 1, 7, 18, 0, 19, 19, 10, 5, 15, 19, 0, 0, 16, 12, 5, 10};
		int[] b = {11, 17, 1, 18, 14, 12, 9, 18, 14, 3, 4, 13, 4, 12, 6, 5, 12, 16, 5, 11, 16, 8, 16, 3, 7, 8, 3, 3, 0, 1, 13, 4, 10, 7, 14};

		int result = solve(x, a, b);
		System.out.println(result);
		return result;
	}
	
	private static int casef6() {
		int x = 64;
		int[] a = {15, 5, 18, 19, 19, 2, 4, 17, 7, 16, 14, 5, 19, 2, 5, 7, 5, 12, 15, 1, 7, 8, 2, 12, 12, 4, 19, 18, 1, 11, 2, 16, 16, 0, 7, 7, 15};
		int[] b = {3, 5, 14, 19, 19, 19, 18, 1, 16, 17, 6, 0, 13, 19, 7, 1, 1, 12, 5, 6, 11, 3, 19, 14, 5, 7, 3, 18, 14, 10, 13, 10, 15, 19, 9, 14, 11, 0, 7, 7, 17, 6, 8, 10, 5, 7, 3, 7, 19, 8};

		int result = twoStacks(x, a, b);
		System.out.println(result);
		return result;
	}
	
	private static int casef7() {
		int x = 73;
		int[] a = {16, 17, 9, 3, 12, 19};
		int[] b = {9, 3, 4, 19, 18, 4, 1, 5, 15, 1, 12, 2, 18, 18, 2, 1, 4, 10, 4, 3, 1, 13, 0, 4, 17, 16, 14, 6, 11, 6, 6, 0, 9, 10, 12, 0, 14, 13, 5, 1, 14, 9, 4, 4};

		int result = twoStacks(x, a, b);
		System.out.println(result);
		return result;
	}
//	private static int casef3() {
//		int x = 55;
//		int[] a = {11 6 1 13 14 7 8 10 3 17 7 18 6 4 5 13 17 4 16 9 17 16 12 6 7};
//		int[] b = {10 15 13 17 10 7 0 16 8 13 11 8 14 13};
//
//		int result = twoStacks(x, a, b);
//		return result;
//	}
//	private static int casef3() {
//		int x = 55;
//		int[] a = {11 6 1 13 14 7 8 10 3 17 7 18 6 4 5 13 17 4 16 9 17 16 12 6 7};
//		int[] b = {10 15 13 17 10 7 0 16 8 13 11 8 14 13};
//
//		int result = twoStacks(x, a, b);
//		return result;
//	}
//	private static int casef3() {
//		int x = 55;
//		int[] a = {11 6 1 13 14 7 8 10 3 17 7 18 6 4 5 13 17 4 16 9 17 16 12 6 7};
//		int[] b = {10 15 13 17 10 7 0 16 8 13 11 8 14 13};
//
//		int result = twoStacks(x, a, b);
//		return result;
//	}
//	private static int casef3() {
//		int x = 55;
//		int[] a = {11 6 1 13 14 7 8 10 3 17 7 18 6 4 5 13 17 4 16 9 17 16 12 6 7};
//		int[] b = {10 15 13 17 10 7 0 16 8 13 11 8 14 13};
//
//		int result = twoStacks(x, a, b);
//		return result;
//	}
//	private static int casef3() {
//		int x = 55;
//		int[] a = {11 6 1 13 14 7 8 10 3 17 7 18 6 4 5 13 17 4 16 9 17 16 12 6 7};
//		int[] b = {10 15 13 17 10 7 0 16 8 13 11 8 14 13};
//
//		int result = twoStacks(x, a, b);
//		return result;
//	}
//	private static int casef3() {
//		int x = 55;
//		int[] a = {11 6 1 13 14 7 8 10 3 17 7 18 6 4 5 13 17 4 16 9 17 16 12 6 7};
//		int[] b = {10 15 13 17 10 7 0 16 8 13 11 8 14 13};
//
//		int result = twoStacks(x, a, b);
//		return result;
//	}
//	private static int casef3() {
//		int x = 55;
//		int[] a = {11 6 1 13 14 7 8 10 3 17 7 18 6 4 5 13 17 4 16 9 17 16 12 6 7};
//		int[] b = {10 15 13 17 10 7 0 16 8 13 11 8 14 13};
//
//		int result = twoStacks(x, a, b);
//		return result;
//	}
//	private static int casef3() {
//		int x = 55;
//		int[] a = {11 6 1 13 14 7 8 10 3 17 7 18 6 4 5 13 17 4 16 9 17 16 12 6 7};
//		int[] b = {10 15 13 17 10 7 0 16 8 13 11 8 14 13};
//
//		int result = twoStacks(x, a, b);
//		return result;
//	}
//	private static int casef3() {
//		int x = 55;
//		int[] a = {11 6 1 13 14 7 8 10 3 17 7 18 6 4 5 13 17 4 16 9 17 16 12 6 7};
//		int[] b = {10 15 13 17 10 7 0 16 8 13 11 8 14 13};
//
//		int result = twoStacks(x, a, b);
//		return result;
//	}
//	private static int casef3() {
//		int x = 55;
//		int[] a = {11 6 1 13 14 7 8 10 3 17 7 18 6 4 5 13 17 4 16 9 17 16 12 6 7};
//		int[] b = {10 15 13 17 10 7 0 16 8 13 11 8 14 13};
//
//		int result = twoStacks(x, a, b);
//		return result;
//	}
//	private static int casef3() {
//		int x = 55;
//		int[] a = {11 6 1 13 14 7 8 10 3 17 7 18 6 4 5 13 17 4 16 9 17 16 12 6 7};
//		int[] b = {10 15 13 17 10 7 0 16 8 13 11 8 14 13};
//
//		int result = twoStacks(x, a, b);
//		return result;
//	}
//	private static int casef3() {
//		int x = 55;
//		int[] a = {11 6 1 13 14 7 8 10 3 17 7 18 6 4 5 13 17 4 16 9 17 16 12 6 7};
//		int[] b = {10 15 13 17 10 7 0 16 8 13 11 8 14 13};
//
//		int result = twoStacks(x, a, b);
//		return result;
//	}
//	private static int casef3() {
//		int x = 55;
//		int[] a = {11 6 1 13 14 7 8 10 3 17 7 18 6 4 5 13 17 4 16 9 17 16 12 6 7};
//		int[] b = {10 15 13 17 10 7 0 16 8 13 11 8 14 13};
//
//		int result = twoStacks(x, a, b);
//		return result;
//	}
//	private static int casef3() {
//		int x = 55;
//		int[] a = {11 6 1 13 14 7 8 10 3 17 7 18 6 4 5 13 17 4 16 9 17 16 12 6 7};
//		int[] b = {10 15 13 17 10 7 0 16 8 13 11 8 14 13};
//
//		int result = twoStacks(x, a, b);
//		return result;
//	}
//	private static int casef3() {
//		int x = 55;
//		int[] a = {11 6 1 13 14 7 8 10 3 17 7 18 6 4 5 13 17 4 16 9 17 16 12 6 7};
//		int[] b = {10 15 13 17 10 7 0 16 8 13 11 8 14 13};
//
//		int result = twoStacks(x, a, b);
//		return result;
//	}
//	private static int casef3() {
//		int x = 55;
//		int[] a = {11 6 1 13 14 7 8 10 3 17 7 18 6 4 5 13 17 4 16 9 17 16 12 6 7};
//		int[] b = {10 15 13 17 10 7 0 16 8 13 11 8 14 13};
//
//		int result = twoStacks(x, a, b);
//		return result;
//	}
//	private static int casef3() {
//		int x = 55;
//		int[] a = {11 6 1 13 14 7 8 10 3 17 7 18 6 4 5 13 17 4 16 9 17 16 12 6 7};
//		int[] b = {10 15 13 17 10 7 0 16 8 13 11 8 14 13};
//
//		int result = twoStacks(x, a, b);
//		return result;
//	}
//	private static int casef3() {
//		int x = 55;
//		int[] a = {11 6 1 13 14 7 8 10 3 17 7 18 6 4 5 13 17 4 16 9 17 16 12 6 7};
//		int[] b = {10 15 13 17 10 7 0 16 8 13 11 8 14 13};
//
//		int result = twoStacks(x, a, b);
//		return result;
//	}
//	
//	private static int casef3() {
//		int x = 55;
//		int[] a = {11 6 1 13 14 7 8 10 3 17 7 18 6 4 5 13 17 4 16 9 17 16 12 6 7};
//		int[] b = {10 15 13 17 10 7 0 16 8 13 11 8 14 13};
//
//		int result = twoStacks(x, a, b);
//		return result;
//	}
//	private static int casef3() {
//		int x = 55;
//		int[] a = {11 6 1 13 14 7 8 10 3 17 7 18 6 4 5 13 17 4 16 9 17 16 12 6 7};
//		int[] b = {10 15 13 17 10 7 0 16 8 13 11 8 14 13};
//
//		int result = twoStacks(x, a, b);
//		return result;
//	}
//	private static int casef3() {
//		int x = 55;
//		int[] a = {11 6 1 13 14 7 8 10 3 17 7 18 6 4 5 13 17 4 16 9 17 16 12 6 7};
//		int[] b = {10 15 13 17 10 7 0 16 8 13 11 8 14 13};
//
//		int result = twoStacks(x, a, b);
//		return result;
//	}
//	private static int casef3() {
//		int x = 55;
//		int[] a = {11 6 1 13 14 7 8 10 3 17 7 18 6 4 5 13 17 4 16 9 17 16 12 6 7};
//		int[] b = {10 15 13 17 10 7 0 16 8 13 11 8 14 13};
//
//		int result = twoStacks(x, a, b);
//		return result;
//	}
//	private static int casef3() {
//		int x = 55;
//		int[] a = {11 6 1 13 14 7 8 10 3 17 7 18 6 4 5 13 17 4 16 9 17 16 12 6 7};
//		int[] b = {10 15 13 17 10 7 0 16 8 13 11 8 14 13};
//
//		int result = twoStacks(x, a, b);
//		return result;
//	}
//	private static int casef3() {
//		int x = 55;
//		int[] a = {11 6 1 13 14 7 8 10 3 17 7 18 6 4 5 13 17 4 16 9 17 16 12 6 7};
//		int[] b = {10 15 13 17 10 7 0 16 8 13 11 8 14 13};
//
//		int result = twoStacks(x, a, b);
//		return result;
//	}
//	private static int casef3() {
//		int x = 55;
//		int[] a = {11 6 1 13 14 7 8 10 3 17 7 18 6 4 5 13 17 4 16 9 17 16 12 6 7};
//		int[] b = {10 15 13 17 10 7 0 16 8 13 11 8 14 13};
//
//		int result = twoStacks(x, a, b);
//		return result;
//	}
//	private static int casef3() {
//		int x = 55;
//		int[] a = {11 6 1 13 14 7 8 10 3 17 7 18 6 4 5 13 17 4 16 9 17 16 12 6 7};
//		int[] b = {10 15 13 17 10 7 0 16 8 13 11 8 14 13};
//
//		int result = twoStacks(x, a, b);
//		return result;
//	}
//	private static int casef3() {
//		int x = 55;
//		int[] a = {11 6 1 13 14 7 8 10 3 17 7 18 6 4 5 13 17 4 16 9 17 16 12 6 7};
//		int[] b = {10 15 13 17 10 7 0 16 8 13 11 8 14 13};
//
//		int result = twoStacks(x, a, b);
//		return result;
//	}
//	

	// 5
	private static int case1() {
		int x = 10;
		int[] a = { 1, 2, 4, 6, 1 };
		int[] b = { 2, 1, 8, 5 };
		int result = twoStacks(x, a, b);
		return result;
	}

	// 4
	private static int case2() {
		int x = 10;
		int[] a = { 4, 2, 4, 6, 1 };
		int[] b = { 2, 1, 8, 5 };

		int result = twoStacks(x, a, b);
		return result;
	}

}
