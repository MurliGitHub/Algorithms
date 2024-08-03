package m2j.ds.hr.tree;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

/**
 * @author m2j
 * @see https://www.hackerrank.com/challenges/tree-top-view/problem
 *
 */
public class TopView {
	public static void topView(Node root) {
		class TopNode {
			Node node;
			int hd;

			public TopNode(Node node, int hd) {
				this.node = node;
				this.hd = hd;
			}
		}
		Queue<TopNode> queue = new LinkedList<>();
		Map<Integer, Node> topViewMap = new TreeMap<Integer, Node>();
		if (root == null)
			return;
		else {
			queue.add(new TopNode(root, 0));
		}

		while (!queue.isEmpty()) {
			TopNode tempNode = queue.poll();

			if (!topViewMap.containsKey(tempNode.hd)) {
				topViewMap.put(tempNode.hd, tempNode.node);
			}

			if (tempNode.node.left != null) {
				queue.add(new TopNode(tempNode.node.left, tempNode.hd - 1));
			}

			if (tempNode.node.right != null) {
				queue.add(new TopNode(tempNode.node.right, tempNode.hd + 1));
			}
		}
		topViewMap.entrySet().stream().forEach(es -> System.out.print(es.getValue().data + " "));

	}

	public static void main(String[] args) {
		Node root = new Node(1);
		TreeUtils.insert(root, 2);
		TreeUtils.insert(root, 5);
		TreeUtils.insert(root, 3);
		TreeUtils.insert(root, 4);
		TreeUtils.insert(root, 6);
		// TreeUtils.printTree(root);
		topView(root);
		// top_view(root);//4 3 6 5 2 1
	}
}
