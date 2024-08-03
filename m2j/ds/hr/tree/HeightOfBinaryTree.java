package m2j.ds.hr.tree;

public class HeightOfBinaryTree {
	public static int height(Node node){
		int max=0;
		if(node == null) return -1;
		else{
			int rHeight = height(node.right);
			int lHeight = height(node.left);
			
			if(rHeight>lHeight) max= rHeight+1;
			else 
				max= lHeight+1;
		}
		return max;
	}
	
	public static void main(String[] args) {
		Node root = new Node(3);
		TreeUtils.insert(root, 5);
		TreeUtils.insert(root, 2);
		TreeUtils.insert(root, 1);
		TreeUtils.insert(root, 4);
		TreeUtils.insert(root, 6);
		TreeUtils.insert(root, 7);
		//TreeUtils.printTree(root);
		
		//3 5 2 1 4 6 7
		
		System.out.println(height(root));//3
	}

}
