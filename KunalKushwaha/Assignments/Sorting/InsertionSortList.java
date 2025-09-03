package KunalKushwaha.Assignments.Sorting;
public class InsertionSortList{

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
        }
    }

    public ListNode insertionSortList(ListNode head) {
		if( head == null ){
			return head;
		}
		
		ListNode helper = new ListNode(0); //new starter of the sorted list
		ListNode cur = head; //the node will be inserted
		ListNode pre = helper; //insert node between pre and pre.next
		ListNode next = null; //the next node will be inserted
		//not the end of input list
		while( cur != null ){
			next = cur.next;
			//find the right place to insert
			while( pre.next != null && pre.next.val < cur.val ){
				pre = pre.next;
			}
			//insert between pre and pre.next
			cur.next = pre.next;
			pre.next = cur;

            //It helps to again start from head.
			pre = helper;
			cur = next;
		}
		
		return helper.next;
    }

    public static void main(String[] args) {
        InsertionSortList q = new InsertionSortList();
        ListNode node = new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3))));

        node.toString(node);

        q.insertionSortList(node);


    }
}