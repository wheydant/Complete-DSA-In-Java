package KunalKushwaha.Assignments.LinkedList;

import java.util.Stack;

public class AddTwoNumberII {
	ListNode reverse(ListNode l) {
		ListNode head = new ListNode(0, l);
		ListNode.print(head);
		ListNode temp = l;
		while (temp.next != null) {
			ListNode headNext = head.next;
			ListNode tempNext = temp.next;
			head.next = tempNext;
			temp.next = temp.next.next;
			tempNext.next = headNext;
			ListNode.print(head);
		}
		return head.next;
	}

	public ListNode addTwoNumbersHelper(ListNode l1, ListNode l2) {
		ListNode carry = new ListNode(0);
		ListNode res = new ListNode(0);
		ListNode head = res;
		while (l1 != null && l2 != null) {
			int add = l1.val + l2.val + carry.val;
			ListNode currRes = new ListNode(add % 10);
			res.next = currRes;
			carry.val = add / 10;
			l1 = l1.next;
			l2 = l2.next;
			res = res.next;
		}
		while (l1 != null && carry.val != 0) {
			int add = l1.val + carry.val;
			ListNode currRes = new ListNode(add % 10);
			res.next = currRes;
			carry.val = add / 10;
			l1 = l1.next;
			res = res.next;
		}
		while (l2 != null && carry.val != 0) {
			int add = l2.val + carry.val;
			ListNode currRes = new ListNode(add % 10);
			res.next = currRes;
			carry.val = add / 10;
			l2 = l2.next;
			res = res.next;
		}
		while (l1 != null) {
			res.next = new ListNode(l1.val);
			l1 = l1.next;
			res = res.next;
		}

		while (l2 != null) {
			res.next = new ListNode(l2.val);
			l2 = l2.next;
			res = res.next;
		}

		while (carry.val != 0) {
			res.next = new ListNode(carry.val);
			carry.val = carry.val / 10;
		}
		return head.next;
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		/*l1 = reverse(l1);
		ListNode.print(l1);
		l2 = reverse(l2);

		ListNode ans = addTwoNumbersHelper(l1, l2);

		return reverse(ans);*/

		Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        int carry = 0;
        while(l1 != null){
            s1.push(l1.val);
            l1 = l1.next;
        }
        while(l2 != null){
            s2.push(l2.val);
            l2 = l2.next;
        }
        ListNode ans = new ListNode(0);
        while(!s1.isEmpty() && !s2.isEmpty()){
            int n1 = s1.pop();
            int n2 = s2.pop();
            int add = n1 + n2 + carry;
            carry = add/10;
            ListNode currAdd = new ListNode(add%10, ans.next);
            ans.next = currAdd;
        }
        while(!s1.isEmpty()){
            int n1 = s1.pop();
            int add = n1 + carry;
            carry = add/10;
            ListNode currAdd = new ListNode(add%10, ans.next);
            ans.next = currAdd;
        }
        while(!s2.isEmpty()){
            int n2 = s2.pop();
            int add = n2 + carry;
            carry = add/10;
            ListNode currAdd = new ListNode(add%10, ans.next);
            ans.next = currAdd;
        }
        if(carry == 0) return ans.next;
        ans.val = carry;
        return ans;
	}

	public static void main(String[] args) {
		ListNode.print(
				new AddTwoNumberII().addTwoNumbers(new ListNode(7, new ListNode(2, new ListNode(4, new ListNode(3)))),
						new ListNode(5, new ListNode(6, new ListNode(4)))));
	}
}
