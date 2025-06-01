public class LL {
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
    private Node head;
    //Benefit of extra variable is O(1) insert last 
    private Node tail;
    private int size;

    public LL(){
        this.size = size;
    }

    public void insertFirst(int val){
        Node node = new Node(val);
        node.next = head;
        head = node;

        if(tail == null){
            tail = head;
        }

        size++;
    }
    public void insertLast(int val){
        if(tail == null){
            insertFirst(val);
            return;
        }
        Node node = new Node(val);
        tail.next = node;
        tail = node;

        size++;
    }
    public void insert(int val, int index){
        if(index == 0){
            insertFirst(val);
            return;
        }
        if(index == size){
            insertLast(val);
            return;
        }

        Node tempHead = head;
        for(int i = 1; i < index; i++){
            tempHead = tempHead.next;
        }

        Node node = new Node(val, tempHead.next);
        tempHead.next = node;
        size++;
    }
    public void deleteFirst(){
        head = head.next;
        if(head == null){
            tail = head;
        }
        size--;
    }
    public void deleteLast(){
        if(size <= 1){
            deleteFirst();
            return;
        }

        Node secondLast = get(size - 2);
        tail = secondLast;
        tail.next = null;
        size--;
    }
    public void delete(int index){
        if(index == 0){
            deleteFirst();
            return;
        }
        if(index == size - 1){
            deleteLast();
            return;
        }

        Node prev = get(index - 1);
        prev.next = prev.next.next;

        size--;
    }
    public Node get(int index){
        Node node = head;
        //System.out.println("Size :" + size);
        for(int i = 0; i < index; i++){
            //System.out.println(node);
            node = node.next;
        }
        return node;
    }

    public Node find(int value){
        Node node = head;
        while(node != null){
            if(node.value == value){
                return node;
            }
            node = node.next;
        }
        return node;
    }

    //insert using recursion
    public void insertRec(int value, int index){
        head = insertRec(value, index, head);
    }
    private Node insertRec(int value, int index, Node node){
        if(index == 0){
            Node temp = new Node(value, node);
            size++;
            return temp;
        }
        //System.out.println("Index - " + index + " "+node);

        node.next = insertRec(value, index-1, node.next);
        return node;
    }
    //Reverse using recursion
    private void reverse(Node node){
        if(node == tail){
            head = tail;
            return;
        }

        reverse(node.next);
        tail.next = node;
        tail = node;
        tail.next = null;
    }
    //Reverse using itteration
    private void reverse(){
        if(head == null)
            return;

        Node prev = null;
        Node present = head;
        Node next = present.next;

        while(present != null){
            present.next = prev;
            prev = present;
            present = next;
            if(next != null)
                next = next.next;
        }
        head = prev;
    }

    @Override
    public String toString() {
        String returnString = "";
        Node tempHead = head;
        while(tempHead != null){
            returnString += tempHead.value + " -> ";
            tempHead = tempHead.next;
        }
        returnString += "null";

        return returnString;
    }



    public static void main(String[] args) {
        LL list = new LL();
        list.insertFirst(3);
        list.insertFirst(2);
        list.insertFirst(1);
        list.insertLast(4);
        list.insert(100, 3);
        list.deleteFirst();
        System.out.println(list);
        list.deleteLast();
        System.out.println(list);
        list.delete(1);
        list.insertRec(150, 1);
        System.out.println(list);
        System.out.println(list.find(100));
    }
}
