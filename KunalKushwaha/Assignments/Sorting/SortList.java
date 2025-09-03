package KunalKushwaha.Assignments.Sorting;

public class SortList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; };

        public void toString(ListNode head) {
            while(head != null){
                System.out.print(head.val + " ");
                head = head.next;
            }
            System.out.println();
        }
    }
    
    ListNode sortList(ListNode head){
        if(head == null || head.next == null) return head;

        ListNode mid = findMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);

        // return head;
        return merge(left, right);
    }

    ListNode merge(ListNode l, ListNode r){
        if(r == null) return l;
        if(l == null) return r;

        ListNode h = new ListNode();
        ListNode tempH = h;
        while(r != null && l != null){
            if(r.val < l.val){
                tempH.next = r;
                r = r.next;
            }else{
                tempH.next = l;
                l = l.next;
            }
            tempH = tempH.next;
        }

        tempH.next = (l != null)?l:r;

        return h.next;
    }
    ListNode findMid(ListNode head){
        ListNode hair = head;
        ListNode snailHead = null;
        ListNode snail = head;

        while(hair != null && hair.next != null){
            snailHead = snail;
            hair = hair.next.next;
            snail = snail.next;
        }
        if(snailHead != null)snailHead.next = null;
        // head.toString(head);
        // snail.toString(snail);
        return snail;
    }

    public static void main(String[] args) {
        SortList q = new SortList();
        ListNode node = new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3, new ListNode(6)))));

        node.toString(node);

        node = q.sortList(node);

        node.toString(node);
    }
}
