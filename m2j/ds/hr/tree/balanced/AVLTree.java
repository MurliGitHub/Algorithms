package m2j.ds.hr.tree.balanced;

public class AVLTree {

	static Node insert(Node root, int val) {
		if (root == null) {
			root = new Node();
			root.val = val;
			root.ht = 1;
			
			return root;
		}
			

		if (val > root.val) {
			root.right = insert(root.right, val);
		} else {
			root.left = insert(root.left, val);
		}

		/* 2. Update height of this ancestor node */
		root.ht = 1 + max(height(root.left), height(root.right)); 

		int balance = getBalance(root);

		// If this node becomes unbalanced, then there
		// are 4 cases Left Left Case
		if (balance > 1 && val < root.left.val)
			return rightRotate(root);

		// Right Right Case
		if (balance < -1 && val > root.right.val)
			return leftRotate(root);

		// Left Right Case
		if (balance > 1 && val > root.left.val) {
			root.left = leftRotate(root.left);
			return rightRotate(root);
		}

		// Right Left Case
		if (balance < -1 && val < root.right.val) {
			root.right = rightRotate(root.right);
			return leftRotate(root);
		}

		return root;
	}

	private static Node leftRotate(Node x) {
		Node y = x.right;
		Node T2 = y.left;

		// Perform rotation
		y.left = x;
		x.right = T2;

		// Update heights
		x.ht = max(height(x.left), height(x.right)) + 1;
		y.ht = max(height(y.left), height(y.right)) + 1;

		// Return new root
		return y;
	}

	private static Node rightRotate(Node y) {

		Node x = y.left;
		Node T2 = x.right;

		// Perform rotation
		x.right = y;
		y.left = T2;

		// Update heights
		y.ht = max(height(y.left), height(y.right)) + 1;
		x.ht = max(height(x.left), height(x.right)) + 1;

		// Return new root
		return x;
	}

	private static int max(int m, int n) {
		return (m > n) ? m : n;
	}

	// Get Balance factor of node N
	static int getBalance(Node node) {
		if (node == null)
			return 0;

		return height(node.left) - height(node.right);
	}

	// A utility function to get the height of the tree
	static int height(Node node) {
		if (node == null)
			return 0;

		return node.ht;
	}

	/*
	 * private static int height(Node root) { if (root == null) { return 0; } else {
	 * return 1 + Math.max((root.left != null ? root.left.ht : 0), (root.right !=
	 * null ? root.right.ht : 0)); } }
	 */

	static void preOrder(Node node) {
		if (node != null) {
			System.out.print(node.val + " ");
			preOrder(node.left);
			preOrder(node.right);
		}
	}

	public static void main(String[] args) {
		Node root = null;
		root = insert(root, 1);
		root = insert(root, 2);
		root = insert(root, 3);
		root = insert(root, 6);
		root = insert(root, 5);
		root = insert(root, -2);

		preOrder(root);
	}

}
