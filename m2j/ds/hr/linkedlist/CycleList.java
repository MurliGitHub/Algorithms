package m2j.ds.hr.linkedlist;

public class CycleList {
	static boolean hasCycle(Node head) {
		Node next = head;
		Node curr = head;
		while (curr != null && next != null && next.next != null) {
			curr = curr.next;
			next = next.next.next;
			if (curr == next)
				return true;

		}
		return false;
	}

	public static void main(String[] args) {
		Node head = new Node();
		head.data = 1;

		System.out.println(hasCycle(head));

	}

}
