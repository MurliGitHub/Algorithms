package m2j.ds.hr.heap;

import java.util.Arrays;

public class MinIntHeap {

	private int capacity = 10;
	private int[] array = new int[capacity];
	private int size = 0;

	private int getLeftChildIndex(int parentIndex) {
		return 2 * parentIndex + 1;
	}

	private int getRightChildIndex(int parentIndex) {
		return 2 * parentIndex + 2;
	}

	private int getParentIndex(int childIndex) {
		return (childIndex - 1) / 2;
	}

	private boolean hasLeftChild(int index) {
		return getLeftChildIndex(index) < index;
	}

	private boolean hasRightChild(int index) {
		return getRightChildIndex(index) < index;
	}

	private boolean hasParent(int index) {
		return getParentIndex(index) >= 0;
	}

	private int getLefChild(int index) {
		return array[getLeftChildIndex(index)];
	}

	private int getRightChild(int index) {
		return array[getRightChildIndex(index)];
	}

	private int getParent(int index) {
		return array[getParentIndex(index)];
	}
	
	

	private void swap(int index1, int index2) {
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}
	
	private void ensureCapacity() {
		if(size == capacity) {
			array = Arrays.copyOf(array, capacity*2);
			capacity *=2;
		}
	}
	
	public int peek() {
		if(size == 0) throw new IllegalStateException();
		return array[0];
	}
	
	public int poll() {
		if(size == 0) throw new IllegalStateException();
		int item = array[0];
		array[0]=array[size-1];
		size--;
		heapifyDown();
		return item;
	}
	
	public void add(int item) {
		ensureCapacity();
		array[size]= item;
		size++;
		heapifyUp();
	}

	private void heapifyUp() {
		int index = size-1;
		while(hasParent(index) && getParent(index) > array[index]) {
			swap(getParentIndex(index), index);
			index = getParentIndex(index);
		}
	}

	private void heapifyDown() {
		int index = 0;
		while(hasLeftChild(index)) {
			int smallerChildIndex = getLeftChildIndex(index);
			if(hasRightChild(index) && getRightChild(index) < getLefChild(index)) {
				smallerChildIndex = getRightChildIndex(index);
			}
			
			if(array[index] < array[smallerChildIndex]) {
				break;
			}else {
				swap(index, smallerChildIndex);
			}
			
			index = smallerChildIndex;
		}
	}

	public void delete(int y) {
		int k = 0;
		boolean found = false;
		for (int i = 0; i < array.length; i++) {
			if (y == array[i]) {
				k = i;
				found = true;
				break;
			}
		}
		if (found) {
			swap(k, size--);
			if (k == 1 || array[k] > array[k / 2]) {
				heapifyDown();
			} else {
				heapifyUp();
			}
			array[size + 1] = -1;
		}
		
	}


}
