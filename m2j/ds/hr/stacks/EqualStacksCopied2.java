package m2j.ds.hr.stacks;

import java.io.IOException;
import java.util.stream.IntStream;

/**
 * @author m2j
 * @see https://www.hackerrank.com/challenges/equal-stacks/problem
 * 
 *
 */
public class EqualStacksCopied2 {

	/*
	 * Complete the equalStacks function below.
	 */
	static int equalStacks(int[] h1, int[] h2, int[] h3) {
		int sum1 = sum(h1);
		int sum2 = sum(h2);
		int sum3 = sum(h3);

		System.out.println(sum1 + " | " + sum2 + " | " + sum3);

		int i1 = 0;
		int i2 = 0;
		int i3 = 0;

		while (true) {
			if (sum1 > sum2 || sum1 > sum3) {
				sum1 -= h1[i1++];
			} else if (sum2 > sum1 || sum2 > sum3) {
				sum2 -= h2[i2++];
			} else if (sum3 > sum1 || sum3 > sum2) {
				sum3 -= h3[i3++];
			} else {
				break;
			}
		}

		return sum1;
	}

	static int sum(int[] arr) {
		return IntStream.of(arr).sum();
	}

//	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
//		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

//		String[] n1N2N3 = scanner.nextLine().split(" ");

//		int n1 = Integer.parseInt(n1N2N3[0].trim());
//
//		int n2 = Integer.parseInt(n1N2N3[1].trim());
//
//		int n3 = Integer.parseInt(n1N2N3[2].trim());
//
//		int[] h1 = new int[n1];
//
//		String[] h1Items = scanner.nextLine().split(" ");
//
//		for (int h1Itr = 0; h1Itr < n1; h1Itr++) {
//			int h1Item = Integer.parseInt(h1Items[h1Itr].trim());
//			h1[h1Itr] = h1Item;
//		}
//
//		int[] h2 = new int[n2];
//
//		String[] h2Items = scanner.nextLine().split(" ");
//
//		for (int h2Itr = 0; h2Itr < n2; h2Itr++) {
//			int h2Item = Integer.parseInt(h2Items[h2Itr].trim());
//			h2[h2Itr] = h2Item;
//		}
//
//		int[] h3 = new int[n3];
//
//		String[] h3Items = scanner.nextLine().split(" ");
//
//		for (int h3Itr = 0; h3Itr < n3; h3Itr++) {
//			int h3Item = Integer.parseInt(h3Items[h3Itr].trim());
//			h3[h3Itr] = h3Item;
//		}
//
		int[] h1 = { 3, 2, 1, 1, 1 };
		int[] h2 = { 4, 3, 2 };
		int[] h3 = { 1, 1, 4, 1 };
		int result = equalStacks(h1, h2, h3);
		System.out.println(result);

//		bufferedWriter.write(String.valueOf(result));
//		bufferedWriter.newLine();
//
//		bufferedWriter.close();
	}
}
