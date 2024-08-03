package m2j.da.leet75.strings;

import java.util.Set;
import java.util.TreeSet;

public class _53ValidAnagram {
public boolean isAnagram(String s1, String s2) {
		
		if(s1 == null || s2 == null || s1.length() != s2.length()) return false;
		
		Set<Character> sCharacters = new TreeSet<Character>();
		
		Set<Character> sCharacters2 = new TreeSet<Character>();
		s1 = s1.trim().toLowerCase();
		s2 = s2.trim().toLowerCase();
		
		char[] carray = s1.toCharArray();
		
		char[] carray2 = s2.toCharArray();
		
		for (int i = 0; i < carray.length; i++) {
			sCharacters.add(carray[i]);
		}
		
		for (int i = 0; i < carray2.length; i++) {
			sCharacters2.add(carray2[i]);
		}
		
		if(sCharacters.equals(sCharacters2)) return true;
		
		return false;
	}
}
