package m2j.ds.hr.stacks;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author m2j
 * @see https://www.hackerrank.com/challenges/maximum-element/problem
 * 
 *
 */
public class MaximumElement {

	static Stack<Integer> stack = new Stack<Integer>();

	static Stack<Integer> maxStack = new Stack<Integer>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			int type = sc.nextInt();
			if (type == 1) {
				int x = sc.nextInt();
				stack.push(x);
				if (maxStack.isEmpty() || x >= maxStack.peek()) {
					maxStack.push(x);
				}
			}

			if (type == 2) {
				int pop = stack.pop();
				if (pop == maxStack.peek()) {
					maxStack.pop();
				}
			}

			if (type == 3) {
				System.out.println(maxStack.peek());
			}
		}

	}

}
