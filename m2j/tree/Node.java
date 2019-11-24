package m2j.tree;

public class Node {
	int data;
	Node left;
	Node right;

	public Node(int data) {
		super();
		this.data = data;
	}

	public Node() {
	}

	@Override
	public String toString() {
		return "Node [data=" + data + ", left=" + left + ", right=" + right + "]";
	}

}
