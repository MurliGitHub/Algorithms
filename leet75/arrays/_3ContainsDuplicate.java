package m2j.da.leet75.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @see https://leetcode.com/problems/contains-duplicate/
 * 
 */
public class _3ContainsDuplicate {

	public static void main(String[] args) {
//		Example 1:
//
//			Input: nums = [1,2,3,1]
//			Output: true
		int[] nums = { 1, 2, 3, 1 };
		System.out.println("Example1: " + containsDuplicate(nums));

//			Example 2:
//
//			Input: nums = [1,2,3,4]
//			Output: false
		int[] nums2 = { 1, 2, 3, 4 };
		System.out.println("Example2: " + containsDuplicate(nums2));
//			Example 3:
//
//			Input: nums = [1,1,1,3,3,4,3,2,4,2]
//			Output: true

		int[] nums3 = { 1, 1, 1, 3, 3, 4, 3, 2, 4, 2 };
		System.out.println("Example3: " + containsDuplicate(nums3));
	}

	public static boolean containsDuplicate7(int[] nums) {

		HashSet<Integer> set = new HashSet<>();

		for (int num : nums) {
			if (!set.add(num)) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean containsDuplicate8(int[] nums) {

		Set<Integer> set = new HashSet<>();
		
		return Arrays.stream(nums).anyMatch(num -> !set.add(num));
	}
	
	public static boolean containsDuplicate(int[] nums) {

		Set<Integer> set = new HashSet<>();
		
		return Arrays.stream(nums).anyMatch(num -> !set.add(num));
	}
}
