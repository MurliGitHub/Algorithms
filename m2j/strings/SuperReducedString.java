package m2j.strings;

/**
 * @author M2J
 * @see https://www.hackerrank.com/challenges/reduced-string/problem
 *
 */
public class SuperReducedString {

	private static String superReducedString(String s) {

		return "Empty String";
	}

	static String solveCopied(String input) {
		char[] remains = new char[input.length()];
		int top = -1; // highest valid index

		for (char c : input.toCharArray())
			if (top < 0 || c != remains[top])
				remains[++top] = c;
			else
				--top;

		return top < 0 ? "Empty String" : new String(remains, 0, top + 1);
	}

	static String superReducedStringMJ(String s) {

		int k = 0;
		while (s.length() - 1 > k) {
			if (s.charAt(k) == s.charAt(k + 1)) {
				s = removePair(s, k);
				k = 0;
			} else {
				k++;
			}

		}

		if (s.length() < 1) {
			return "Empty String";
		} else {
			return s;
		}
	}

	static String superReducedStringBF(String s) {

		int k = 0;
		String sbstr = s;
		for (int i = 1; i < sbstr.length(); i++) {
			while (sbstr.length() - 1 > 0) {
				if (k == i)
					break;
				if (sbstr.charAt(k) == sbstr.charAt(i)) {
					sbstr = removePair(sbstr, i);
					break;
				} else {
					k++;
					continue;
				}
			}

		}

		if (sbstr.length() < 1 || (sbstr.charAt(0) == sbstr.charAt(1))) {
			return "Empty String";
		} else {
			return sbstr;
		}
	}

	private static String removePair(String sbstr, int k) {
		String newStr = "";

		for (int i = 0; i < sbstr.length(); i++) {
			if (i == k || i == k + 1) {
				continue;
			} else {
				newStr += sbstr.charAt(i);
			}
		}
		return newStr;
	}

	public static void main(String[] args) {
		// aaabccddd-> abd
		// baab -> Empty
		// aa-> Empty

		String[] arr = { "aaabccddd", "baab", "aa" };
		for (String s : arr) {
			System.out.println(superReducedStringMJ(s));
		}

		// System.out.println(superReducedStringMJ("baab"));

	}

}
