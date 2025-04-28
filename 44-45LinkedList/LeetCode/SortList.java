package LeetCode;

public class SortList {
    //MergeSort
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode mid = getMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);

        return merge(left, right);
    }


    ListNode merge(ListNode list1, ListNode list2){
        ListNode dummyHead = new ListNode();
        ListNode tail = dummyHead;
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
        tail.next = (list1 != null)? list1 : list2;
        return dummyHead.next;
    }

    ListNode getMid(ListNode head){
        //The head pointer passed into getMid() is not changed in sortList() because Java passes a copy of the reference, and you're reassigning it locally in getMid(). But if we change head.val or head.next it will hamper the real node.
        ListNode midPrev = null;
        while(head != null && head.next != null){
            midPrev = (midPrev == null)? head : midPrev.next;
            head = head.next.next;
        }
        //We are breaking the list where mid is new RHS list;
        ListNode mid = midPrev.next;
        //Breaking LHS
        midPrev.next = null;
        return mid;
    }

    void bubbleSort(int row, int col, ListNode head, ListNode tail){
        if(row == 0){
            return;
        }

        if(col < row){
            ListNode first = LinkedList.get(col, head);
            ListNode second = LinkedList.get(col + 1, head);

            if(first.val > second.val){
                //swap
                if(first == head){
                    head = second;
                    first.next = second.next;
                    second.next = first;
                } else if (second == tail) {
                   ListNode prev = LinkedList.get(col - 1, head);
                   prev.next = second;
                   tail = first;
                   first.next = null;
                   second.next = tail;
                }else{
                    ListNode prev = LinkedList.get(col - 1, head);
                    prev.next = second;
                    first.next = second.next;
                    second.next = first;
                }
            }
            bubbleSort(row, col + 1, head, tail);
        }else{
            bubbleSort(row - 1, 0, head, tail);
        }
    }
}
