package m2j.da.leet75;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @see https://leetcode.com/problems/merge-k-sorted-lists/description/
 * 
 *      Example 1:
 * 
 *      Input: lists = [[1,4,5],[1,3,4],[2,6]] Output: [1,1,2,3,4,4,5,6]
 *      Explanation: The linked-lists are: [ 1->4->5, 1->3->4, 2->6 ] merging
 *      them into one sorted list: 1->1->2->3->4->4->5->6 Example 2:
 * 
 *      Input: lists = [] Output: [] Example 3:
 * 
 *      Input: lists = [[]] Output: []
 */
public class _73MergerKSortedList {
	public static void main(String[] args) {
		// Input: lists = [[1,4,5],[1,3,4],[2,6]] Output: [1,1,2,3,4,4,5,6]

		Node[] arr = new Node[3];

		arr[0] = new Node(1);
		arr[0].next = new Node(4);
		arr[0].next.next = new Node(5);

		arr[1] = new Node(1);
		arr[1].next = new Node(3);
		arr[1].next.next = new Node(4);

		arr[2] = new Node(2);
		arr[2].next = new Node(6);

		// Merge all lists
		Node head = mergeKListsCopied3(arr);
		printList(head);
		
		// Merge all lists
//		Node two = mergeTwoSortedList(arr[0], arr[1]);
//		printList(two);
	}
	
	static Node mergeKListsCopied3(Node arr[])
    {
		int last = arr.length-1;
 
        // Traverse form second list to last
        for (int i = 1; i <= last; i++) {
            while (true) {
 
                // head of both the lists,
                // 0 and ith list.
                Node head_0 = arr[0];
                Node head_i = arr[i];
 
                // Break if list ended
                if (head_i == null)
                    break;
 
                // Smaller than first element
                if (head_0.val >= head_i.val) {
                    arr[i] = head_i.next;
                    head_i.next = head_0;
                    arr[0] = head_i;
                }
                else {
 
                    // Traverse the first list
                    while (head_0.next != null) {
 
                        // Smaller than next element
                        if (head_0.next.val
                            >= head_i.val) {
                            arr[i] = head_i.next;
                            head_i.next = head_0.next;
                            head_0.next = head_i;
                            break;
                        }
 
                        // go to next node
                        head_0 = head_0.next;
 
                        // if last node
                        if (head_0.next == null) {
                            arr[i] = head_i.next;
                            head_i.next = null;
                            head_0.next = head_i;
                            head_0.next.next = null;
                            break;
                        }
                    }
                }
            }
        }
        return arr[0];
    }
	
	public static Node mergeKListsCopied2(Node[] lists) {

		if (lists == null || lists.length == 0) {
			return null;
		}

		Node dummy = new Node(0);
		Node prev = dummy;
		Node current;
		Node next;

		PriorityQueue<Node> minHeap = new PriorityQueue<>(Comparator.comparingInt(head -> head.val));

		for (Node node : lists) {
			if (node != null) {
				minHeap.add(node);
			}
		}

		while (!minHeap.isEmpty()) {
			current = minHeap.remove();

			if (current == null) {
				continue;
			}

			next = current.next;
			current.next = null;
			prev.next = current;
			prev = current;
			if (next != null) {
				minHeap.add(next);
			}
		}

		return dummy.next;
	}

	public static Node mergeKListsCopied(Node[] lists) {
		// Initialize a min-heap (priority queue) to hold nodes and sort them by their value.
		PriorityQueue<Node> priorityQueue = new PriorityQueue<>((node1,node2) -> node1.val-node2.val);
		
		// Add the first node of each list to the priority queue, if it is not null.
        for (Node head : lists) {
            if (head != null) {
                priorityQueue.offer(head);
            }
        }

     // Create a dummy node that will serve as the head of the merged list.
        Node dummyHead = new Node();
        // A pointer to track the current node's position in the merged list.
        Node current = dummyHead;
      
        // Continue merging until the priority queue is empty.
        while (!priorityQueue.isEmpty()) {
            // Poll the priority queue to get the node with the smallest value.
            Node smallestNode = priorityQueue.poll();
          
            // If the smallest node has a next node, add it to the priority queue.
            if (smallestNode.next != null) {
                priorityQueue.offer(smallestNode.next);
            }
          
            // Connect the current node in the merged list to the smallest node.
            current.next = smallestNode;
            // Move the current pointer forward.
            current = current.next;
        }
      
        // Return the merged list, skipping the dummy head.
        return dummyHead.next;
	}
	
	public static Node mergeTwoSortedList(Node list1, Node list2) {
		
		Node result = null;

		if (list2 == null) {
			return list1;
		}

		if (list1 == null) {
			return list2;
		}
		
		if(list1.val>= list2.val) {
			result = list2;
			result.next = mergeTwoSortedList(list2.next, list1);
		}else {
			result = list1;
			result.next = mergeTwoSortedList(list2, list1.next);
		}
		
		return result;
	}

	static void printList(Node node) {
		while (node != null) {
			System.out.print(node.val + " ");

			node = node.next;
		}
		System.out.println();
	}

}

class Node {
	int val;
	Node next;

	Node() {
	}

	Node(int val) {
		this.val = val;
		next = null;
	}

	Node(int val, Node next) {
		this.val = val;
		this.next = next;
	}
}
