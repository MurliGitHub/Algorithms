package m2j.ds.hr.tree;

public class APp {
	public static void main(String[] args) {
		String s = "1001011";
		
		for (char c: s.toCharArray()) {
			if(c=='0') {
				System.out.println("Move Left");
			}else {
				System.out.println("Right move");
			}
		}
		
		Node root = new Node(5);
		root.setCharData('$');
		Node left = new Node(2);
		left.setCharData('$');
		root.setLeft(left);
		Node leftLeft = new Node(1);
		leftLeft.setCharData('B');
		root.getLeft().setLeft(leftLeft);
		
		Node leftRight = new Node(1);
		leftRight.setCharData('C');
		root.getLeft().setRight(leftRight);
		
		Node right = new Node(3);
		right.setCharData('A');
		
		root.setRight(right);
		
		Node newNode = root;
		
		for (char c: s.toCharArray()) {
			
			if(c == '0') {
				newNode = newNode.left;
			}else {
				newNode = newNode.right;
			}
			
			if(newNode.charData!= '$') {
				System.out.print(newNode.charData+"");
				
				newNode=root;
			}
			
		}
		
	}

}
