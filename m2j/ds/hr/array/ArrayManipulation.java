package m2j.ds.hr.array;

import java.util.Arrays;

import m2j.utility.CommonUtil;

/**
 * @author M2J
 * @see https://www.hackerrank.com/challenges/crush/problem
 * 
 *
 */
public class ArrayManipulation {
	// Complete the arrayManipulation function below.
	static long arrayManipulation(int n, int[][] queries) {
		long[] tempArray = new long[n + 2];

		Arrays.fill(tempArray, 0);

		CommonUtil.print(tempArray);
		for (int[] query : queries) {
			int toFill = query[2];
			int startPos= query[0];
			int lastPos= query[1];
			
			tempArray[startPos] += toFill;
			tempArray[lastPos+1] -= toFill;
		}
		
		CommonUtil.print(tempArray);
		
		long maxVal = 0;
		//long[] maxArr = new long[n+2];
		for (int i=0; i<tempArray.length-1;i++) {
			tempArray[i] = tempArray[i]+maxVal;
			maxVal = tempArray[i];
		}
		
		CommonUtil.print(tempArray);

		long max = Arrays.stream(tempArray).max().getAsLong();
		return max;
	}

	public static void main(String[] args) {

		/*
		 * int n = 10; int[][] queries = { { 1, 5, 3 }, { 4, 8, 7 }, { 6, 9, 1 } };
		 */
		int n = 5;
		int[][] queries = { { 1, 2, 100 }, { 2, 5, 100 }, { 3, 4, 100 } };
		long result = arrayManipulation(n, queries);
		System.out.println(result);
	}

}
