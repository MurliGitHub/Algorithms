package m2j.ds.hr.linkedlist;

public class InsertingSortedDoublyLinkedList {
	static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode head, int data) {
		DoublyLinkedListNode current = head;
		DoublyLinkedListNode previous = null;
		while (current != null && current.data < data) {
		    previous = current;
		    current = current.next;
		}

		DoublyLinkedListNode node = new DoublyLinkedListNode();
		node.data = data;

		if (previous == null) {
		    head = node;
		} else {
		    // re-link previous node
		    previous.next = node;
		    node.prev = previous;
		}

		if (current != null) {
		    // re-link next node
		    current.prev = node;
		    node.next = current;
		}

		return head;
	}

	public static void main(String[] args) {

	}

}
