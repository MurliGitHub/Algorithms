package m2j.da.leet75.list;

class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
	
}

public class _42MergeTwoSortedLists {
	public static void main(String[] args) {
		
		ListNode list1 = new ListNode(2);
		ListNode list12 = new ListNode(4);
		ListNode list13 = new ListNode(6);
		
		list1.next = list12;
		list12.next =  list13;
		
		System.out.println("List1: ");

		print(list1);
		
		ListNode list2 = new ListNode(3);
		ListNode list22 = new ListNode(5);
		ListNode list23 = new ListNode(7);
		
		list2.next = list22;
		list22.next = list23;
		
		System.out.println("list2: ");

		print(list2);
		
		ListNode resp = mergeTwoLists(list1, list2);
		
		print(resp);

	}

	private static void print(ListNode resp) {
		while(resp!=null) {
			System.out.print(resp.val+" ");
			resp = resp.next;
		}
		System.out.println();
		
	}

	public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

		ListNode temp = new ListNode(0);

		ListNode curr = temp;

		while (list1 != null && list2 != null) {
			if (list1.val <= list2.val) {
				curr.next = list1;
				list1 = list1.next;
			} else {
				curr.next = list2;
				list2 = list2.next;
			}

			curr = curr.next;
		}

		curr.next = list1 != null ? list1 : list2;

		return temp.next;
	}

}
