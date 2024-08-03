package m2j.ds.hr.tree;

/**
 * @author m2j
 * @see 
 *
 */
public class CheckBST {
	static boolean checkBSTBF(Node root) {

		if (root == null)
			return true;


		if ((root.left != null) && (root.left.data > root.data))
			return false;
		
		if ((root.right != null) && (root.right.data < root.data))
			return false;
		
		if(!checkBSTBF(root.left)) return false;
		
		if(!checkBSTBF(root.right)) return false;

		return true;
	}
	
	

	public static void main3(String[] args) {
		/*
		 * Node root = new Node(3); TreeUtils.insert(root, 5); TreeUtils.insert(root,
		 * 2); TreeUtils.insert(root, 1); TreeUtils.insert(root, 4);
		 * TreeUtils.insert(root, 6); TreeUtils.insert(root, 7);
		 */

		Node root = new Node();

		root.setData(3);
		root.setLeft(new Node(5));
		root.getLeft().setLeft(new Node(1));
		root.getLeft().setRight(new Node(4));

		root.setRight(new Node(2));
		root.getRight().setLeft(new Node(6));
		/*
		 * root.data=3; root.left.data = 5; root.left.left.data = 1;
		 * root.left.right.data = 4;
		 * 
		 * root.right.data = 2; root.right.left.data = 6;
		 */

		System.out.println(checkBST(root));
	}

	static boolean checkBST(Node root) {
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    static boolean isBST(Node root, int min, int max){
        if(root == null) return true;
        
        if(root.data <= min ||root.data >= max) return false;
        
        System.out.println("Min Val is: "+ min);
        System.out.println("Max Val is: "+ max);
        
        return isBST(root.left, min, root.data) && isBST(root.right, root.data, max);
    }



	public static void main(String[] args) {

		Node root = new Node(3);
		TreeUtils.insert(root, 5);
		TreeUtils.insert(root, 2);
		TreeUtils.insert(root, 1);
		TreeUtils.insert(root, 4);
		TreeUtils.insert(root, 6);
		TreeUtils.insert(root, 7);

		System.out.println(checkBST(root));
	}

}
