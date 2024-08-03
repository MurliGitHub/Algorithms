package m2j.da.leet75.strings;

/**
 * @see https://leetcode.com/problems/minimum-window-substring/description/
 *      
 *      Given two strings s and t of lengths m and n respectively, return the minimum window 
substring
 of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

The testcases will be generated such that the answer is unique.
 *      
 *      Example 1:
 * 
 *      Input: s = "ADOBECODEBANC", t = "ABC" Output: "BANC" Explanation: The
 *      minimum window substring "BANC" includes 'A', 'B', and 'C' from string
 *      t. Example 2:
 * 
 *      Input: s = "a", t = "a" Output: "a" Explanation: The entire string s is
 *      the minimum window. Example 3:
 * 
 *      Input: s = "a", t = "aa" Output: "" Explanation: Both 'a's from t must
 *      be included in the window. Since the largest window of s only has one
 *      'a', return empty string.
 * 
 */
public class _52MinimumWindowSubstring {
	public static void main(String[] args) {
		
		String s = "ADOBECODEBANC", t = "ABC";
		
		System.out.println("1. Expected BANC, output is: "+ minWindow(s, t));

		String s2 = "a", t2 = "a";
		
		System.out.println("2. Expected a, output is: "+ minWindow(s2, t2));
		
		String s3 = "a", t3 = "aa";
		
		System.out.println("3. Expected Empty, output is: "+ minWindow(s3, t3));

	}

	private static String minWindow(String s, String t) {
		return null;
	}
}
