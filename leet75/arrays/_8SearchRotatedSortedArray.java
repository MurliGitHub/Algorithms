package m2j.da.leet75.arrays;

/**
 * @see https://leetcode.com/problems/search-in-rotated-sorted-array/description/
 *      Input: nums = [4,5,6,7,0,1,2], target = 0 Output: 4 Example 2:
 * 
 *      Input: nums = [4,5,6,7,0,1,2], target = 3 Output: -1 Example 3:
 * 
 *      Input: nums = [1], target = 0 Output: -1
 * 
 */
public class _8SearchRotatedSortedArray {
	public static void main(String[] args) {
		int[] nums = { 4, 5, 6, 7, 0, 1, 2 };
		int target = 0;
		System.out.println("Expected output is 4. Actual is: " + search(nums, target));

		int[] nums2 = { 4, 5, 6, 7, 0, 1, 2 };
		int target2 = 3;
		System.out.println("Expected output is -1. Actual is: " + search(nums2, target2));

		int[] nums3 = { 1 };
		int target3 = 0;
		System.out.println("Expected output is -1. Actual is: " + search(nums3, target3));
		
		int[] nums4 = { 1 };
		int target4 = 1;
		System.out.println("Expected output is 0. Actual is: " + search(nums4, target4));
		
		int[] nums5 = { 1,3 };
		int target5 = 3;
		System.out.println("Expected output is 1. Actual is: " + search(nums5, target5));

	}

	private static int search(int[] nums, int x) {
		int left = 0, right = nums.length - 1;
		
		//if(left==right && nums[left] ==x ) return left;

		while (left <= right) {
			int mid = left + (right - left) / 2;

			if (nums[mid] == x)
				return mid;

			if (nums[mid] > nums[right] ) {
				if(x >= nums[left] && x < nums[mid])
					right = mid - 1;
				else
					left = mid + 1;
			}
			else {
				if (x > nums[mid] && x <= nums[right])
                    left = mid + 1;
                else
                    right = mid - 1;
			}

		}
		return -1;
	}

}
