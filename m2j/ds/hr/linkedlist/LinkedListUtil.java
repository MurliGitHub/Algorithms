package m2j.ds.hr.linkedlist;

public class LinkedListUtil {
	
	public static void printList(Node node) {
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
		System.out.println();
	}

}
