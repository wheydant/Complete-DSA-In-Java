public class DLL {
    private class Node{
        private int value;
        private Node next;
        private Node prev;

        public Node(int value){
            this.value = value;
        }

        public Node(int value, Node next, Node prev){
            this.value = value;
            this.next = next;
            this.prev = prev;
        }

        @Override
        public String toString() {
            return "Node [value=" + value + "]";
        }
    }
    
    Node head;

    public void insertFirst(int val){
        Node node = new Node(val);

        node.next = head;
        node.prev = null;

        if(head != null){
            head.prev = node;
        }

        head = node;
    }

    public void insertLast(int val){
        if(head == null){
            insertFirst(val);
            return;
        }
        Node tempHead = head;
        while(tempHead.next != null){
            tempHead = tempHead.next;
        }
        Node node = new Node(val);
        tempHead.next = node;
        node.prev = tempHead;
    }

    public void insert(int val, int index){
        if(head == null || index == 0){
            insertFirst(val);
            return;
        }
        Node tempHead = head;
        for(int i = 1; i < index; i++){
            if(tempHead.next != null)
                tempHead = tempHead.next;
            else
                insertLast(val);
        }
        Node node = new Node(val, tempHead.next, tempHead);

        tempHead.next.prev = node;
        tempHead.next = node;
    }

    public void insertAfter(int value, int nodeValue){
        Node tempNode = find(nodeValue);
        if(tempNode == null || tempNode == head){
            insertFirst(value);
        }
        Node node = new Node(value, tempNode.next, tempNode);
        tempNode.next.prev = node;
        tempNode.next = node;
    }

    public Node find(int value){
        Node tempHead = head;
        while(tempHead != null){
            if(tempHead.value == value){
                return tempHead;
            }
            tempHead = tempHead.next;
        }

        return tempHead;
    }
    @Override
    public String toString() {
        String returnString = "Display inOrder - ";
        Node tempHead = head;
        Node lastNode = null;
        while(tempHead != null){
            returnString += tempHead.value + " -> ";
            lastNode = tempHead;
            tempHead = tempHead.next;
        }
        returnString += "null\n";
        returnString += "Display revOrder - ";
        
        while(lastNode != null){
            returnString += lastNode.value + " -> ";
            lastNode = lastNode.prev;
        }
        returnString += "null";


        return returnString;
    }

    public static void main(String[] args) {
        DLL list = new DLL();
        list.insertLast(0);
        list.insertFirst(3);
        list.insertFirst(2);
        list.insertFirst(1);
        list.insertLast(4);
        list.insert(100, 3);
        list.insertAfter(20, 100);
        System.out.println(list);
    }
}
