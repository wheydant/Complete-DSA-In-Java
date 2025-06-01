package LeetCode;

public class ReOrder {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        ListNode midNode = findMid(head);
        reverse(midNode);

        // System.out.println(midNode);
        ListNode second = midNode.next;
        midNode.next = null;
        ListNode tempHead = head;

        while(second != null && tempHead != null){
            ListNode temp1 = tempHead.next;
            ListNode temp2 = second.next;

            tempHead.next = second;
            second.next = temp1;
            tempHead  = temp1;
            second = temp2;

        }
    }
    ListNode findMid(ListNode head){
        ListNode s = head;
        //For first mid in even.
        ListNode f = head.next;

        while(f != null && f.next != null){
            s = s.next;
            f = f.next.next;
        }

        return s;
    }

    void reverse(ListNode midNode){
        ListNode last = midNode.next;
        ListNode prev = midNode;
        ListNode current = midNode.next;
        ListNode next = (current != null)?current.next : null;

        while(current != null){
            current.next = prev;
            prev = current;
            current = next;
            next =(next != null)? next.next : null;
        }
        if(last != null){
            last.next = null;
        }
        midNode.next =(last != null)? prev:null;
    }
    //Kunals Solution

    public ListNode reverseList(ListNode head){
        if(head == null) return head;

        ListNode prev = null;
        ListNode present = head;
        ListNode next = present.next;

        while(present != null){
            present.next = prev;
            prev = present;
            present = next;
            if(next != null){
                next = next.next;
            }
        }
        return prev;
    }
    public ListNode middleNode(ListNode head){
        ListNode s = head;
        ListNode f = head;

        while(f != null && f.next != null){
            s = s.next;
            f = f.next.next;
        }

        return s;
    }
    public void reorderListLL(ListNode head) {
        if (head == null || head.next == null) return;

        ListNode mid = middleNode(head);
        ListNode hs = reverseList(mid);
        ListNode hf = head;


        while(hf != null && hs != null){
            ListNode temp = hf.next;
            hf.next = hs;
            hf = temp;

            temp = hs.next;
            hs.next = hf;
            hs = temp;

        }

        if(hf != null){
            hf.next = null;
        }
    }
}
