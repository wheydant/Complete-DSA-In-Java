package KunalKushwaha.Assignments.LinkedList;

import java.util.HashMap;

public class RemoveZeroSumConsecutuveNodesFromLinkedList{
	public ListNode removeZeroSumSublists(ListNode head) {
                ListNode dummy = new ListNode(0);
        dummy.next = head;

        HashMap<Integer, ListNode> map = new HashMap<>();
        int prefixSum = 0;

        // First pass: store last node for each prefix sum
        ListNode curr = dummy;
        while (curr != null) {
            prefixSum += curr.val;
            map.put(prefixSum, curr);
            curr = curr.next;
        }

        // Second pass: remove zero-sum sublists
        prefixSum = 0;
        curr = dummy;
        while (curr != null) {
            prefixSum += curr.val;
            curr.next = map.get(prefixSum).next;
            curr = curr.next;
        }

        return dummy.next;
    }
}