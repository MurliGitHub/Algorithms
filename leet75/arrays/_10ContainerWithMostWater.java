package m2j.da.leet75.arrays;

/**
 * @see https://leetcode.com/problems/container-with-most-water/
 * Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
Example 2:

Input: height = [1,1]
Output: 1
 */
public class _10ContainerWithMostWater {
	public static void main(String[] args) {
		
		int[] heights = {1,8,6,2,5,4,8,3,7};
		System.out.println("Height for int[] heights = {1,8,6,2,5,4,8,3,7};must be 49, Result is: "+maxArea(heights));
		int[] heights2 = {1,1};
		System.out.println("Height for int[] heights = {1,1};must be 1, Result is: "+maxArea(heights2));
	}

	static int maxArea(int[] height) {
		int maxArea=0;
		int l= 0;
		int r= height.length - 1;
		
		while (l<r) {
			
			int minHeight = Math.min(height[l], height[r]);
			int area = (r-l)*minHeight;
			
			maxArea = Math.max(area, maxArea);
			
			if(height[l]<height[r]) {
				l++;
			}else{
				r--;
			}
		}
		
		return maxArea;
        
    }
    
    static int maxAreaBF(int[] height) {
    	int n = height.length;
    	int maxArea=0;
    	
    	for(int i =0; i<n;i++) {
    		for (int j = i+1; j < n; j++) {
				int area = (j-i)*Math.min(height[j], height[i]);
				
				maxArea = Math.max(area, maxArea);
			}
    	}
		return maxArea;
        
    }
}
