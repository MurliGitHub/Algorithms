package m2j.ds.hr.linkedlist;

public class InsertAtTail {
	
	static Node insertNodeAtTail(Node head, int data) {
		if(head == null) {
			head = new Node();
			head.data = data;
			head.next=null;
			return head;
		}else {
			Node newNode = new Node();
			Node curr = head;
			newNode.data = data;
			newNode.next=null;
			while(curr.next!=null) {
				curr = curr.next;
			}
			curr.next=newNode;
		}
		
		return head;
    }
	
	public static void main(String[] args) {
		Node head =null;
		head = insertNodeAtTail(head, 141);
		head = insertNodeAtTail(head, 302);
		head = insertNodeAtTail(head, 164);
		display(head);
	}
	
	static void display(Node node) {
		if (node == null) {
			throw new RuntimeException("List is empty");
		}
		Node currentNode = node;

		while (currentNode != null) {
			System.out.print(currentNode.data + " -> ");
			currentNode = currentNode.next;
		}
		System.out.println("NULL");
	}

}
