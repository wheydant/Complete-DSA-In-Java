

public class BinarySearchTree {
    public class Node{
        private int value;
        private int height;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
    private Node root;

    public BinarySearchTree() {
    }

    public int height(Node node){
        if(node == null){
            return -1;
        }

        return node.height;
    }

    public boolean isEmpty(){
        return root == null;
    }

    public void display(){
        display(root, "Root node : ");
    }

    private void display(Node node, String details){
        if(node == null){
            return;
        }

        System.out.println(details + node.getValue());

        display(node.left, "Left child of " + node.getValue() + " : ");
        display(node.right, "Right child of " + node.getValue() + " : ");
    }

    public void insert(int value){
        root = insert(value, root);
    }

    //Explanation https://www.youtube.com/watch?v=4s1Tcvm00pA&list=PL9gnSGHSqcnr_DxHsP7AW9ftq0AtAyYqJ&index=49&t=5991s 2hr mark
    private Node insert(int value, Node node){
        if(node == null){
            node = new Node(value);
            return node;
        }
        if(value < node.value){
            node.left = insert(value, node.left);
        }
        if(value > node.value){
            node.right = insert(value, node.right);
        }

        node.height = Math.max(height(node.left), height(node.right)) + 1;
        return node;
    }

    public boolean balanced(){
        return balanced(root);
    }
    private boolean balanced(Node node){
        if(node == null){
            return true;
        }
        //We are using absolute function coz our height function returns -1 when node is null so if one child is leaf and other is null the abs(-1 - 0) = 1
        return Math.abs(height(node.left) - height(node.right)) <= 1 && balanced(node.left) && balanced(node.right);
    }

    public void populate(int[] nums){
        for(int i = 0; i < nums.length; i++){
            insert(nums[i]);
        }
    }
    
    public void prettyDisplay(){
        prettyDisplay(root, 0);
    }

    private void prettyDisplay(Node node, int level){
        if(node == null)return;
        prettyDisplay(node.right, level + 1);
        if(level != 0){
            for(int i = 0; i < level - 1; i++){
                System.out.print("|\t\t");
            }
            System.out.println("|------------->"+node.value);
        }else{
            System.out.println(node.value);
        }

        prettyDisplay(node.left, level + 1);
    }

    public void populateSorted(int[] nums){
        populateSorted(nums, 0, nums.length);
    }
    //O(N*LogN) insert n elements taking log n.
    private void populateSorted(int[] nums, int start, int end){
        if(start >= end)return;

        int mid = (start + end)/2;

        this.insert(nums[mid]);
        populateSorted(nums, start, mid);
        populateSorted(nums, mid+1, end);
    }

    public void orderPrint(){
        System.out.print("PreOrder Traversal - ");
        preOrder(root);
        System.out.print("\nInOrder Traversal - ");
        inOrder(root);
        System.out.print("\nPostOrder Traversal - ");
        postOrder(root);
    }
    private void preOrder(Node node){
        if(node == null)return;
        System.out.print(node.value + " ");
        preOrder(node.left);
        preOrder(node.right);
    }
    private void inOrder(Node node){
        if(node == null)return;
        inOrder(node.left);
        System.out.print(node.value + " ");
        inOrder(node.right);
    }
    private void postOrder(Node node){
        if(node == null)return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value + " ");
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        //If the array is sorted it will create issues.
        int[] nums = {5, 2 , 7 , 1, 4, 6, 9, 8, 3, 10};
        tree.populate(nums);
        tree.display();
        tree.prettyDisplay();
        tree.orderPrint();
        System.out.println("=====================================");
        int[] numsSorted = {1, 2 ,3, 4, 5, 6, 7, 8, 9, 10};
        BinarySearchTree tree2 = new BinarySearchTree();
        tree2.populateSorted(numsSorted);
        tree2.prettyDisplay();
        tree2.orderPrint();
    }
}
