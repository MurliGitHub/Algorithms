package m2j.ds.hr.linkedlist;

public class MergeTwoSortedList {
	
	 static Node merge(Node h1, Node h2) 
	    { 
	        if (h1 == null) 
	            return h2; 
	        if (h2 == null) 
	            return h1; 
	  
	        // start with the linked list 
	        // whose head data is the least 
	        if (h1.data < h2.data) { 
	            h1.next = merge(h1.next, h2); 
	            return h1; 
	        } 
	        else { 
	            h2.next = merge(h1, h2.next); 
	            return h2; 
	        } 
	    } 
	
	private static Node sortedMerge(Node head1, Node head2) {
		Node result = null;

		if (head2 == null) {
			return head1;
		}

		if (head1 == null) {
			return head2;
		}

		if (head2.data <= head1.data) {
			result = head2;
			result.next = sortedMerge(head2.next, head1);
		} else {
			result = head1;
			result.next = sortedMerge(head2, head1.next);
		}

		return result;

	}
	
	public static void main(String[] args) {
		Node node = new Node();
		node.data = 1;
		Node node2 = new Node();
		node2.data = 2;
		node.next = node2;
		Node node3 = new Node();
		node3.data = 9;
		node2.next = node3;

		Node node21 = new Node();
		node21.data = 3;
		Node node22 = new Node();
		node22.data = 4;
		node21.next = node22;

		System.out.println(node);
		System.out.println(node21);
	/*	System.out.println("Head1 is: ");
		while(node != null) {
			System.out.print(node.data + " ");
			node=node.next;
		}
		System.out.println();
		
		System.out.println("Head2 is: ");
		while(node21 != null) {
			System.out.print(node21.data + " ");
			node21 = node21.next;
		}
		System.out.println();*/
		
		Node sortedMerge = sortedMerge(node, node21);
	//	System.out.println(sortedMerge);
		while(sortedMerge!=null) {
			System.out.print(sortedMerge.data+" ");
			sortedMerge = sortedMerge.next;
		}
		System.out.println();
	}
	
	  // Merges two lists with headers as h1 and h2. 
    // It assumes that h1's data is smaller than 
    // or equal to h2's data. 
    static Node mergeUtil(Node h1, Node h2) 
    { 
        // if only one node in first list 
        // simply point its head to second list 
        if (h1.next == null) { 
            h1.next = h2; 
            return h1; 
        } 
  
        // Initialize current and next pointers of 
        // both lists 
        Node curr1 = h1, next1 = h1.next; 
        Node curr2 = h2, next2 = h2.next; 
  
        while (next1 != null && curr2 != null) { 
            // if curr2 lies in between curr1 and next1 
            // then do curr1->curr2->next1 
            if ((curr2.data) >= (curr1.data) && (curr2.data) <= (next1.data)) { 
                next2 = curr2.next; 
                curr1.next = curr2; 
                curr2.next = next1; 
  
                // now let curr1 and curr2 to point 
                // to their immediate next pointers 
                curr1 = curr2; 
                curr2 = next2; 
            } 
            else { 
                // if more nodes in first list 
                if (next1.next != null) { 
                    next1 = next1.next; 
                    curr1 = curr1.next; 
                } 
  
                // else point the last node of first list 
                // to the remaining nodes of second list 
                else { 
                    next1.next = curr2; 
                    return h1; 
                } 
            } 
        } 
        return h1; 
    } 
  
    // Merges two given lists in-place. This function 
    // mainly compares head nodes and calls mergeUtil() 
    static Node mergeIterative(Node h1, Node h2) 
    { 
        if (h1 == null) 
            return h2; 
        if (h2 == null) 
            return h1; 
  
        // start with the linked list 
        // whose head data is the least 
        if (h1.data < h2.data) 
            return mergeUtil(h1, h2); 
        else
            return mergeUtil(h2, h1); 
    }

}
