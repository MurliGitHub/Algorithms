package m2j.da.leet75.arrays;

/**
 * @see https://leetcode.com/problems/maximum-product-subarray/description/
 */
public class _6MaximumProductSubarray {

	public static void main(String[] args) {

//		Example 1:
//
//			Input: nums = [2,3,-2,4]
//			Output: 6
//			Explanation: [2,3] has the largest product 6.

		int[] nums = { 2, 3, -2, 4 };
		System.out.println("has the largest product 6; Actual is:" + maxProduct(nums));

//		Example 2:
//
//			Input: nums = [-2,0,-1]
//			Output: 0
//			Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
		int[] nums2 = { -2, 0, -1 };
		System.out.println("has the largest product 0 Actual is:" + maxProduct(nums2));
		
		//[-3,-1,-1]
		
		int[] nums3 = { -3,-1,-1 };
		System.out.println("has the largest product 3 Actual is:" + maxProduct(nums3));
		
		///[3,-1,4]
		
		int[] nums4 = { 3,-1, 4 };
		System.out.println("has the largest product 4 Actual is:" + maxProduct(nums4));
	}
	
	public static int maxProduct(int[] nums) {
		
		int res = Integer.MIN_VALUE;
		
		int max = 1;
		int min = 1;

			for (int i = 0; i < nums.length; i++) {
				if(nums[i] == 0) {
					min=1; 
					max=1;
				}
				
				int tempMax = max*nums[i];
				
				max = Math.max(nums[i] * max, Math.max(nums[i]*min,nums[i]));
				
				min= Math.min(tempMax, Math.min(nums[i]*min,nums[i]));
				
				res = Math.max(res, max);
			}

		return res;
	}

	public static int maxProductNotWorkin(int[] nums) {
		
		int max = 1;
		int maxp = 1;

		for (int i = 0; i < nums.length; i++) {
			maxp *= nums[i];

			if (maxp > max)
				max = maxp;

			if (maxp == 0) {
				maxp = 1;
				//max = 1;
			}
		}

		return max;
	}

}
