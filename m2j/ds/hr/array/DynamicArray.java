package m2j.ds.hr.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author m2j
 * @see https://www.hackerrank.com/challenges/dynamic-array/problem
 * 
 *
 */
public class DynamicArray {

	public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
		List<List<Integer>> seqList = new ArrayList<>();
		List<Integer> response = new ArrayList<Integer>();

		for (int i = 0; i < n; i++) {
			seqList.add(new ArrayList<>());
		}

		int lastAnswer = 0;

		for (int i = 0; i < queries.size(); i++) {
			List<Integer> query = queries.get(i);
			int x = query.get(1);
			int y = query.get(2);

			if (query.get(0) == 1) {
				seqList.get((x ^ lastAnswer) % n).add(y);
			} else if (query.get(0) == 2){
				List<Integer> seq = seqList.get((x ^ lastAnswer) % n);
				int size = seq.size();
				lastAnswer = seq.get(y % size);
				response.add(lastAnswer);
			}
		}

		return response;
	}

	public static void main(String[] args) {
		/*
		 * 1 0 5 1 1 7 1 0 3 2 1 0 2 1 1
		 */
		List<List<Integer>> queries = new ArrayList<List<Integer>>();
		List<Integer> q1 = Arrays.asList(1, 0, 5);
		List<Integer> q2 = Arrays.asList(1, 1, 7);
		List<Integer> q3 = Arrays.asList(1, 0, 3);
		List<Integer> q4 = Arrays.asList(2, 1, 0);
		List<Integer> q5 = Arrays.asList(2, 1, 1);
		queries.add(q1);
		queries.add(q2);
		queries.add(q3);
		queries.add(q4);
		queries.add(q5);
		List<Integer> response = dynamicArray(2, queries);
		response.forEach(System.out::println);
	}

}
