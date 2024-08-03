package m2j.ds.hr.stacks;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author m2j
 * @see https://www.hackerrank.com/challenges/simple-text-editor/problem
 * 
 *
 */
public class SimpleTextEditorTIMECOMPLEXITYFAILED {

	static Stack<String> stack = new Stack<String>();

	public static void main(String[] args) {
		String track = "";
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			int type = sc.nextInt();
			if (type == 1) {
				String w = sc.next();
				track = track.concat(w);
				stack.push(track);
			}

			if (type == 2) {
				int k = sc.nextInt();
				track = track.substring(0, track.length() - k);
				stack.push(track);
			}

			if (type == 3) {
				int k = sc.nextInt();
				System.out.println(track.charAt(k - 1));
			}

			if (type == 4) {
				stack.pop();
				track = stack.peek();
			}
		}

	}

}
