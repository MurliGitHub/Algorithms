
package m2j.ds.hr.tree;

/**
 * @author m2j
 * @see https://www.hackerrank.com/challenges/tree-huffman-decoding/problem
 * 
 *
 */

public class TreeHuffmanDecoding {
	
	static void decodemine(String s, Node root) {
		char[] charArray = s.toCharArray();
		
		Node newNode = root;
		
		for (char c: charArray) {
			
			if(c == '0') {
				newNode = newNode.left;
			}else {
				newNode = newNode.right;
			}
			
			if(newNode.charData!= '$') {
				System.out.print(newNode.charData);
				
				newNode=root;
			}
			
		}
	}

	public static void main(String[] args) {
		String s = "1001011";
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
		
		
		/*root.charData='$';
		root.data = 5;
		root.left.charData='$';
		root.left.data = 2;
		root.left.left.charData='B';
		root.left.left.data=1;
		root.left.right.charData='C';
		root.left.right.data=1;
		
		root.right.charData='A';
		root.right.data = 3;
		*/
		System.out.println(root.toString());
		decodemine(s, root);
		
		//Response -> ABACA
	}
}
