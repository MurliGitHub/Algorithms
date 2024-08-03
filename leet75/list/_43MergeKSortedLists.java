package m2j.da.leet75.list;

/**
 * @see
 * 
 */


public class _43MergeKSortedLists {
public static void main(String[] args) {
		
		ListNode list1 = new ListNode(2);
		ListNode list12 = new ListNode(4);
		ListNode list13 = new ListNode(6);
		
		list1.next = list12;
		list12.next =  list13;
		
		System.out.println("List1: ");

		ListNode list2 = new ListNode(3);
		ListNode list22 = new ListNode(5);
		ListNode list23 = new ListNode(7);
		
		list2.next = list22;
		list22.next = list23;
		
		System.out.println("list2: ");
		
		ListNode[] lists = {list1, list2};

		
		ListNode resp = mergeKLists(lists);
		

	}
	 public static ListNode mergeKLists(ListNode[] lists) {
		 
		 ListNode head = new ListNode(0);
		 
		 
		 while(lists != null) {}
		 
		return head.next;
	    }
}
