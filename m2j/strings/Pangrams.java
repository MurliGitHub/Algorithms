package m2j.strings;

import java.util.HashSet;
import java.util.Set;

/**
 * @author M2J
 * @see https://www.hackerrank.com/challenges/pangrams/problem
 *
 */
public class Pangrams {

	private static String pangrams(String s) {
		String status = "not pangram";
		s = s.toLowerCase();
		int alphabetCount = 0;
		int charCount[] = new int[26];
		for (char ch : s.toCharArray()) {
			if(!Character.isWhitespace(ch))
				charCount[ch - 'a']++;
		}
		System.out.println("+++");
		for (int i : charCount) {
			if(i!=0)
				alphabetCount++;
		}
		
		if(alphabetCount == 26){
			status = "pangram";
		}
		return status;
	}

	public static void main(String[] args) {
		String s = "We promptly judged antique ivory buckles for the prize";// not pangram
		//String s = "The quick brown fox jumps over the lazy dog";//pangram
		
		String result = pangrams(s);
		System.out.println(result);

	}

	private static String pangramsBF(String s) {
		s= s.toLowerCase();
		char[] charArr = s.toCharArray();
		Set<Character> set = new HashSet<>();
		for (char c: charArr) {
			if(!Character.isWhitespace(c))
				set.add(c);
		}
		System.out.println(set.size());
		if(set.size() ==26){
			return "pangram";
		}
		return "not pangram";
	}

}
