import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTree {
    private Node root;

    private static class Node{
        int value;
        Node left;
        Node right;
        public Node(int value) {
            this.value = value;
        }
        
    }

    public void populate(Scanner sc){
        System.out.println("Enter the root Node: ");
        int value = sc.nextInt();

        root = new Node(value);
        populate(sc, root);
    }

    private void populate(Scanner sc, Node node){
        System.out.println("Do u want to enter left of " + node.value);
        boolean left = sc.nextBoolean();
        if(left){
            System.out.println("Enter the value of the left of " + node.value);
            int value = sc.nextInt();
            node.left = new Node(value);
            populate(sc, node.left);
        }

        System.out.println("Do u want to enter right of " + node.value);
        boolean right = sc.nextBoolean();
        if(right){
            System.out.println("Enter the value of the right of " + node.value);
            int value = sc.nextInt();
            node.right = new Node(value);
            populate(sc, node.right);
        }
    }

    public void display(){
        display(root, "");
    }

    private void display(Node node, String indent){
        if(node == null)return;
        System.out.println(indent + node.value);
        display(node.left, indent + "\t");
        display(node.right, indent + "\t");
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



    public void orderPrint(){
        System.out.print("PreOrder Traversal - ");
        preOrder(root);
        System.out.println("\nInOrder Traversal - ");
        inOrder(root);
        System.out.println("\nPostOrder Traversal - ");
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
        preOrder(node.left);
        System.out.print(node.value + " ");
        preOrder(node.right);
    }
    private void postOrder(Node node){
        if(node == null)return;
        preOrder(node.left);
        preOrder(node.right);
        System.out.print(node.value + " ");
    }

    public void populate(int[] nums){
        Node rootNode = new Node(nums[0]);
        this.root = rootNode;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        while(i < nums.length){
            Node node = queue.poll();

            if(i < nums.length && nums[i] != -1){
                node.left = new Node(nums[i]);
                queue.offer(node.left);
            }
            i++;

            if(i < nums.length && nums[i] != -1){
                node.right = new Node(nums[i]);
                queue.offer(node.right);
            }
            i++;
        }
    }

    public int nextLevelSuccessor(int val){
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        
        while(!queue.isEmpty()){
            int levelLen = queue.size();
            Node node = queue.poll();
            if(node.left != null)queue.offer(node.left);
            if(node.right != null)queue.offer(node.right);

            if(node.value == val){
                Node ansNode = queue.poll();
                return ansNode.value;
            }
        }
        return -1;
    }

    public List<List<Integer>> BFS(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int levelSize = queue.size();
            List<Integer> currLevel = new ArrayList<>();
            for(int i = 0; i < levelSize; i++){
                Node currentNode = queue.poll();
                currLevel.add(currentNode.value);
                if(currentNode.left != null)queue.offer(currentNode.left);
                if(currentNode.right != null)queue.offer(currentNode.right);
            }
            result.add(currLevel);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // BinaryTree tree = new BinaryTree();
        // tree.populate(sc);
        // tree.display();
        // tree.prettyDisplay();

        BinaryTree tree1 = new BinaryTree();
        int[] nums = {1,2,-1,3,4,-1,5};
        tree1.populate(nums);
        tree1.prettyDisplay();
        System.out.println("==========================");
        System.out.println(tree1.nextLevelSuccessor(1));
    }   
}
