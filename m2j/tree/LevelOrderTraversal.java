package m2j.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author m2j
 * @see https://www.hackerrank.com/challenges/tree-level-order-traversal/problem
 *
 */
public class LevelOrderTraversal {

	public static void main(String[] args) {
		Node root = new Node(1);
		TreeUtils.insert(root, 2);
		TreeUtils.insert(root, 5);
		TreeUtils.insert(root, 3);
		TreeUtils.insert(root, 4);
		TreeUtils.insert(root, 6);
		// TreeUtils.printTree(root);

		orderLevelTraversal(root);
	}

	// result: 1 -> 2 -> 5 -> 3 -> 6 -> 4.
	private static void orderLevelTraversal(Node root) {
		if (root == null)
			return;

		Node node;
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			node = queue.poll();

			System.out.print(node.data + " ");

			if (node.left != null) {
				queue.add(node.left);
			}

			if (node.right != null)
				queue.add(node.right);
		}

	}
}
