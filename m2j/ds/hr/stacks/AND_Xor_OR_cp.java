package m2j.ds.hr.stacks;

import java.util.Stack;

public class AND_Xor_OR_cp {
	static int andXorOr(int[] array) {
		int result = Integer.MIN_VALUE;
		Stack<Integer> stack = new Stack<Integer>();
		
		for (int number : array) {
			while (!stack.empty()) {
				result = Math.max(result, stackBitWise(number, stack.peek()));

				if (number < stack.peek()) {
					stack.pop();
				} else {
					break;
				}
			}

			stack.push(number);
		}
		return result;
	}

	private static int stackBitWise(int number, Integer peek) {
		return ((number & peek) ^ (number | peek)) & (number ^ peek);
	}

	public static void main(String[] args) {
		int[] a = { 9, 6, 3, 5, 2 };//15
		int result = andXorOr(a);
		System.out.println(result);
	}
}
