package m2j.strings;

import java.util.HashSet;
import java.util.Set;

/**
 * @author M2J
 *
 */
public class MakingAnagrams {
	
	static int makingAnagrams(String s1, String s2) {
		final Integer CHARS = 26;
		int charCount1[] = new int[CHARS];
		int charCount2[] = new int[CHARS];
		
		for (char ch: s1.toCharArray()){
			charCount1[ch-'a']++;
		}
		
		for (char ch: s2.toCharArray()){
			charCount2[ch-'a']++;
		}
		int charToDeleteCount = 0;
		for (int i = 0; i < CHARS; i++) {
			charToDeleteCount += Math.abs(charCount1[i]-charCount2[i]);
		}
		
		return charToDeleteCount;
	}

	public static void main(String[] args) {
	/*	String s1 = "cde";
		String s2 = "abc";//ans-> 4
*/		
		String s1 = "absdjkvuahdakejfnfauhdsaavasdlkj";
		String s2 = "djfladfhiawasdkjvalskufhafablsdkashlahdfa";//ans-> 19
		
	/*	String s1 = "abc";
		String s2 = "amnop";//ans-> 6
*/		int result = makingAnagrams(s1, s2);
		System.out.println(result);
	}

	static int makingAnagramsBF(String s1, String s2) {
		
		Set<Character> setChar1 = new HashSet<>();
		Set<Character> setChar2 = new HashSet<>();
		
		/*for (char ch: s1.toCharArray()) {
			setChar1.
		}*/
		
		int count =0;
		
		
		for (int i = 0; i < s1.length(); i++) {
			for (int j = 0; j < s2.length(); j++) {
				if(s1.charAt(i) == s2.charAt(j)){
					count++;
				}
			}
		}
		
		System.out.println(count);
		
		if(count != 0)
			return Math.abs(s1.length()+s2.length())-(2*count);
		
		return 0;
	}

}
