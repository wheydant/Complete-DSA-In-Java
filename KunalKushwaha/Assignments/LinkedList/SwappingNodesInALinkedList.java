package KunalKushwaha.Assignments.LinkedList;

public class SwappingNodesInALinkedList {
	public ListNode swapNodes(ListNode head, int k) {
		ListNode first = head;
		ListNode second = head;
		ListNode fast = head;

		// Move fast to the k-th node
		for (int i = 1; i < k; i++) {
			fast = fast.next;
		}

		// first points to k-th node from start
		first = fast;

		// Move fast to end, and second starts after head
		while (fast.next != null) {
			fast = fast.next;
			second = second.next;
		}

		// second now points to k-th node from end

		// Swap values
		int temp = first.val;
		first.val = second.val;
		second.val = temp;

		return head;
	}

	public static void main(String[] args) {

		ListNode head = new ListNode(1,
				new ListNode(2,
						new ListNode(3,
								new ListNode(4,
										new ListNode(5)))));

		ListNode.print(head);
		ListNode.print(new SwappingNodesInALinkedList().swapNodes(head, 2));

		head = new ListNode(7, new ListNode(9, new ListNode(6, new ListNode(6,
				new ListNode(7, new ListNode(8, new ListNode(3, new ListNode(0,
						new ListNode(9, new ListNode(5))))))))));

		ListNode.print(head);
		ListNode.print(new SwappingNodesInALinkedList().swapNodes(head, 5));

		head = new ListNode(1);
		ListNode.print(head);
		ListNode.print(new SwappingNodesInALinkedList().swapNodes(head, 1));

		head = new ListNode(1, new ListNode(2));
		ListNode.print(head);
		ListNode.print(new SwappingNodesInALinkedList().swapNodes(head, 2));

		head = new ListNode(1, new ListNode(2,
				new ListNode(3, new ListNode(4, new ListNode(5)))));
		ListNode.print(head);
		ListNode.print(new SwappingNodesInALinkedList().swapNodes(head, 3));
	}
}
