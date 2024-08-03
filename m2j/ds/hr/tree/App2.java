package m2j.ds.hr.tree;
//package m2j.tree;
//
//import java.util.HashMap;
//import java.util.LinkedList;
//import java.util.Map;
//import java.util.Queue;
//import java.util.Stack;
//import java.util.TreeMap;
//import java.util.concurrent.LinkedBlockingQueue;
//
//public class App2 {
//	public static void main(String[] args) {
//		Node root = new Node(1);
//		TreeUtils.insert(root, 2);
//		TreeUtils.insert(root, 5);
//		TreeUtils.insert(root, 3);
//		TreeUtils.insert(root, 4);
//		TreeUtils.insert(root, 6);
//		topView(root, 0);
//	}
//
//	private static void topView(Node root, int level) {
//		Map<Integer, Integer> ht = new HashMap<>();
//		
//		if (root == null)
//			return;
//		// create a queue for level order traversal
//		Queue<NodeW> queue = new LinkedList<>();
//		// add root with level 0 (create a queue item pack)
//		queue.add(new NodeW(root, level));
//		while (!queue.isEmpty()) {
//			NodeW q = queue.remove();
//			// take out the items from the package
//			Node tnode = q.node;
//			int lvl = q.weight;
//
//			// check if this is the first node you are visiting at the level
//			if (ht.containsKey(lvl)) {
//
//			} else {// print it, its the first element at his level
//				System.out.print(tnode.data + "   ");
//				ht.put(lvl, tnode.data);
//			}
//
//			// add the left and right children of visiting nodes to the queue
//			if (tnode.left != null) {
//				queue.add(new NodeW(tnode.left, lvl - 1));
//			}
//			if (tnode.right != null) {
//				queue.add(new NodeW(tnode.right, lvl + 1));
//			}
//		}
//
//	}
//
//	public static void topViewWrong(Node root) {
//		Node temp = root.left;
//		Stack<Node> stack = new Stack<>();
//
//		while (temp != null) {
//			stack.push(temp);
//			temp = temp.left;
//		}
//		while (!stack.isEmpty())
//			System.out.println(stack.pop().data);
//
//		System.out.println(root.data);
//		temp = root.right;
//		while (temp != null) {
//			System.out.println(temp.data);
//			temp = temp.right;
//		}
//	}
//
//	public static void printTopView(Node root) {
//
//		if (root == null)
//			return;
//		Queue<Node> q = new LinkedBlockingQueue<>();
//		root.weight = 0;
//		q.add(root);
//		Map<Integer, Node> nodeMap = new TreeMap<>();
//
//		while (!q.isEmpty()) {
//			Node node = q.poll();
//			int weight = node.weight;
//			// insert weight wise nodes so the latest from below weight will
//			// replace the node on vertical
//			// above weight
//			if (!nodeMap.containsKey(weight)) {
//				nodeMap.put(weight, node);
//			}
//
//			if (node.left != null) {
//				node.left.weight = weight - 1;
//				q.add(node.left);
//			}
//			if (node.right != null) {
//				node.right.weight = weight + 1;
//				q.add(node.right);
//			}
//		}
//
//		nodeMap.forEach((k, v) -> {
//			System.out.print("" + v.data + " ");
//		});
//	}
//
//}
