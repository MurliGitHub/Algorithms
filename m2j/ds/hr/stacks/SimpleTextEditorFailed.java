package m2j.ds.hr.stacks;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author m2j
 * @see https://www.hackerrank.com/challenges/simple-text-editor/problem
 * 
 *
 */
public class SimpleTextEditorFailed {

	static Stack<Character> stack = new Stack<Character>();
	static Stack<String> stackBak = new Stack<String>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			int type = sc.nextInt();
			if (type == 1) {
				String w = sc.next();
				for (char ch : w.toCharArray()) {
					stack.push(ch);
				}
			}

			if (type == 2) {
				int k = sc.nextInt();
				String s= "";
				for (int i1 = 0; i1 < k; i1++) {
					Character pop = stack.pop();
					s.concat(Character.toString(pop));
				}
				System.out.println(s);
				stackBak.push(s);
			}

			if (type == 3) {
				int k = sc.nextInt();
				Character elementAt = stack.elementAt(k);
				System.out.println(elementAt);

			}
			
			if(type == 4) {
				if(!stackBak.isEmpty()) {
					stackBak.pop();
					
				}
				
				//stackBak.peek();
			}
		}

	}

}
