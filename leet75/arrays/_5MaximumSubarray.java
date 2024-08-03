package m2j.da.leet75.arrays;

/**
 * 
 * Given an integer array nums, find the subarray with the largest sum, and
 * return its sum.
 * 
 * @see https://leetcode.com/problems/maximum-subarray/description/ Example 1:
 * 
 *      Input: nums = [-2,1,-3,4,-1,2,1,-5,4] Output: 6 Explanation: The
 *      subarray [4,-1,2,1] has the largest sum 6. Example 2:
 * 
 *      Input: nums = [1] Output: 1 Explanation: The subarray [1] has the
 *      largest sum 1. Example 3:
 * 
 *      Input: nums = [5,4,-1,7,8] Output: 23 Explanation: The subarray
 *      [5,4,-1,7,8] has the largest sum 23.
 */
public class _5MaximumSubarray {
	public static void main(String[] args) {
		
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		
		int result = maximumSubarray(nums);
		System.out.println("Example 1:subarray [4,-1,2,1] has the largest sum 6; Actual is: "+result);
		
		int[] nums2 = {-1};
		System.out.println("Example 2:subarray [1] has the largest sum 1; Actual is: "+maximumSubarray(nums2));
		
		int[] nums3 = {5,4,-1,7,8};
		System.out.println("Example 3:subarray [5,4,-1,7,8] has the largest sum 23; Actual is: "+maximumSubarray(nums3));
		
		
		//[-3,-2,-2,-3] //-2
		int[] nums0 = {-3,-2,-2,-3};
		System.out.println("Example 0:subarray [-3,-2,-2,-3] has the largest sum -2; Actual is: "+maximumSubarray(nums0));
	}

	private static int maximumSubarray(int[] nums) {
		int n = nums.length;
		
		int max= Integer.MIN_VALUE;
		int maxe = 0;
		
		for(int i=0; i<n;i++) {
			maxe =  maxe+nums[i];
			
			if(max<maxe)
				max=maxe;
			
			if(maxe<0)
				maxe=0;
		}
		
		
		return max;
	}

}
