package m2j.ds.hr.heap;

import java.util.Scanner;

import m2j.utility.CommonUtil;

public class Qheap1 {

	public static void main(String[] args) {
		
		Heap heap = new Heap();
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
				heap.printAllMin();
				break;
			default:
				break;
			}

		}

		sc.close();
	}

}

class Heap {
	private int[] array;
	private int index = -1;
	private int capacity;

	public void add(int item) {
		if (isFull()) {
			throw new RuntimeException("Heap is full");
		}

		array[++index] = item;
		maxHeapify(index);
	}

	public void printAllMin() {
		
		
	}

	public void delete(int toDelItem) {
		
		
	}

	public boolean isFull() {
		return this.capacity == array.length;
	}

	private void maxHeapify(int index) {

		int parentIndex = getParentIndex(index);

		while (parentIndex >= 0 && this.array[index] > this.array[parentIndex]) {
			CommonUtil.swap(array, index, parentIndex);
			index = parentIndex;
			parentIndex = getParentIndex(index);

		}

	}

	private int getParentIndex(int index) {
		if (index < 0 || index > array.length) {
			throw new IndexOutOfBoundsException("Heap index out of bound, check the capacity of heap.");
		}
		return ((index - 1) / 2);
	}

}