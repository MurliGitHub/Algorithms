package m2j.da.leet75.arrays;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @see https://leetcode.com/problems/two-sum/
 * 
 */
public class _1TwoSum {
	public static void main(String[] args) {
//		Example 1:
//
//			Input: nums = [2,7,11,15], target = 9
//			Output: [0,1]
//			Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
		int[] nums = { 2, 7, 11, 15 };
		int target = 9;
		int[] output = twoSum(nums, target);

		System.out.println("Example1: For input nums = [2,7,11,15], target = 9; Output is: " + Arrays.toString(output));

//		Example 2:
//
//			Input: nums = [3,2,4], target = 6
//			Output: [1,2]

		int[] nums2 = { 3, 2, 4 };
		int target2 = 6;
		int[] output2 = twoSum(nums2, target2);

		System.out.println("Example2: For input nums = [3,2,4], target = 6; Output is: " + Arrays.toString(output2));

//		Example 3:
//
//			Input: nums = [3,3], target = 6
//			Output: [0,1]

		int[] nums3 = { 3, 3 };
		int target3 = 6;
		int[] output3 = twoSum(nums3, target3);

		System.out.println("Example3: For input nums = [3,3], target = 6; Output is: " + Arrays.toString(output3));

		// Emaple 4

		int[] nums4 = { -1, -2, -3, -4, -5 };
		int target4 = -8;

		int[] output4 = twoSum(nums4, target4);

		System.out.println("Example4: For input nums = [-1,-2,-3,-4,-5], target = -8; expected: [2,4] ; Output is: "
				+ Arrays.toString(output4));
	}

	public static void mainTest(String[] args) {
		int[] nums4 = { -1, -2, -3, -4, -5 };
		int target4 = -8;

		int[] output4 = twoSum(nums4, target4);

		System.out.println("Example4: For input nums = [-1,-2,-3,-4,-5], target = -8; expected: [2,4] ; Output is: "
				+ Arrays.toString(output4));
	}

	public static int[] twoSum(int[] nums, int target) {
		
		HashMap<Integer, Integer> map = new HashMap<>();
		

		int[] out = new int[2];

		for (int i = 0; i < nums.length; i++) {
			
			if(map.get(target-nums[i]) == null) {
				map.put(nums[i], i);
			}else {
				out[0]=map.get(target-nums[i]);
				out[1]=i;
				break;
			}
			
		}
		
		return out;

	}

	public static int[] twoSumBF(int[] nums, int target) {
		int[] out = new int[2];

		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if ((nums[i] + nums[j]) == target) {
					out[0] = i;
					out[1] = j;
					break;
				}
			}
		}
		return out;
	}
}
