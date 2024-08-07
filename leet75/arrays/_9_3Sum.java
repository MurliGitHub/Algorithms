package m2j.da.leet75.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @see https://leetcode.com/problems/3sum/description/ Example 1:
 * 
 *      Input: nums = [-1,0,1,2,-1,-4] Output: [[-1,-1,2],[-1,0,1]] Explanation:
 *      nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0. nums[1] + nums[2] +
 *      nums[4] = 0 + 1 + (-1) = 0. nums[0] + nums[3] + nums[4] = (-1) + 2 +
 *      (-1) = 0. The distinct triplets are [-1,0,1] and [-1,-1,2]. Notice that
 *      the order of the output and the order of the triplets does not matter.
 *      Example 2:
 * 
 *      Input: nums = [0,1,1] Output: [] Explanation: The only possible triplet
 *      does not sum up to 0. Example 3:
 * 
 *      Input: nums = [0,0,0] Output: [[0,0,0]] Explanation: The only possible
 *      triplet sums up to 0.
 * 
 */
public class _9_3Sum {
	public static void main(String[] args) {
		// Input: nums = [-1,0,1,2,-1,-4]
		// Output: [[-1,-1,2],[-1,0,1]]
		
		int[] nums = {-1,0,1,2,-1,-4};
		List<List<Integer>> resp = threeSum(nums);
		resp.stream().forEach(System.out::println);
		
	}

	private static List<List<Integer>> threeSum(int[] nums) {
		
		List<List<Integer>> result = new ArrayList<>();
		
		Arrays.sort(nums);
		
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) { // check lo/hi after i
        	if (i > 0 && nums[i] == nums[i - 1]) continue; // check duplicate

            int lo = i + 1, hi = n - 1;
            while (lo < hi) {
                int sum = nums[i] + nums[lo] + nums[hi];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                    while (lo < hi && nums[lo] == nums[lo + 1]) lo++;
                    while (lo < hi && nums[hi] == nums[hi - 1]) hi--;
                    lo++;
                    hi--;
                } else if (sum < 0) {
                    lo++;
                } else {
                    hi--;
                }
            }
        }
		
		
		return result;

	}

}
