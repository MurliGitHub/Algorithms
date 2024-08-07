package m2j.ds.hr.tree;

public class Node {
	

	int data;
	Node left;
	Node right;
	char charData;
	//int weight;

	public Node(int data) {
		super();
		this.data = data;
	}

	public Node() {
	}
	
	public char getCharData() {
		return charData;
	}

	public void setCharData(char charData) {
		this.charData = charData;
	}
	

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	@Override
	public String toString() {
		return "Node [data=" + data + ", left=" + left + ", right=" + right + "]";
	}

}
