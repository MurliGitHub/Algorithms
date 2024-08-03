package m2j.ds.hr.tree;

public class LCA_Binary {
	public static void main(String[] args) {
		Node root = new Node(4);
		insertL(root, 2);
		insertL(root, 7);
		insertL(root, 3);
		insertL(root, 1);
		insertL(root, 6);
		//TreeUtils.printTree(root);
//4 2 3 1 7 6
		//lca(root);
		int v1=1;
		int v2=3;
		Node lca = lca(root, v1, v2);
        System.out.println("LCA of " + v1 + " and " + v2 + " is " + lca.data); 
	}
	
	public static Node lca(Node root, int v1, int v2) {
		if(root == null) return root;
		
		//if(root.data == v1 || root.data==v2) return root;
		
		if(root.data > v1 && root.data > v2){
			return lca(root.left, v1, v2);
		}
		
		if(root.data < v1 && root.data < v2){
			return lca(root.right, v1, v2);
		}
		
		return root;
    }
	
	public static Node insertL(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insertL(root.left, data);
                root.left = cur;
            } else {
                cur = insertL(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }
}
