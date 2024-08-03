package m2j.ds.hr.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class DuplicateNumberInArray {

	public static void main(String[] args) {
		long startTime = System.nanoTime();
		int[] nums = { 2, 4, 7, 2, 5, 6, 3, 2, 8, 4 ,0,9,999,7,6,7,8,5,45,67,7,54,76,8,8887,7,3,123,123};
		// findDuplicateUsingMap(nums);
		long endTime = System.nanoTime();
		Double v = new Double((endTime - startTime) / 1000000);
		System.out.println("That took " + v + " milliseconds");

		//findDuplicateUsingBF(nums);
		findDuplicateUsingHS(nums);
	}

	private static void findDuplicateUsingHS(int[] nums) {
		System.out.println("Duplicate elements from array using HashSet data structure");
		Set<String> store = new HashSet<>();
		System.out.println("Found duplicates element in array : ");
		for (int name : nums) {
			//if (store.add(String.valueOf(name)) == false) {
			if (!store.add(String.valueOf(name))) {
				System.out.print(name +" ");
			}
		}
		System.out.println();

	}
	


	private static void findDuplicateUsingBF(int[] nums) {
		int[] dupData = null;

		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] == nums[j]) {
					dupData[i] = nums[i];
				}
			}
		}

		for (int i = 0; i < dupData.length; i++) {
			System.out.println("Duplicate num is: " + dupData[i]);
		}

	}

	private static void findDuplicateUsingMap(int[] nums) {

		Map<Integer, Integer> nameAndCount = new HashMap<>();

		for (int num : nums) {
			Integer count = nameAndCount.get(num);
			if (count == null) {
				nameAndCount.put(num, 1);
			} else {
				nameAndCount.put(num, ++count);
			}
		}

		Set<Entry<Integer, Integer>> entrySet = nameAndCount.entrySet();
		for (Entry<Integer, Integer> entry : entrySet) {
			if (entry.getValue() > 1) {
				System.out.println("Duplicate element from array : " + entry.getKey());
			}
		}

	}

}
