package m2j.ds.hr.linkedlist;

public class RemoveDuplicates {
	static Node removeDuplicates(Node head) {
		Node curr = head;
		while (curr != null) {
			Node temp = curr;
			while (temp != null && temp.data == curr.data) {
				temp = temp.next;
			}
			curr.next = temp;
			curr = curr.next;
		}

		return head;
	}

	public static void main(String[] args) {
		Node node = new Node();
		node.data = 1;
		Node node2 = new Node();
		node2.data = 2;
		node.next = node2;
		Node node3 = new Node();
		node3.data = 3;
		node2.next = node3;
		Node node4 = new Node();
		node4.data = 3;
		node3.next = node4;
		Node node5 = new Node();
		node5.data = 5;
		node4.next = node5;

		// System.out.println(node);
		LinkedListUtil.printList(removeDuplicates(node));
	}

}
