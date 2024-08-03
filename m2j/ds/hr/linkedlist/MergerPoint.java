package m2j.ds.hr.linkedlist;

public class MergerPoint {
	static int findMergeNode(Node head1, Node head2) {
		Node curr1 = head1;
		Node curr2 = head2;

		while (curr1 != curr2) {
			if (curr1.next == null) {
				curr1 = head2;
			} else {
				curr1 = curr1.next;
			}

			if (curr2.next == null) {
				curr2 = head1;
			} else {
				curr2 = curr2.next;
			}
		}

		return curr1.data;
	}

	public static void main(String[] args) {

	}

}
