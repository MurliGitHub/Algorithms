package m2j.ds.hr.heap;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class RunningMedian {
	static double[] runningMedian(int[] a) {
		double[] medians = new double[a.length];
		
		double firstMedian = a[0];
		
		PriorityQueue<Double> minHeap = new PriorityQueue<Double>(Collections.reverseOrder());
		minHeap.add(firstMedian);
		
		System.out.println(firstMedian);
		
		PriorityQueue<Double> maxHeap = new PriorityQueue<Double>();
		
		
		
		
		return medians;
	}
	
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int aCount = Integer.parseInt(scanner.nextLine().trim());

		int[] a = new int[aCount];

		for (int aItr = 0; aItr < aCount; aItr++) {
			int aItem = Integer.parseInt(scanner.nextLine().trim());
			a[aItr] = aItem;
		}

		double[] result = runningMedian(a);

		for (int resultItr = 0; resultItr < result.length; resultItr++) {
			bufferedWriter.write(String.valueOf(result[resultItr]));

			if (resultItr != result.length - 1) {
				bufferedWriter.write("\n");
			}
		}

		bufferedWriter.newLine();

		bufferedWriter.close();
	}
}
