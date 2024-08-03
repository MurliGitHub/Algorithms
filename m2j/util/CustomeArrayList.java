package m2j.util;

public class CustomeArrayList {

}

class ArrayListC{
	
	private Integer[] elementData = {};
	
	private int capacity = 10;
	int size = 0;
	
	public ArrayListC() {
		elementData = new Integer[capacity];
	}
	
	public void add(int data) {
		elementData[size++] = data; 
	}
	
	public int get(int index) {
		
		return elementData[index];
	}
	
	public void remove(int index) {
		
		
	}
	
	
}
