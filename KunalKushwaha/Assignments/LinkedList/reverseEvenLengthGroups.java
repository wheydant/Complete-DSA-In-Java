package KunalKushwaha.Assignments.LinkedList;

public class reverseEvenLengthGroups {
	public ListNode reverseEvenLengthGroups(ListNode head) {
		ListNode dummy = new ListNode(0, head);
		ListNode prev = dummy;
		ListNode curr = head;
		int groupLen = 1;
		while(curr != null){
			int count = 0;
			ListNode temp = curr;
			
			while(temp != null && count < groupLen){
				temp = temp.next;
				count++;
			}

			if(count%2 == 0){
				prev.next = reverseLL(curr, count);
				curr.next = temp;
				prev = curr;
				curr = temp;
			}else{
				for(int i = 0; i < count; i++){
					prev = curr;
					curr = curr.next;
				}
			}

			groupLen++;
		}

		return dummy.next;
	}

	ListNode reverseLL(ListNode curr, int k){
		ListNode prev = null;
		ListNode temp = curr;
		while(k > 0){
			ListNode nex = temp.next;
			temp.next = prev;
			prev = temp;
			temp = nex;
			k--;
		}

		return prev;
	}
}
