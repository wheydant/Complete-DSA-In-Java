package LeetCode;

public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        ListNode midNode = findMid(head);
        
        reverse(midNode);

        boolean isPalindrome = false;
        ListNode tempNode = midNode.next;
        while(tempNode != null){
            // System.out.println(head + " "+ tempNode);
            if(head.val == tempNode.val){
                isPalindrome = true;
            }else{
                isPalindrome = false;
                break;
            }
            tempNode = tempNode.next;
            head = head.next;
        }
        return isPalindrome;
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
}
