package m2j.ds.hr.array;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @author
 * Find max & min from an array O(n)
 *
 */
public class CompareNumbers {
	public static void main(String[] args) {
		int[] arr = {1000, 11, 445, 1, 330, 3000};
	
//		getMaxAndMin(arr);
		
		//getMaxAndMinUsingJavaLib(arr);
		
//		getMaxAndMinUsingJavaLib8(arr);
		getSecondMax(arr);
		
	}
	
	private static void getSecondMax(int[] arr) {
		
		int val = arr[0];
		
		
		int first, second;
		first = second = Integer.MIN_VALUE;
		
		System.out.println(second);
	/*	for (int i = 0; i < arr.length; i++) {
			if()
		}*/
		
	}

	private static void getMaxAndMinUsingJavaLib8(int[] arr) {
		IntStream iStream = Arrays.stream(arr);
		/*OptionalInt min = iStream.min();
		System.out.println(min.getAsInt());*/
		Integer max  = iStream.max().getAsInt();
		
		System.out.println(max);
		
		
	}

	private static void getMaxAndMinUsingJavaLib(int[] arr) {
		
		Arrays.sort(arr);
		
		System.out.println(arr[0]);
		System.out.println(arr[arr.length-1]);
		
	}

	private static void getMaxAndMin(int[] arr) {
		int len = arr.length;
		
		int maxVal = arr[0];
		
		int minVal = arr[0];
		
		for (int i = 0; i < len; i++) {
			if(arr[i]>maxVal){
				maxVal = arr[i];
			}
			
			if(arr[i] < minVal){
				minVal = arr[i];
			}
		}
		
		System.out.println(maxVal);
		
		System.out.println(minVal);
		
		
	}

}
