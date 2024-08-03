package m2j.da.leet75.arrays;

/**
 * @see https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
 *      Example 1:
 * 
 *      Input: nums = [3,4,5,1,2] Output: 1 Explanation: The original array was
 *      [1,2,3,4,5] rotated 3 times. Example 2:
 * 
 *      Input: nums = [4,5,6,7,0,1,2] Output: 0 Explanation: The original array
 *      was [0,1,2,4,5,6,7] and it was rotated 4 times. Example 3:
 * 
 *      Input: nums = [11,13,15,17] Output: 11 Explanation: The original array
 *      was [11,13,15,17] and it was rotated 4 times.
 * 
 */
public class _7FindMinimumRotatedSortedArray {
	public static void main(String[] args) {
//[11,13,15,17]

		int[] nums = { 3, 4, 5, 1, 2 };
		System.out.println(findMin(nums));

		int[] nums2 = { 4, 5, 6, 7, 0, 1, 2 };
		System.out.println(findMin(nums2));

		int[] nums3 = { 11, 13, 15, 17 };
		System.out.println(findMin(nums3));
	}

	public static int findMin(int[] nums) {

		int left = 0, right = nums.length - 1;

		while (left < right) {
			int mid = left + (right - left) / 2;

			if (nums[mid] > nums[right])
				left = mid + 1;
			else
				right = mid;
		}

		return nums[left];
	}
}
