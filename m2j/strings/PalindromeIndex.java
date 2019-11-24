package m2j.strings;

/**
 * @author M2J
 * @see https://www.hackerrank.com/challenges/palindrome-index/problem
 *
 */
public class PalindromeIndex {
	// Complete the palindromeIndex function below.
	static int palindromeIndex(String s) {
		int len = s.length();
		int i = 0, j = len - 1, statusIndex = -1;

		while (j > i) {
			if (s.charAt(i) == s.charAt(j)) {
				i++;
				j--;
			} else if (j > 0 && s.charAt(i) == s.charAt(j - 1)) {
				return j;
				// j--;
			} else if (i < len && s.charAt(i + 1) == s.charAt(j)) {
				return i;
				// i++;
			}
		}
		return statusIndex;
	}

	public static void main(String[] args) {
		//String s = "aaab";// 3
		 String s = "baa";//0
		// String s = "aaa";// -1

		int result = palindromeIndexBruteForce(s);
		System.out.println(result);
	}

	// Complete the palindromeIndex function below.
	static int palindromeIndexBruteForce(String s) {

		int statusIndex = -1;

		if (isPalindrome(s))
			return statusIndex;
		else {
			int i = 0;
			int j = s.length() - 1;

			while (i < j) {
				if (s.charAt(i) == s.charAt(j)) {
					i++;
					j--;
				}

				if (isPalindrome2(s.substring(0, i) + s.substring(i+1)))
					return i;
				if (isPalindrome2(s.substring(0, j) + s.substring(j+1)))
					return j;

			}

		}
		return statusIndex;
	}

	private static boolean isPalindrome(String s) {
		s = s.toLowerCase();
		int i = 0;
		int j = s.length() - 1;

		while (j > i) {
			if (s.charAt(i) == s.charAt(j)) {
				i++;
				j--;
			} else {
				return false;
			}
		}

		return true;
	}

	static boolean isPalindrome2(String str) {

		int n = str.length();
		for (int i = 0; i < n / 2; i++)
			if (str.charAt(i) != str.charAt(n - i - 1))
				return false;
		return true;
	}
}
