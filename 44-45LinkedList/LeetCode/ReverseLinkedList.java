package LeetCode;
/*
 * Iteration is better as space complexity is constant but using recursion count for space complexity.
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        //Using iteration 
        if(head == null)
            return head;

        ListNode prev = null;
        ListNode present = head;
        ListNode next = present.next;

        while(present != null){
            present.next = prev;
            prev = present;
            present = next;
            if(next != null)
                next = next.next;
        }
        head = prev;
        if(head != null){
            return head;
        }
        
        // Using recursion
        ListNode temp = head;
        return reverseHelper(head, temp);
    }
    ListNode reverseHelper(ListNode head, ListNode temp){
        if(temp.next == null){
            return head;
        }
        ListNode nextTemp = temp.next;
        temp.next = temp.next.next;
        nextTemp.next = head;
        head = nextTemp;
        return reverseHelper(head, temp);
    }

    //Explanation in notes
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == right){
            return head;
        }

        //Skip left - 1 nodes
        ListNode current = head;
        ListNode prev = null;
        for(int i = 0; current != null && i < left - 1; i++){
            prev = current;
            current = current.next;
        }

        ListNode last = prev;
        ListNode newEnd = current;

        // reverse between left and right
        ListNode next = current.next;
        for(int i = 0; current != null && i < right - left + 1; i++){
            current.next = prev;
            prev = current;
            current = next;
            if(next != null){
                next = next.next;
            }
        }

        if(last != null){
            last.next = prev;
        }else{
            head = prev;
        }

        newEnd.next = current;
        return head;
    }
}
