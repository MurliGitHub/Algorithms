package m2j.ds.hr.stacks;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author m2j
 * @see https://www.hackerrank.com/challenges/largest-rectangle/problem
 * 
 *
 */
public class LargestRectangle {
	
	// Complete the largestRectangle function below.
    static long largestRectangleWorstCase(int[] h) {
    	Arrays.sort(h);
    	Stack<Integer> stack = new Stack<Integer>();
    	for (int i=h.length-1;i>=0;i--) {
    		stack.push(h[i]);
		}
    	//System.out.println(stack.peek());
    	int max = 0;
    	
    	while(!stack.isEmpty()) {
    		int k=stack.size();
    		System.out.println("K: "+k);
    		int hi= stack.pop();
    		System.out.println("hi: "+hi);
    		
    		int ar= k*hi;
    		System.out.println("ar: "+ar);
    		if(ar>max) {
    			max = ar;
    		}
    	}
    	
		return max;
    }
    
    static long largestRectangleNW(int[] h) {
    	
    	long maxArea = 0;
    	Stack<Integer> hsi = new Stack<Integer>();
    	int i= 0;
    	for (i= 0;i<h.length;i++) {
    		
    		while(!hsi.empty() && h[i] <= h[hsi.peek()]) {
        		int hi= hsi.pop();
        		
        		int emptyIndex = hsi.empty() ? 0 : (hsi.peek() + 1);
        		
        		long ar= h[hi]*(i - emptyIndex);
        		
        		if(ar>maxArea) {
        			maxArea = ar;
        		}
        	}
    		
    		hsi.push(i);
		}
    	
    	while (!hsi.isEmpty()) {
			int p = hsi.pop();
			int hm = h[p];
			int w = hsi.isEmpty() ? i : i - hsi.peek() - 1;
			maxArea = Math.max(hm * w, maxArea);
		}
		return maxArea;
    }

	public static void main(String[] args) {
		test0();//9
		test1();//26152
	}

	private static void test0() {
				int[] h = {1,2,3,4,5};
				long result = largestRectangleNW(h);
				System.out.println(result);
	}
	
	private static long largestRectangle(int[] height) {
		Stack<Integer> stack = new Stack<Integer>();
		 
		int max = 0;
		int i = 0;
	 
		while (i < height.length) {
			//push index to stack when the current height is larger than the previous one
			if (stack.isEmpty() || height[i] >= height[stack.peek()]) {
				stack.push(i);
				i++;
			} else {
			//calculate max value when the current height is less than the previous one
				int p = stack.pop();
				int h = height[p];
				int w = stack.isEmpty() ? i : i - stack.peek() - 1;
				max = Math.max(h * w, max);
			}
	 
		}
	 
		while (!stack.isEmpty()) {
			int p = stack.pop();
			int h = height[p];
			int w = stack.isEmpty() ? i : i - stack.peek() - 1;
			max = Math.max(h * w, max);
		}
	 
		return max;
	}

	private static void test1() {
				int[] h = {8979, 4570, 6436, 5083, 7780, 3269, 5400, 7579, 2324, 2116};//26152
				long result = largestRectangle(h);
				System.out.println(result);
	}

}
