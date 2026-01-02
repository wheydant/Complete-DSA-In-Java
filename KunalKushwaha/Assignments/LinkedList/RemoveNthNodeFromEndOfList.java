package KunalKushwaha.Assignments.LinkedList;

public class RemoveNthNodeFromEndOfList {
    ListNode tortoise;
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode fast = dummy;
        ListNode slow = dummy;

        // Move fast n+1 steps so slow stops at (len - n)
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

		System.out.println(fast);

        // Move both pointers
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Delete node
        slow.next = slow.next.next;

        return dummy.next;
    }
	public static void main(String[] args) {
		ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

		ListNode.print(head);
		ListNode.print(new RemoveNthNodeFromEndOfList().removeNthFromEnd(head, 2));

		head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

		ListNode.print(new RemoveNthNodeFromEndOfList().removeNthFromEnd(head, 4));

		head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
		ListNode.print(head);
		ListNode.print(new RemoveNthNodeFromEndOfList().removeNthFromEnd(head, 2));

		head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));

		ListNode.print(new RemoveNthNodeFromEndOfList().removeNthFromEnd(head, 4));
	}
}
