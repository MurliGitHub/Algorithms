package m2j.strings;

import java.util.LinkedList;
import java.util.List;

/**
 * @author M2j
 * @see https://www.hackerrank.com/challenges/two-characters/problem
 * 
 *
 */
public class TwoCharacters {
	private static int alternateU(String s) {

		String uniqueChars = getUniqueChars(s);

		List<Character[]> pairs = buildPairs(uniqueChars);

		int maxLength = 0;

		for (Character[] pair : pairs) {
			String substr = s;
			for (Character c : uniqueChars.toCharArray()) {
				if (c != pair[0].charValue() && c != pair[1].charValue()) {
					substr = substr.replaceAll(String.valueOf(c), "");
				}

				int length = alternateCharLength(substr, pair);
				maxLength = Math.max(maxLength, length);
			}
		}

		return maxLength;
	}

	private static int alternateCharLength(String substr, Character[] pair) {
		if (substr.length() == 0)
			return 0;
		char start = substr.charAt(0);
		char next = pair[0] == start ? pair[1] : pair[0];

		for (int i = 0; i < substr.length(); i++) {
			if ((i % 2 == 1 && substr.charAt(i) == next) || (i % 2 == 0 && substr.charAt(i) == start)) {
				continue;
			} else {
				return 0;
			}
		}
		return substr.length();
	}

	static List<Character[]> buildPairs(String uniqueCharsStr) {
		List<Character[]> list = new LinkedList<>();
		for (int i = 0; i < uniqueCharsStr.length() - 1; i++) {
			for (int j = i + 1; j < uniqueCharsStr.length(); j++) {
				list.add(new Character[] { uniqueCharsStr.charAt(i), uniqueCharsStr.charAt(j) });
			}
		}
		return list;
	}

	private static String getUniqueChars(String s) {
		String uniqueStr = "";
		boolean[] uniqueCharFlag = new boolean[26];
		for (int i = 0; i < s.length(); i++) {
			uniqueCharFlag[s.charAt(i) - 'a'] = true;
		}

		for (int i = 0; i < uniqueCharFlag.length; i++) {
			if (uniqueCharFlag[i]) {
				char u = (char) ((char) i + 'a');
				uniqueStr += u;
			}
		}
		return uniqueStr;
	}

	public static void main(String[] args) {
		String s = "beabeefeab";// ans 5
		// String s = "asdcbsdcagfsdbgdfanfghbsfdab";
		int result = alternateU(s);
		System.out.println(result);
	}

	private static int alternate(String s) {
		String response = findTwoChar(s);
		return response.length();
	}

	private static String findTwoChar(String s) {

		char[] charArray = s.toCharArray();

		int k = 0;

		char duplicate = 0;
		for (int i = 1; i < charArray.length; i++) {
			if (charArray[k] == charArray[i]) {
				duplicate = charArray[k];
			}
			k++;
		}

		s = removeChar(s, duplicate);
		System.out.println(" " + s);
		int j = 0;
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(j) == s.charAt(i)) {
				s = findTwoChar(s);
			}
			j++;
		}
		int u = 1;
		int uc = 0;
		int index = -1;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != s.charAt(u) && uc < 2) {
				uc++;
				u++;
				continue;
			} else {
				index = u;
				u++;
				break;
			}

		}

		if (index != -1)
			s = removeChar(s, s.charAt(index));

		System.out.println(" " + s);

		return s;
	}

	private static String removeChar(String string, char ch) {
		String str = "";
		for (int i = 0; i < string.length(); i++) {
			if (string.charAt(i) != ch) {
				str += string.charAt(i);
			}
		}
		return str;
	}

}
