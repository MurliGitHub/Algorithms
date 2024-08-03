package m2j.ds.hr.tree;

import m2j.utility.CommonUtil;

/**
 * @author m2j
 * @see https://www.hackerrank.com/challenges/swap-nodes-algo/problem
 * 
 *
 */
public class SwapNodes {
	static int[][] swapNodes(int[][] indexes, int[] queries) {
		int numOfNodes = indexes.length;
		int numOfQueries = queries.length;
		int[][] result = new int[numOfQueries][numOfNodes];

		for (int i = 0; i < indexes.length; i++) {

		}

		return result;
	}

	public static void main(String[] args) {
		int n = 11;
		int[][] indexes = new int[n][2];
		int queriesCount = 3;
		int[] queries = new int[queriesCount];
		int[][] result = swapNodes(indexes, queries);
		CommonUtil.print(result);
	}

	static void swap(int K, Node node, int depth) {
		if (node == null) {
			return;
		}

		swap(K, node.left, depth + 1);
		swap(K, node.right, depth + 1);

		if (depth % K == 0) {
			Node temp = node.left;
			node.left = node.right;
			node.right = temp;
		}
	}

	public static void inOrder(Node node) {
		if (node == null)
			return;

		inOrder(node.left);
		if (node != null) {
			System.out.print(node.data + " ");
		}
		inOrder(node.right);

	}
}
