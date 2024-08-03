package m2j.ds.hr.stacks;

import java.util.Stack;

public class GameOfTwoStacks {

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
			if(sum+peeka<=x) {
				sum +=as.pop();
				count++;
			}
			Integer peekb = bs.peek();
			
			if(sum+peekb<=x) {
				sum+=bs.pop();
				count++;
			}else {
				break;
			}
			
		}

//		while (sum <= x) {
//			if (as.empty() && bs.empty())
//				break;
//
//			sum += as.pop();
//			count = count + 1;
//			if (sum > x) {
//				count--;
//				break;
//			} else {
//				sum += bs.pop();
//				count = count + 1;
//			}
//		}
		return count;
	}

	private static void getStack(int[] a, Stack<Integer> stack) {
		for (int i = a.length - 1; i >= 0; i--) {
			stack.push(a[i]);
		}
	}

	public static void main(String[] args) {
		int x = 10;
//		int[] a = { 4, 2, 4, 6, 1 };
//		int[] b = { 2, 1, 8, 5 };
		
		int[] a = { 1, 2, 4, 6, 1 };
		int[] b = { 2, 1, 8, 5 };
		int result = twoStacks(x, a, b);
		System.out.println(result);
	}

}
