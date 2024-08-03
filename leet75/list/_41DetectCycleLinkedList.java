package m2j.da.leet75.list;

public class _41DetectCycleLinkedList {
	public static void main(String[] args) {
		ListNode head = new ListNode(10);
		head.next = new ListNode(20);
		head.next.next = new ListNode(30);
		head.next.next.next = new ListNode(40);
		head.next.next.next.next = new ListNode(50);
		head.next.next.next.next.next = new ListNode(60);

		// Creating a loop resulting in the linked list:
		// 10 -> 20 -> 30 -> 40 -> 10 -> 20 -> 30 ...
		head.next.next.next.next = head;
		// print(head);
		System.out.println(hasCycle(head));
	}

	public static boolean hasCycle(ListNode head) {

		ListNode curr = head;
		ListNode fast = head;

		while (curr != null && fast != null && fast.next != null) {
			curr = curr.next;
			fast = fast.next.next;

			if (curr == fast) {
				return true;
			}
		}

		return false;
	}

	public static void print(ListNode resp) {
		while (resp != null) {
			System.out.print(resp.val + " ");
			resp = resp.next;
		}
		System.out.println();

	}
}
