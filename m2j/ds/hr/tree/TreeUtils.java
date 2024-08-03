package m2j.ds.hr.tree;

public class TreeUtils {

	public static Node insert(Node root, int data) {
		if (root == null) {
			return new Node(data);
		} else {
			Node cur;
			if (data <= root.data) {
				cur = insert(root.left, data);
				root.left = cur;
			} else {
				cur = insert(root.right, data);
				root.right = cur;
			}
			return root;
		}

	}
	
	public static void preOrder(Node node) {
		if(node == null) return;
		
		if (node != null) {
			System.out.print(node.data+" ");
		}
		//System.out.println();
		
		preOrder(node.left);
		preOrder(node.right);
		
    }

	public static void printTree(Node node) {
		if (node == null) {
			return;
		}
		if (node != null) {
			System.out.print(node.data+" ");
		}
		printTree(node.left);
		printTree(node.right);
	}

	/*
	 * public static void printList(Node root) { if (root == null) return;
	 * 
	 * Node currentNode = root; while (currentNode != null) {
	 * System.out.println(currentNode.data); currentNode =
	 * currentNode.getNextNode(); } }
	 */

}