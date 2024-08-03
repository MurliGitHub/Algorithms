package m2j.ds.hr.stacks;

import java.util.Stack;

public class Two {

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
			if (sum + peeka <= x) {
				sum += as.pop();
				count++;
			}
			Integer peekb = bs.peek();

			if (sum + peekb <= x) {
				sum += bs.pop();
				count++;
			} else {
				break;
			}

		}

		return count;
	}

	private static void getStack(int[] a, Stack<Integer> stack) {
		for (int i = a.length - 1; i >= 0; i--) {
			stack.push(a[i]);
		}
	}

	public static void main(String[] args) {
		int result = caseNon();
		System.out.println(result);
	}
	
	//6
	private static int caseNon() {
		int x = 62;
			int[] a = {7, 15, 12, 0, 5, 18, 17, 2, 10, 15, 4, 2, 9, 15, 13, 12, 16};
			int[] b = {12, 16, 6, 8, 16, 15, 18, 3, 11, 0, 17, 7, 6, 11, 14, 13, 15, 6, 18, 6, 16, 12, 16, 11, 16, 11};

		int result = twoStacks(x, a, b);
		return result;
	}

	//4
	private static int case1() {
		int x = 10;
		int[] a = { 1, 2, 4, 6, 1 };
		int[] b = { 2, 1, 8, 5 };
		int result = twoStacks(x, a, b);
		return result;
	}
	
	//5
	private static int case2() {
		int x = 10;
			int[] a = { 4, 2, 4, 6, 1 };
			int[] b = { 2, 1, 8, 5 };

		int result = twoStacks(x, a, b);
		return result;
	}

}
