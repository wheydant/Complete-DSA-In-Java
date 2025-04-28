public class CLL {
    private Node head;
    private Node tail;
    private class Node{
        private int value;
        private Node next;

        public Node(int value){
            this.value = value;
        }

        public Node(int value, Node next){
            this.value = value;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node [value=" + value + "]";
        }
    }
    public CLL() {
        this.head = null;
        this.tail = null;
    }

    public void insert(int val){
        Node node = new Node(val);
        if(head == null){
            head = node;
            tail = node;
            return;
        }

        tail.next = node;
        node.next = head;
        tail = node;
    }
    @Override
    public String toString() {
        String returnString = "";
        Node tempHead = head;
        if(head != null){
            do { 
                returnString += tempHead.value + " -> ";
                tempHead = tempHead.next;    
            } while (tempHead != head);
        }
        returnString += "Loop";

        return returnString;
    }

    public void delete(int val){
        Node node = head;
        if(node == null){
            return;
        }

        if(node.value == val){
            head = head.next;
            tail.next = head;
            return;
        }
        do { 
            Node n = node.next;
            if(n.value == val){
                node.next = n.next;
                break;
            }
            node = node.next;
        } while (node != head);
    }

    public static void main(String[] args) {
        CLL list = new CLL();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.delete(3);
        System.out.println(list);
    }
}
