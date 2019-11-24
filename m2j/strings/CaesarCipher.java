package m2j.strings;

/**
 * @author M2J
 * @see https://www.hackerrank.com/challenges/caesar-cipher-1/problem
 */
public class CaesarCipher {

	// Complete the caesarCipher function below.
	static String caesarCipher(String s, int k) {
		String res = "";
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) >= 97 && s.charAt(i) <= 122) {
				char c = (char) ((s.charAt(i) + k - 97) % 26 + 97);
				res += c;
			} else if (s.charAt(i) >= 65 && s.charAt(i) <= 90) {
				char c = (char) ((s.charAt(i) + k - 65) % 26 + 65);
				res += c;
			} else {
				res += s.charAt(i);
			}
		}

		return res;
	}

	static String caesarCipherBruteForce(String s, int k) {
		return null;
	}

	public static void main(String[] args) {
		String s = "abcdefghijklmnopqrstuvwxyz";
		int k = 2; //

		String response = caesarCipherBruteForce(s, k);
		System.out.println("Caesar Cipher of " + s + " with rotatin " + k + " is:::->");
		System.out.println(response);
	}
}
