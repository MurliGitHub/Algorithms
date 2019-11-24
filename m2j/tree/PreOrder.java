package m2j.tree;

public class PreOrder {
	public static void preOrder(Node node) {
		if(node == null) return;
		
		if (node != null) {
			System.out.print(node.data+" ");
		}
		//System.out.println();
		
		preOrder(node.left);
		preOrder(node.right);
		
    }
	
	public static void main(String[] args) {
		Node root = new Node(1);
		TreeUtils.insert(root, 2);
		TreeUtils.insert(root, 5);
		TreeUtils.insert(root, 3);
		TreeUtils.insert(root, 4);
		TreeUtils.insert(root, 6);
		//TreeUtils.printTree(root);
		
		preOrder(root);//1 2 5 3 4 6 
	}

}
