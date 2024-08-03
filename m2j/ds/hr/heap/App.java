package m2j.ds.hr.heap;

import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		MinIntHeap heap = new MinIntHeap();
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the no of operations: ");
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			System.out.println("Enter type: ");
			int type = sc.nextInt();

			switch (type) {
			case 1:
				System.out.println("Enter a num:");
				int item = sc.nextInt();
				heap.add(item);
				break;
			case 2:
				System.out.println("Enter a num to delete:");
				int toDelItem = sc.nextInt();
				heap.delete(toDelItem);
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
