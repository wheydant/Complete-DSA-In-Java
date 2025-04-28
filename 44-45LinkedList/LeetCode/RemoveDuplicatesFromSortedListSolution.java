package LeetCode;

public class RemoveDuplicatesFromSortedListSolution{
        public ListNode deleteDuplicates(ListNode head) {
            ListNode tempHead = head;
            while(tempHead != null){
                while(tempHead.next != null && tempHead.val == tempHead.next.val){
                    tempHead.next = tempHead.next.next;
                }
                tempHead = tempHead.next;
            }
            return head;
        }
}