package KunalKushwaha.Assignments.LinkedList;

import java.util.Stack;

public class FlattenMultilevelDoublyLinkedList {
	class Node{
		int val;
		Node next;
		Node prev;
		Node child;
	}
	public Node flatten(Node head) {
		Node temp = head;
		Stack<Node> st = new Stack<>();
		while (temp != null) {
			if (temp.child != null) {
				// If next exist, save for later
				Node currNext = temp.next;
				if (currNext != null) {
					st.push(currNext);
				}
				// attach child
				Node currChild = temp.child;
				temp.child = null;
				temp.next = currChild;
				currChild.prev = temp;
			}

			// Reached end of current level and stack has nodes
			while (temp.next == null && !st.isEmpty()) {
				Node stPeek = st.pop();
				temp.next = stPeek;
				stPeek.prev = temp;
			}
			temp = temp.next;
		}

		return head;
	}
}
