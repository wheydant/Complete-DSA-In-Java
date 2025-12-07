package KunalKushwaha.Assignments.LinkedList;

public class ListNode {
	public int val;
	public ListNode next;

    public ListNode() {
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
	public ListNode(int val){
		this.val = val;
	}

	public static void print(ListNode head){
		int count = 10;
		while (head != null && count >= 0) {
			System.out.print(head.val + "->");
			count--;
			head = head.next;
		}
		System.out.println();
	}
}
