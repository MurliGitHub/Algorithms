package m2j.strings;

import java.util.ArrayList;
import java.util.List;

/**
 * @author M2J
 * @see https://www.hackerrank.com/challenges/pseudo-isomorphic-substrings/
 *      problem
 * 
 *
 */
public class PseudoIsomorphicSubstrings {

	/*
	 * Complete the pseudoIsomorphicSubstrings function below.
	 */
	static int[] pseudoIsomorphicSubstrings(String s) {
		int[] response = new int[s.length()];

		//String[] subStrArray = buildSubStrings(s);
		List<String> listSub = buildSubStringList(s);
		
		boolean iso = isIsomorphic("a", "ab");
		System.out.println("iso::: "+iso);

		return response;
	}

	private static String[] buildSubStrings(String s) {
		int n = s.length();
		int arrayLen = (n*(n+1))/2;
		String[] subStrs = new String[arrayLen];
		
		for (int i = 0; i < n; i++) {
		}
		
		return subStrs;
	}
	
	private static List<String> buildSubStringList(String s) {
		int n = s.length();
		
		List<String> list = new ArrayList<String>();
		
		for (int i = 0; i < n; i++) {
			for (int j = i+1; j <= n; j++) {
				list.add(s.substring(i,j));
			}
			
		}
		
		for (String sl: list) {
			System.out.print(sl+" ");
		}
		System.out.println();
		System.out.println(list.size());
		
		return list;
	}

	static boolean isIsomorphic(String s1, String s2) {
		if (s1 == null || s2 == null || s1.length() != s2.length())
			return false;
		int[] cc1 = new int[256];
		int[] cc2 = new int[256];

		int n = s1.length();

		for (int i = 0; i < n; ++i) {
			char ch1 = s1.charAt(i);
			char ch2 = s2.charAt(i);

			if (cc1[ch1] != cc2[ch2])
				return false;

			cc1[ch1] = i + 1;
			cc2[ch2] = i + 1;
		}

		return true;
	}

	public static void main(String[] args) {

		String s = "abbabab";// out-> 1,2,4,6,9,12,15

		int[] result = pseudoIsomorphicSubstrings(s);
	}
}
