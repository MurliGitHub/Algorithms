package m2j.ds.hr.heap;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Qheap1_Inbuild {
	private static PriorityQueue<Integer> heap = new PriorityQueue<Integer>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the no of operations: ");
		int n = sc.nextInt();

		while (n-- > 0) {
			System.out.println("Enter type: ");
			int type = sc.nextInt();
			int item;

			switch (type) {
			case 1:
				System.out.println("Enter a num:");
				item = sc.nextInt();
				heap.add(item);
				break;
			case 2:
				System.out.println("Enter a num to delete:");
				item = sc.nextInt();
				heap.remove(item);
				break;
			case 3:
				System.out.println(heap.peek());
				break;
			default:
				break;
			}

		}

		sc.close();
	}

}
