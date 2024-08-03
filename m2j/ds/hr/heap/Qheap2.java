package m2j.ds.hr.heap;

import java.util.Scanner;

import m2j.utility.CommonUtil;

public class Qheap2 {

	public static void main(String[] args) {
		
		Heap2 heap = new Heap2();
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
//				heap.add(item);
				break;
			case 2:
				System.out.println("Enter a num to delete:");
				int toDelItem = sc.nextInt();
//				heap.delete(toDelItem);
				break;
			case 3:
//				heap.printAllMin();
				break;
			default:
				break;
			}

		}

		sc.close();
	}

}

class Heap2 {
	private int capacity=10;
	private int[] array = new int[capacity];
	private int size = 0;
	

}