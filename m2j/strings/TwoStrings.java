package m2j.strings;

import java.util.HashSet;
import java.util.Set;

/**
 * @author M2j
 *
 *The words "a", "and", "art" share the common substring .
 *
 *The words "be" and "cat" do not share a substring.
 */
public class TwoStrings {
	// Complete the twoStrings function below.
    static String twoStrings(String s1, String s2) {
    	String status = "NO";
    	Set<Character> s1Sets = new HashSet<>();
    	Set<Character> s2Sets = new HashSet<>();
    	for (int i = 0; i < s1.length(); i++) {
			s1Sets.add(s1.charAt(i));
		}
    	
    	for (int i = 0; i < s2.length(); i++) {
			s2Sets.add(s2.charAt(i));
		}
    	s1Sets.retainAll(s2Sets);
    	if(!s1Sets.isEmpty()) status = "YES";
    	
		return status;
    }
	public static void main(String[] args) {
		//String s1= "Hello";String s2= "World"; // ans- YES
		String s1= "Hi";String s2= "World"; // ans- No
		String result = twoStringNaive(s1, s2);
		System.out.println("Response is::: "+ result);
	}
	private static String twoStringNaive(String s1, String s2) {
		String status = "NO";
		for (int i = 0; i < s1.length(); i++) {
			for (int j = 0; j < s2.length(); j++) {
				if(s1.charAt(i)==s2.charAt(j)){
					status = "YES";
					break;
				}
					
			}
		}
		return status;
	}

}
