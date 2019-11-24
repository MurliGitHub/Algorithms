package m2j.strings;

/**
 * @author M2J
 * @see https://www.hackerrank.com/challenges/anagram/problem
 * 
 *
 */
public class Anagram {

	static int anagram(String s) {

		if (s.length() % 2 == 1)
			return -1;

		int[] charCount1 = charCount(s.substring(0, s.length() / 2));
		int[] charCount2 = charCount(s.substring((s.length() / 2), s.length()));

		int count = 0;

		for (int i = 0; i < 26; i++) {
			if (charCount1[i] < charCount2[i]) {
				count += charCount2[i] - charCount1[i];
			}

		}
		return count;

	}

	public static void main(String[] args) {
		// String s ="aaabbb";
		// String s ="ab";
		// String s ="abc";
		// String s ="mnop";//2
		// String s = "xyyx";// 0
		// String s ="xaxbbbxx";//1

		String s = "fdhlvosfpafhalll";// 5

		int result = anagramBF(s);
		System.out.println(result);

	}

	/**
	 * BruteForce
	 * 
	 * @param s
	 * @return
	 */
	static int anagramBF(String s) {
		return 0;
	}

	private static int[] charCount(String s) {
		int[] charCount = new int[26];
		for (char ch : s.toCharArray()) {
			charCount[ch - 'a']++;
		}
		return charCount;
	}
}
