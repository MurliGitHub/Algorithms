package m2j.strings;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import m2j.utility.CommonUtil;

public class HowMSS {
	

	static int[] countSubstringsBF(String s, int[][] queries) {

		int[] substrCount = new int[queries.length];

		for (int i = 0; i < queries.length; i++) {
			substrCount[i] = getSubStrCount(s, queries[i][0],queries[i][1]);
		}

		return substrCount;
	}
	
	private static int getSubStrCount(String s, int left, int right) {
		if(left == right) return 1;
		return getCount(getSubstring(s,left,right+1));
	}
	private static int getCount(String subStr) {
		
		List<String> subStrList = new ArrayList<>();
		
		for (int i = 0; i < subStr.length(); i++) {
			for (int j = i+1; j <= subStr.length(); j++) {
				subStrList.add(getSubstring(subStr, i, j));
			}
		}
		
		
		int dupCount = getDuplicateCount(subStrList);
		
		int n = subStr.length();
		
		int ans = (n*(n+1))/2;
		
		return ans-dupCount;
	}

	private static int getDuplicateCount(List<String> subStrList) {
		Set<String> set = new HashSet<>();
		
		for (String s: subStrList) {
			set.add(s);
		}
		
		return subStrList.size() - set.size();
	}

	private static String getSubstring(String s, int left, int right) {
		String subStr ="";
		for (int j = left; j < right; j++) {
			subStr += s.charAt(j);
		}
		return subStr;
	}
	public static void main(String[] args) {
		String s = "aabaasdewewdsdsdssdwweewweewewewewdsdfqassssss";
		//String s="aabaa";
		// int[][] queries = {{ 1, 4 }};
		 int[][] queries = { { 1, 1 }, { 1, 4 }, { 1, 1 }, { 1, 17 }, { 0, 2 }};// 1,8,1,8,5
		//int[][] queries = { { 1, 4 } };// 1
		int[] result = countSubstringsBF(s, queries);
		
		System.out.println("=============");
		for (int i : result) {
			System.out.print(i + " ");
		}
		System.out.println();

		System.out.println("Response: ");
	}

}
