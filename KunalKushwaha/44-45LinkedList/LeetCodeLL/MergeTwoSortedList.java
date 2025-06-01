package LeetCode;

public class MergeTwoSortedList {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head1;
        ListNode head2;
        ListNode head;
        if(list1 != null && list2 != null && list1.val <= list2.val){
            head1 = list1;
            head2 = list2;
            head = list1;
        }else{
            head1 = list2;
            head2 = list1;
            head = list2;
        }

        while(head1 != null && head2 != null){
            // System.out.println("List 1 " +head1 + " List 2 " + head2);
            if(head1.next != null && head1.next.val < head2.val){
                head1 = head1.next;
            }else{
                // System.out.println("Insert");
                ListNode tempHead1 = head1.next;
                head1.next = head2;
                head2 = head2.next;
                head1.next.next = tempHead1;
                head1 = head1.next;
            }
        }
        if(head1 != null){
            if(head2 != null){
                head1.next = head2;
            }
        }else{
            head = head2;
        }
        

        return head;
    }

    public ListNode mergeTwoListsKK(ListNode list1, ListNode list2){
        ListNode tempHead = new ListNode();
        ListNode tail = tempHead;

        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                tail.next = list1;
                list1 = list1.next;
                tail = tail.next;
            }else{
                tail.next = list2;
                list2 = list2.next;
                tail = tail.next;
            }
        }

        tail.next = (list1 != null) ? list1 : list2;
        return tempHead.next;
    }
}
