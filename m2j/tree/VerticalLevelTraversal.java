package m2j.tree;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class VerticalLevelTraversal {
	public static void main(String[] args) {
		Node root = new Node(1);
		TreeUtils.insert(root, 2);
		TreeUtils.insert(root, 5);
		TreeUtils.insert(root, 3);
		TreeUtils.insert(root, 4);
		TreeUtils.insert(root, 6);
		// TreeUtils.printTree(root);

		verticalLevelTraversal(root);
	}

	private static void verticalLevelTraversal(Node root) {
		Map<String, Node> mapNode = new ConcurrentHashMap<>();
	}

}
