package m2j.ds.hr.stacks;

import java.io.IOException;
import java.util.Stack;

public class BalancedBrackets {

	// Complete the isBalanced function below.
	static String isBalanced(String s) {
		Stack<Character> stack = new Stack<Character>();

		for (char ch : s.toCharArray()) {

			if (ch == '[' || ch == '{' || ch == '(') {
				stack.push(ch);
			}

			if (ch == ']' || ch == '}' || ch == ')') {
				if (stack.isEmpty())
					return "NO";
				else if (!isPairMatch(stack.pop(), ch)) {
					return "NO";
				}
			}
		}

		if (stack.isEmpty())
			return "YES";

		return "NO";
	}

//	private static final Scanner scanner = new Scanner(System.in);

	private static boolean isPairMatch(char popped, char c) {
		if (popped == '(' && c == ')') {
			return true;
		} else if (popped == '{' && c == '}') {
			return true;
		} else if (popped == '[' && c == ']') {
			return true;
		}
		return false;
	}

	public static void main(String[] args) throws IOException {
//		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//		int t = scanner.nextInt();
//		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//		for (int tItr = 0; tItr < t; tItr++) {
//			String s = scanner.nextLine();

		String[] sarr = { "{[()]}", "{[(])}", "{{[[(())]]}}" };

		for (String s : sarr) {
			String result = isBalanced(s);
			System.out.println(result);
		}

//			bufferedWriter.write(result);
//			bufferedWriter.newLine();
//		}
//
//		bufferedWriter.close();
//
//		scanner.close();
	}
}
