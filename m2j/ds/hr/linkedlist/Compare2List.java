package m2j.ds.hr.linkedlist;

public class Compare2List {
	static boolean compareLists(Node head1, Node head2) {
		while (head1 != null && head2 != null) {
			if(head1.data != head2.data) 
				return false;
			
			head1 = head1.next;
			head2 = head2.next;
		}
		return (head1 == null && head2==null);
	}

	public static void main(String[] args) {
		Node node = new Node();
		node.data = 1;
		Node node2 = new Node();
		node2.data = 2;
		node.next = node2;

		Node node21 = new Node();
		node21.data = 1;
		Node node22 = new Node();
		node22.data = 2;
		node21.next = node22;

		System.out.println(node);
		System.out.println(node21);
		System.out.println(compareLists(node, node21));
	}

}
