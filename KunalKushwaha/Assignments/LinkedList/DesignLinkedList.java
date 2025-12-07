package KunalKushwaha.Assignments.LinkedList;

public class DesignLinkedList {
	MyLinkedList linkedList;

    public DesignLinkedList() {
		linkedList = new MyLinkedList();
    }

	class MyLinkedList {
		Node head;
		Node tail;
		int size;

		class Node {
			int val;
			Node next;

			public Node(int val, Node next) {
				this.val = val;
				this.next = next;
			}

			public Node(int val) {
				this.val = val;
				this.next = null;
			}
		}

		public MyLinkedList() {
			head = null;
			tail = head;
			size = 0;
		}

		public int get(int index) {
            if (index < 0 || index >= size) return -1;

            Node curr = head;
            for (int i = 0; i < index; i++) {
                curr = curr.next;
            }
            return curr.val;
		}

		public void addAtHead(int val) {
			Node node = new Node(val);
			node.next = head;
			head = node;
			if (size == 0) {
				tail = node;
			}
			size++;
			// System.out.println(this);
		}

		public void addAtTail(int val) {
            Node node = new Node(val);

            if (size == 0) {
                head = tail = node;
            } else {
                tail.next = node;
                tail = node;
            }

            size++;
            // System.out.println(this);
		}

		public void addAtIndex(int index, int val) {
            if (index < 0 || index > size) return;

            if (index == 0) {
                addAtHead(val);
                return;
            }

            if (index == size) {
                addAtTail(val);
                return;
            }

            Node curr = head;
            for (int i = 0; i < index - 1; i++) {
                curr = curr.next;
            }

            Node node = new Node(val);
            node.next = curr.next;
            curr.next = node;

            size++;
            // System.out.println(this);
		}

		public void deleteAtIndex(int index) {
            if (index < 0 || index >= size) return;

            if (index == 0) {
                head = head.next;
                if (size == 1) tail = null;
                size--;
                System.out.println(this);
                return;
            }

            Node curr = head;
            for (int i = 0; i < index - 1; i++) {
                curr = curr.next;
            }

            curr.next = curr.next.next;

            if (index == size - 1) {
                tail = curr;
            }

            size--;
            // System.out.println(this);
		}

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            Node temp = head;
            while(temp != null){
                sb.append(temp.val + "->");
				temp = temp.next;
            }
            return sb.toString();
		}
		
	}
	public static void main(String[] args) {
		DesignLinkedList q = new DesignLinkedList();
		MyLinkedList linkedList = q.linkedList;

		linkedList.addAtHead(1);
		linkedList.addAtTail(3);
		// linkedList.addAtIndex(1,2);
		linkedList.addAtIndex(0,4);
		System.out.println(linkedList.get(1));
		System.out.println(linkedList.get(3));
		linkedList.deleteAtIndex(2);
	}
}