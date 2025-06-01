package LeetCode;

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        boolean isCyclic = false;

        while(fast != null && slow != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                isCyclic = true;
                break;
            }
        }
        if(isCyclic){
            int cyclicLength = 0;
            do {
                slow = slow.next;
                cyclicLength++;
            } while (slow != fast);
            System.out.println("Cyclic length - "+cyclicLength);
        }
        return isCyclic;
    }
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        boolean isCyclic = false;

        while(fast != null && slow != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                isCyclic = true;
                break;
            }
        }
        if(isCyclic){
            ListNode tempHead = head;
            while(tempHead != slow){
                tempHead = tempHead.next;
                slow = slow.next;
            }
            return slow;
        }
        return null;

    }

}
