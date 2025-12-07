package KunalKushwaha.Assignments.LinkedList;

public class ReverseLinkedList {
	public void helper(ListNode head, ListNode ptr, ListNode leftPtr, int left, int right) {
		if (left == right)
			return;

		ListNode temp = leftPtr.next;
		if (temp == null)
			return;

		leftPtr.next = temp.next;
		temp.next = ptr.next;
		ptr.next = temp;
		ListNode.print(head);

		helper(head, ptr, leftPtr, left + 1, right);
	}

	public ListNode reverseBetween(ListNode head, int left, int right) {
		if (left == right)
			return head;
		ListNode dummy = new ListNode(0, head);

		ListNode ptr = dummy;
		for (int i = 1; i < left; i++) {
			ptr = ptr.next;
		}
		// System.out.println(head.val + " " + ptr.val);
		helper(dummy, ptr, ptr.next, left, right);
		return dummy.next;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));

		ListNode.print(head);

		ListNode temp = new ReverseLinkedList().reverseBetween(head, 1, 6);

		// ListNode.print(temp);
	}
}
