package m2j.strings;

import m2j.utility.CommonUtil;

public class HowManySubstrings {
	
	static int[] countSubstrings(String s, int[][] queries) {

		int[] substrCount = new int[queries.length];

		for (int i = 0; i < queries.length; i++) {
			substrCount[i] = getSubStrCount(s, queries[i]);
		}

		System.out.println("=============");
		for (int i : substrCount) {
			System.out.print(i + " ");
		}
		System.out.println();

		return null;
	}

	private static int getSubStrCount(String s, int[] is) {
		String subStr = s.substring(is[0], is[1] + 1);
		System.out.println("Sub String is: " + subStr);
		
		return countSubStr(subStr);
	}

	private static int countSubStr(String subStr) {
		int n = subStr.length();
		int countF = (n*(n+1))/2;
		int lcpCount = getLCPArrayCount(subStr.toCharArray());
		return (countF-lcpCount);
	}

	private static int getLCPArrayCount(char[] charArray) {
		int m = charArray.length;
		System.out.println("Length of charArray is: "+ m);
		int[] f = new int[m];
		
		int i=1, j=0;
		f[0]=0;
		
		while(i<m){
			if(charArray[i]==charArray[j]){
				f[i] = j+1;
				i++;
				j++;
			}else if(j>0){
				j = f[j-1];
			}else{
				f[i]=0;
				i++;
			}
		}
		
		CommonUtil.print(f);
		
		int count = 0;
		
		for(int num:f){
			count +=num;
		}
		System.out.println("LCP Count is: "+ count);
		return count;
	}

	public static void main(String[] args) {
		String s = "aabaadssdgfdgfgddtgrsgrsgsgdfgffdgfdsdssf";
		//String s ="aabaa";
		 //int[][] queries = { { 1, 1 }, { 1, 4 }, { 1, 1 }, { 1, 4 }, { 0, 2 }};// 1,8,1,8,5
		// int[][] queries = new int[5][2];
		// int[][] queries = { { 1, 1 }, { 1, 4 }, { 1, 6 }, { 1, 17 }, { 0, 2 }};// 1,8,19,140,5
		//int[][] queries = { { 1, 17 } };// 140
		int[][] queries = { { 0, 4 } };// 1
		int[] result = countSubstrings("aaaza", queries);
		System.out.println("Response: ");
		/*
		 * for (int i : result) { System.out.println(i); }*/
	}

}
