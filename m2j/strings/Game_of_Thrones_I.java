package m2j.strings;

/**
 * @author M2J
 * @see https://www.hackerrank.com/challenges/game-of-thrones/problem
 * 
 *
 */
public class Game_of_Thrones_I {

	static String gameOfThrones(String s) {
		String status = "NO";
		int oddCount = 0;
		int charCount[] = new int[26];
		for (char ch : s.toCharArray()) {
			charCount[ch - 'a']++;
		}

		for (int i : charCount) {
			if (i % 2 == 1) {
				oddCount++;
			}
		}
		if (oddCount <= 1) {
			status = "YES";
		}
		return status;
	}

	public static void main(String[] args) {
		String s = "aaabbbb";// YES
		// String s = "cdefghmnopqrstuvw";//NO
		// String s = "cdcdcdcdeeeef";//YES

		String result = gameOfThronesBF(s);
		System.out.println(result);
	}

	static String gameOfThronesBF(String s) {
		String status = "NO";
		int oddCount = 0;
		int charCount[] = new int[26];
		for (char ch : s.toCharArray()) {
			charCount[ch - 'a']++;
		}

		for (int i : charCount) {
			System.out.print(i + " ");

			if (i % 2 == 1) {
				oddCount++;
			}
		}
		if (oddCount <= 1) {
			status = "YES";
		}
		System.out.println();
		System.out.println("======================");
		System.out.println(oddCount);
		return status;
	}

}
