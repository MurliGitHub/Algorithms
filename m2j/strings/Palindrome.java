package m2j.strings;

public class Palindrome {
	static boolean isPalindrome(String s) {
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
	public static void main(String[] args) {
		System.out.println(isPalindrome("Madam"));
	}
}
