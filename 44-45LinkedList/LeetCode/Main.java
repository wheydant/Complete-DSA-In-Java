package LeetCode;

public class Main {
    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        list1.insertFirst(2);
        list1.insertFirst(1);
        list1.insertFirst(1);
        System.out.println(list1);

        RemoveDuplicatesFromSortedListSolution Q1 = new RemoveDuplicatesFromSortedListSolution();
        Q1.deleteDuplicates(list1.head);

        System.out.println(list1);

        LinkedList list2 = new LinkedList();
        list2.insertFirst(8);
        list2.insertFirst(4);
        list2.insertFirst(2);
        list2.insertFirst(2);

        LinkedList list3 = new LinkedList();
        list3.insertFirst(5);
        list3.insertFirst(4);
        list3.insertFirst(3);
        list3.insertFirst(1);

        MergeTwoSortedList Q2 = new MergeTwoSortedList();

        // ListNode head2 = Q2.mergeTwoLists(list2.head, list3.head);
        //System.out.println(head2);

        ListNode head2 = Q2.mergeTwoListsKK(list2.head, list3.head);

        list2.display(head2);

        LinkedList list4 = new LinkedList();
        list4.insertFirst(-4);
        list4.insertFirst(0);
        list4.insertFirst(2);
        list4.insertFirst(3);

        System.out.println(list4);
        
        ListNode n4 = list4.find(-4);
        ListNode n2 = list4.find(-2);
        
        // n4.next = n2;

        LinkedListCycle Q3 = new LinkedListCycle();
        System.out.println(Q3.detectCycle(list4.head));

        System.out.println(Q3.hasCycle(list4.head));

        LinkedList list5 = new LinkedList();
        list5.insertFirst(3);
        list5.insertFirst(1);
        list5.insertFirst(2);
        list5.insertFirst(4);

        SortList Q4 = new SortList();
        ListNode tempHead = Q4.sortList(list5.head);
        list5.display(tempHead);

        System.out.println(LinkedList.get(3,tempHead));

        LinkedList list6 = new LinkedList();
        list6.insertFirst(5);
        list6.insertFirst(4);
        list6.insertFirst(3);
        list6.insertFirst(2);
        list6.insertFirst(1);
        System.out.println(list6);

        ReverseLinkedList Q5 = new ReverseLinkedList();
        list6.display(Q5.reverseList(list6.head));

        LinkedList list7 = new LinkedList();
        list7.insertFirst(1);
        // list7.insertFirst(1);
        // list7.insertFirst(31);
        // list7.insertFirst(3);
        // list7.insertFirst(2);
        // list7.insertFirst(1);
        System.out.println("--------------------");
        PalindromeLinkedList Q6 = new PalindromeLinkedList();
        System.out.println(Q6.isPalindrome(list7.head));
        System.out.println(list7);

        LinkedList list8 = new LinkedList();
        list8.insertFirst(4);
        list8.insertFirst(3);
        list8.insertFirst(2);
        list8.insertFirst(1);
        // list8.insertFirst(0);

        System.out.println("----------------");
        System.out.println(list8);

        ReOrder Q7 = new ReOrder();
        Q7.reorderList(list8.head);
        System.out.println(list8);

        LinkedList list9 = new LinkedList();
        list9.insertFirst(4);
        list9.insertFirst(3);
        // list9.insertFirst(2);
        // list9.insertFirst(1);
        // list9.insertFirst(0);
        System.out.println("-------------------");
        System.out.println(list9);
        RotateList Q8 = new RotateList();
        

        list9.display(Q8.rotateRight(list9.head, 2));

    }
}
