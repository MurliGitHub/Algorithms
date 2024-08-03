package m2j.ds.hr.array;

import m2j.utility.CommonUtil;

/**
 * @author M2j
 * @see https://www.hackerrank.com/challenges/ctci-array-left-rotation/problem
 *
 */
public class LeftRotation {
	
	// Complete the rotLeft function below.
    static int[] rotLeftBF(int[] a, int d) {
    	
    	int[] t = new int[a.length];
    	int j=0;
    	for (int i = d; i < a.length; i++) {
			t[j] = a[i];
			j++;
		}
    	int v = a.length-d;
    	for (int i = 0; i < d; i++) {
    		t[v+i] = a[i];
		}
    	CommonUtil.print(t);
    	
		return a;
    }
    
	public static void main(String[] args) {
		//int[] a = {1, 2, 3, 4, 5};
		//int d = 4;
		int[] a = {41, 73, 89, 7, 10, 1, 59, 58, 84, 77, 77, 97, 58, 1, 86, 58, 26, 10, 86, 51};
		int d = 10;
		
		int[] rotLeft = rotLeftBF(a, d);
		System.out.println("Input::: ");
		CommonUtil.print(a);
		System.out.println("After "+ d +" Rotations");
		CommonUtil.print(rotLeft);
	}

}
