package m2j.strings;

/**
 * @author M2J
 * @see https://www.hackerrank.com/challenges/weighted-uniform-string/problem
 *
 */
public class WeightedUniformStrings {

	static String[] weightedUniformStrings(String s, int[] queries) {
		int[] values = getCumulativeValues(s);
		return compare(queries, values);
	}

	static String[] compare(int[] queries, int[] values) {
		String[] weightedUniformStrings = new String[queries.length];

		for (int i = 0; i < queries.length; i++) {
			for (int j = 0; j < values.length; j++) {
				if (queries[i] == values[j]) {
					weightedUniformStrings[i] = "Yes";
					break;
				} else {
					weightedUniformStrings[i] = "No";
				}
			}
		}
		return weightedUniformStrings;
	}

	static int[] getCumulativeValues(String s) {
		int[] values = new int[s.length()];

		int start = s.charAt(0);
		values[0] = (int) start - 96;
		for (int i = 1; i < s.length(); i++) {
			char next = s.charAt(i);
			if (start == next) {
				values[i] = values[i - 1] + (int) next - 96;
			} else {
				values[i] = (int) next - 96;
				start = s.charAt(i);
			}
		}
		return values;
	}

	public static void main(String[] args) {

		/*
		 * aaabbbbcccddd ::5 9 7 8 12 5
		 */
		/*
		 * Yes No Yes Yes No
		 */

		String s = "aaabbbbcccddd";
		int[] queries = { 9, 7, 8, 12, 5 };

		String[] res = weightedUniformStrings(s, queries);
		for (String string : res) {
			System.out.println(string);
		}
	}
}
