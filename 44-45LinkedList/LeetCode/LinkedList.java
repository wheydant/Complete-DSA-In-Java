package LeetCode;

public class LinkedList {

    public ListNode head;
    @Override
    public String toString() {
        String returnString = "";
        ListNode tempHead = head;
        while(tempHead != null){
            returnString += tempHead.val + " -> ";
            tempHead = tempHead.next;
        }
        returnString += "null";

        return returnString;
    }

    public void display(ListNode head){
        String returnString = "";
        ListNode tempHead = head;
        while(tempHead != null){
            returnString += tempHead.val + " -> ";
            tempHead = tempHead.next;
        }
        returnString += "null";

        System.out.println(returnString);
    }

    public void insertFirst(int val){
        ListNode node = new ListNode(val);
        node.next = head;
        head = node;
    }

    public ListNode find(int value){
        ListNode node = head;
        while(node != null){
            if(node.val == value){
                return node;
            }
            node = node.next;
        }
        return node;
    }
    public static ListNode get(int index, ListNode head){
        ListNode tempHead = head;
        // System.out.println(head.next);
        for(int i = 0; i < index; i++){
            tempHead = tempHead.next;
        }

        return tempHead;
    }
}


