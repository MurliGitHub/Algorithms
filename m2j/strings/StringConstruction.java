package m2j.strings;

import java.util.HashSet;
import java.util.Set;

/**
 * @author M2J
 * @see https://www.hackerrank.com/challenges/string-construction/problem 
 *
 */
public class StringConstruction {
	
	private static int stringConstruction(String s) {
		Set<Character> sCharacters = new HashSet<>();
		for (int i = 0; i < s.length(); i++) {
			sCharacters.add(s.charAt(i));
		}
		return sCharacters.size();
	}
	
	public static void main(String[] args) {
		//String s ="abcd";//4
		String s ="abab";//2
		int result = stringConstruction(s);
		System.out.println("Response is:: "+ result);
	}

	private static int stringConstructionBruteForce(String s) {
		return Integer.MIN_VALUE;
	}

}
