package m2j.ds.hr.linkedlist;

public class DeleteNodeAtPos {
	static void reversePrint(Node head) {
		
		Node curr = head;
		Node next = null;
		Node prev = null;
		
		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			
		}
		while(prev != null) {
			System.out.println(prev.data);
			prev= prev.next;
		}
			

    }
	static Node deleteNode(Node head, int position) {
		Node curr = head;
		if(position == 0) return head=head.next;
		while (position>1) {
			curr = curr.next;
			position--;
		}
		  System.out.println(curr);
		curr.next = curr.next.next;
		System.out.println(curr.next);
		
		return head;
    }
	
	static Node delete(Node head, int position){
		if (position == 0) {
	        return head.next;
	    } else {
	    	Node temp = head;
	        for (int i = 0; i < position - 1; i++) {
	        	temp = temp.next;
	        }
	        System.out.println(temp.next.next);
	        temp.next = temp.next.next;
	        return head;
	    }
	}
	
	public static void main(String[] args) {
		Node node = new Node();
		node.data=20;
		Node node2 = new Node();
		node2.data=6;
		node.next=node2;
		Node node3 = new Node();
		node3.data=2;
		node2.next=node3;
		Node node4 = new Node();
		node4.data = 19;
		node3.next=node4;
		Node node5 = new Node();
		node5.data = 7;
		node4.next=node5;
		Node node6 = new Node();
		node6.data = 4;
		node5.next=node6;
		Node node7 = new Node();
		node7.data = 15;
		node6.next=node7;
		Node node8 = new Node();
		node8.data = 9;
		node7.next=node8;
		System.out.println(node);
		
//		SinglyLinkedListNode deleteNode = deleteNode(node, 1);
//		System.out.println(deleteNode);
		
		reversePrint(node);
	}


}
