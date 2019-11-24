package m2j.tree;

public class PostOrder {
	public static void postOrder(Node node) {
		if(node == null) return;
		
		if (node != null) {
			postOrder(node.left);
			postOrder(node.right);
			//print(node);
			System.out.print(node.data+" ");
		}
    }
	
	/*private static void print(Node node) {
		System.out.print(node.data+" ");
		
	}*/

	public static void main(String[] args) {
		Node root = new Node(1);
		TreeUtils.insert(root, 2);
		TreeUtils.insert(root, 5);
		TreeUtils.insert(root, 3);
		TreeUtils.insert(root, 4);
		TreeUtils.insert(root, 6);
		//TreeUtils.printTree(root);
		
		postOrder(root);//4 3 6 5 2 1 
	}

}
