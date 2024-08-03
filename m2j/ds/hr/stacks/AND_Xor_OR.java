package m2j.ds.hr.stacks;

import java.util.Stack;

public class AND_Xor_OR {
	
	static int andXorOr(int[] array) {
		int result = 0;
		
		Stack<Integer> stack = new Stack<Integer>();
		
		for (int number : array) {
			while (!stack.empty()) {
				if (number < stack.peek()) {
					
					int si = stackBitWise(number, stack.peek());
					result = Math.max(result, si);
					
					stack.pop();
				}
			}
			stack.push(number);
		}
		return result;
	}
	
	
	private static int stackBitWise(int number, int peek) {
		return ((number & peek) ^ (number | peek)) & (number ^ peek);
	}
	
	public static void main(String[] args) {
		int[] a = { 9, 6, 3, 5, 2 };//15
		int result = andXorOr(a);
		System.out.println(result);
	}

}
