package m2j.strings;

import java.util.Arrays;

import m2j.utility.CommonUtil;

/**
 * @author M2J
 * @see https://www.hackerrank.com/challenges/funny-string/problem
 *
 */
public class FunnyString {

	static String funnyString(String s) {

		String status = "Funny";
		return "Not Funny";
	}

	public static void main(String[] args) {
		String s = "acxz";// Funny
		// String s = "bcxz";//Not Funny
		String result = funnyStringBF(s);
		System.out.println(result);
	}

	static String funnyStringBF(String s) {

		int[] ass = getAscii(s);
		int[] assDiff = getAscDiff(ass);

		String reversedStr = reverse(s);

		int[] revAss = getAscii(reversedStr);

		int[] revAssDiff = getAscDiff(revAss);

		if (Arrays.equals(assDiff, revAssDiff))
			return "Funny";

		return "Not Funny";
	}

	private static int[] getAscDiff(int[] ass) {
		int[] diff = new int[ass.length - 1];

		for (int i = 0; i < ass.length - 1; i++) {
			diff[i] = Math.abs(ass[i] - ass[i + 1]);
		}
		return diff;
	}

	private static int[] getAscii(String s) {
		int[] ass = new int[s.length()];
		int i = 0;
		for (char ch : s.toCharArray()) {
			ass[i] = (int) ch;
			i++;
		}
		return ass;
	}

	private static String reverse(String str) {

		String rev = "";
		for (int i = str.length() - 1; i >= 0; i--) {
			rev += str.charAt(i);
		}
		return rev;
	}

}
