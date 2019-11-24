package m2j.strings;

/**
 * @author M2J
 * @see https://www.hackerrank.com/challenges/separate-the-numbers/problem
 *
 */
public class SeparateTheNumbers {

	static void separateNumbers(String s) {
		long response = getSeparateNumbers(s);
		if (response > 0) {
			System.out.println("YES " + response);
		} else {
			System.out.println("NO");
		}
		// System.out.println(response > 0 ? "YES " + response : "NO");
	}

	static long getSeparateNumbers(String s) {
		if (s.charAt(0) == '0') {
			return 0;
		}

		for (int length = 1; length <= s.length() / 2; length++) {
			long firstNumber = Long.parseLong(s.substring(0, length));

			long number = firstNumber;
			String nextStr = "";
			while (nextStr.length() < s.length()) {
				nextStr += String.valueOf(number);
				number++;
			}
			if (nextStr.equals(s)) {
				return firstNumber;
			}
		}
		return 0;
	}

	static long separateNumbersImpl(String s) {

		if (s.charAt(0) == '0') {
			System.out.println("NO");
			return -1;
		}

		boolean isSeparate = true;
		long response = 0;

		for (int i = 0; i < s.length() - 2; i++) {
			int a = s.charAt(i);
			int b = s.charAt(i + 1);
			int c = s.charAt(i + 2);
			if (Math.abs(b - a) == Math.abs(c - b)) {
				response = a;
				continue;
			} else {
				isSeparate = false;
				break;
			}
		}

		System.out.println(isSeparate);
		return response;
	}

	public static void main(String[] args) {
		String[] arr = { "1234", "91011", "99100", "101103", "010203" };
		for (String s : arr) {
			separateNumbers(s);
		}

		// String s = "1234";//YES 1
		/*
		 * String s = "91011";// YES 9 String s = "99100";// YES 99 String s =
		 * "101103";// NO
		 */
		// String s = "010203";// NO

		/*
		 * String s = "99100";// YES 99 separateNumbers(s);
		 */
	}

}
