package m2j.strings;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import m2j.utility.CommonUtil;

/**
 * @author M2J
 * @see https://www.hackerrank.com/challenges/sherlock-and-anagrams/problem
 *
 *
 */
public class SherlockAndAnagrams {

	static int sherlockAndAnagrams(String s) {
		int[] charSCount = charsCount(s);
		// int countVal = charSCount[1]- charSCount[0];
		boolean isSherAnaPossible = false;

		for (int i = 0; i < charSCount.length; i++) {
			if (charSCount[i] == 1 || charSCount[i] == 0) {
				isSherAnaPossible = false;
			} else {
				isSherAnaPossible = true;
				break;
			}
		}

		CommonUtil.print(charSCount);
		System.out.println("isSherAnaPossible: " + isSherAnaPossible);
		// if(countVal==s.length()){
		/// return 0;
		// }

		return 0;
	}

	private static int[] charsCount(String s) {
		int[] charCount = new int[26];
		for (char c : s.toCharArray()) {
			charCount[c - 'a']++;
		}
		return charCount;
	}

	private static boolean isAnagram(int[] countSubStr1, int[] countSubStr2) {
		for (int i = 0; i < countSubStr1.length; i++) {
			if (countSubStr1[i] != countSubStr2[i]) {
				return false;
			}
		}
		return true;
	}



	public static void main(String[] args) {
		// 5,3,10,4,0
		/*
		 * String[] arr = {"cdcd","ifailuhkqq","kkkk","abba","abcd"}; for
		 * (String s: arr) { System.out.println(sherlockAndAnagrams(s)); }
		 */

		// "abcd" ->0
		System.out.println(sherlockAndAnagramsBruteForec("ad"));

		// "abba" ->4
		System.out.println(sherlockAndAnagramsBruteForec("abba"));
	}
	static int sherlockAndAnagramsBF(String s) {
		int[] charSCount = charsCount(s);
		return 0;
	}

	static int sherlockAndAnagramsBruteForec(String s) {
		/*boolean isPoss = isSherAnaPosible(s);
		System.out.println("IsSherAnaPosible:: "+ isPoss);
		if (isPoss) {*/
			return countPairs(s);
		//}
		

	//	return 0;
	}

	static List<Character[]> buildPairs(String str) {
		List<Character[]> list = new LinkedList<>();
		for (int i = 0; i < str.length() - 1; i++) {
			for (int j = i + 1; j < str.length(); j++) {
				list.add(new Character[] { str.charAt(i), str.charAt(j) });
			}
		}
		return list;
	}

	private static boolean isSherAnaPosible(String s) {
		if(s.length()<2) return false;

		int[] charSCount = charsCount(s);
		boolean isSherAnaPossible = false;

		for (int i = 0; i < charSCount.length; i++) {
			if (charSCount[i] == 1 || charSCount[i] == 0) {
				isSherAnaPossible = false;
			} else {
				return true;
			}
		}
		return isSherAnaPossible;
	}
	
	 private static int countPairs(String text) {
	        int length = text.length();
	        List<int[]> subsets = new ArrayList<>();
	        for (int i = 0; i < length; i++) {
	            for (int j = i + 1; j <= length; j++) {
	                subsets.add(charsCount(text.substring(i, j)));
	            }
	        }
	        
	        for (int[] in : subsets) {
	        	for (int i = 0; i < in.length; i++) {
					System.out.print(in[i]+" ");
				}
	        	System.out.println();
			}

	        int count = 0;
	        for (int i = 0; i < subsets.size(); i++) {
	            int[] countSub1 = subsets.get(i);
	            for (int j = i + 1; j < subsets.size(); j++) {
	                int[] countSub2 = subsets.get(j);
	                if (countSub1.length == countSub2.length && isAnagram(countSub1, countSub2)) {
	                    count++;
	                }
	            }
	        }

	        return count;
	    }
}
