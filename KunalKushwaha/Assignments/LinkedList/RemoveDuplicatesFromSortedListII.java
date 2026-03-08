package KunalKushwaha.Assignments.LinkedList;

public class RemoveDuplicatesFromSortedListII {
	public ListNode deleteDuplicates(ListNode head) {
		// Prev and Curr node
		ListNode dummyHead = new ListNode(-101, head);
		ListNode prev = dummyHead;
		ListNode curr = head;

		while (curr != null && curr.next != null) {
			if (curr.val == curr.next.val) {
				int val = curr.val;
				while (curr != null && curr.val == val) {
					curr = curr.next;
				}
				prev.next = curr;
			} else {
				prev = curr;
				curr = curr.next;
			}
			// System.out.println("Curr :" + curr);
			// System.out.println("Prev :" + prev);
			// ListNode.print(dummyHead);
		}
		return dummyHead.next;
	}

	public static void main(String[] args) {
		ListNode.print(new RemoveDuplicatesFromSortedListII().deleteDuplicates(new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3)))))));

		ListNode.print(new RemoveDuplicatesFromSortedListII().deleteDuplicates(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(4, new ListNode(4, new ListNode(5)))))))));

		ListNode.print(new RemoveDuplicatesFromSortedListII().deleteDuplicates(new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3))))))));
	}
}
