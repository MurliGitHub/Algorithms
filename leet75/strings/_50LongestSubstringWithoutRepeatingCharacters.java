package m2j.da.leet75.strings;

import java.util.HashSet;
import java.util.Set;

/**
 * @see https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 *      Example 1:
 * 
 *      Input: s = "abcabcbb" Output: 3 Explanation: The answer is "abc", with
 *      the length of 3. Example 2:
 * 
 *      Input: s = "bbbbb" Output: 1 Explanation: The answer is "b", with the
 *      length of 1. Example 3:
 * 
 *      Input: s = "pwwkew" Output: 3 Explanation: The answer is "wke", with the
 *      length of 3. Notice that the answer must be a substring, "pwke" is a
 *      subsequence and not a substring.
 * 
 * 
 */
public class _50LongestSubstringWithoutRepeatingCharacters {
	
	public static void main(String[] args) {
		// Input: s = "abcabcbb" Output: 3
		
		String s1 = "abcabcbb";
		System.out.println("Input for s1: abcabcbb, expected output is: 3 & The final response is: "+lengthOfLongestSubstring(s1));
		
		String s2 = "bbbbb";
		System.out.println("Input for s2: bbbbb, expected output is: 1 & The final response is: "+lengthOfLongestSubstring(s2));
		
		String s3 = "pwwkew";
		System.out.println("Input for s3: pwwkew, expected output is: 3 & The final response is: "+lengthOfLongestSubstring(s3));

	}

	private static int lengthOfLongestSubstring(String s) {
		int len = 0;
		int l=0;
		
		Set<Character> subSet = new HashSet<>();
		
		
		for (int i = 0; i < s.length(); i++) {
			
			char currChar = s.charAt(i);
			
			while(subSet.contains(currChar)) {
				subSet.remove(s.charAt(l++));
			}
			
			subSet.add(currChar);
			
			len = Math.max(len, i-l+1);
		}

		return len;
	}

}
