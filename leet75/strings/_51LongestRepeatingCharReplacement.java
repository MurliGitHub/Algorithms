package m2j.da.leet75.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * @see https://leetcode.com/problems/longest-repeating-character-replacement/description/
 *      Example 1:
 * 
 *      Input: s = "ABAB", k = 2 Output: 4 Explanation: Replace the two 'A's
 *      with two 'B's or vice versa. Example 2:
 * 
 *      Input: s = "AABABBA", k = 1 Output: 4 Explanation: Replace the one 'A'
 *      in the middle with 'B' and form "AABBBBA". The substring "BBBB" has the
 *      longest repeating letters, which is 4. There may exists other ways to
 *      achieve this answer too.
 * 
 * 
 *      Constraints:
 * 
 *      1 <= s.length <= 105 s consists of only uppercase English letters. 0 <=
 *      k <= s.length
 * 
 */
public class _51LongestRepeatingCharReplacement {
	public static void main(String[] args) {
		String s1 = "ABAB";
		int k1 = 2;
		int longestLen = longestRepeatingCharReplacement(s1, k1);
		System.out.println("Expected Output: 4 & Result longestLen1: " + longestLen);

		String s2 = "AABABBA";
		int k2 = 1;
		int longestLen2 = longestRepeatingCharReplacement(s2, k2);
		System.out.println("Expected Output: 4 & Result longestLen2: " + longestLen2);
	}

	private static int longestRepeatingCharReplacement(String s, int k) {

		int maxCount = 0, maxLength = 0, l = 0;
		Map<Character, Integer> charCount = new HashMap<>();

		for (int r = 0; r < s.length(); r++) {
			char rChar = s.charAt(r);
			
			charCount.put(rChar, charCount.getOrDefault(rChar, 0)+1);
			
			maxCount = Math.max(maxCount, charCount.get(rChar));
			
			while(r-l+1-maxCount > k) {
				char lChar = s.charAt(l);
				charCount.put(lChar, charCount.get(lChar)-1);
				l++;
			}
			
			maxLength = Math.max(maxLength, r-l+1);
		}

		return maxLength;
	}

}
