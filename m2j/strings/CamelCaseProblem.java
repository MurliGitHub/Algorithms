package m2j.strings;

import java.io.IOException;

public class CamelCaseProblem {

	static int camelcaseNaive(String s) {

		int camelCount = s.isEmpty() ? 0 : 1;

		for (int i = 0; i < s.length(); i++) {
			if (Character.isUpperCase(s.charAt(i))) {
				camelCount++;
			}
		}
		return camelCount;
	}

	static int camelcaseJava7(String s) {

		int camelCount = s.isEmpty() ? 0 : 1;

		for (char c : s.toCharArray()) {
			if (Character.isUpperCase(c)) {
				camelCount++;
			}
		}
		return camelCount;
	}

	private static int camelcase8(String in) {

		int words = (int) (in.isEmpty() ? 0 : 1 + in.chars().filter(Character::isUpperCase).count());
		return words;
	}

	private static int count(String s) {
		int camelCount = (int) (s.isEmpty() ? 0 : 1 + s.chars().filter(Character::isUpperCase).count());
		return camelCount;
	}

	private static int camelCaseCountByASCII(String str) {
		int count = 1;

		for (int i = 1; i < str.length() - 1; i++) {
			if (str.charAt(i) >= 65 && str.charAt(i) <= 90)
				count++;
		}

		return count;
	}

	/*
	 * public static long getCamelCaseWordCountStreams(String in) { return
	 * in.isEmpty() ? 0 : 1 + in.chars().filter(Character::isUpperCase).count();
	 * }
	 */

	// private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		// System.out.println("Enter the String in camelCase:::");
		// String s = scanner.nextLine();
		String s = "helloWorldMJ";

		System.out.println("Input String is: " + s);

		int result = camelcase8(s);
		System.out.println("Count of camel case is: " + result);

		// scanner.close();
	}
}
