package m2j.ds.hr.linkedlist;

public class GetNodeFromTail {
	
	static int getNode(Node head, int positionFromTail) {
		Node curr = head;
		Node temp = head;
		int size = 0;
		while(temp!=null) {
			temp = temp.next;
			size++;
		}
		//System.out.println(size);
		
		int d= size-positionFromTail;
		
		while(d >0) {
			curr=curr.next;
			d--;
		}
//		System.out.println(curr.data);
		
		return curr.data;
    }
	static int getNodeE(Node head, int n){
		int len = 0; 
		Node temp = head; 
  
        // 1) count the number of nodes in Linked List 
        while (temp != null) { 
            temp = temp.next; 
            len++; 
        } 
  
        // check if value of n is not more than length of 
        // the linked list 
		/*
		 * if (len < n) return;
		 */
  
        temp = head; 
  
        // 2) get the (len-n+1)th node from the beginning 
        for (int i = 0; i < len - n - 1; i++) 
            temp = temp.next; 
  
        System.out.println(temp.data);
		return temp.data; 
	}
	
	static int getNodeBestWay(Node head, int n){
		Node runner = head;
		for (int i = 0; i < n; i++) {
		    runner = runner.next;
		}
		Node current = head;
		while (runner.next != null) {
		    runner = runner.next;
		    current = current.next;
		}
		return current.data;
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
		int pos=4;
		System.out.println(getNodeE(node, pos));
	}

}
