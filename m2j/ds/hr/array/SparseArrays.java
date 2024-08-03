package m2j.ds.hr.array;

import m2j.utility.CommonUtil;

/**
 * @author m2j
 * @see https://www.hackerrank.com/challenges/sparse-arrays/problem
 * 
 *
 */
public class SparseArrays {

	// Complete the matchingStrings function below.
	static int[] matchingStrings(String[] strings, String[] queries) {
		int[] res = new int[queries.length];
		
		for (String str : strings) {
			for (int i =0; i<queries.length;i++) {
				if(str.equals(queries[i])) {
					res[i]++;
				}
			}
		}
		
		return res;
	}

	public static void main(String[] args) {
		String[] strings = {"ab","ab","abc"};
		System.out.println("Input Strings are: ");
		CommonUtil.print(strings);
		String[] queries = {"ab","abc","bc"};
		System.out.println("Input Queries are: ");
		CommonUtil.print(queries);
        //result is: [2,1,0]
		int[] res = matchingStrings(strings, queries);
		CommonUtil.print(res);
	}
}
