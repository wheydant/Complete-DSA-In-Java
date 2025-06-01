package LeetcodeTrees;

import java.util.LinkedList;
import java.util.Queue;


public class PopulatingNextRightPointersInEachNode {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;
        
        public Node() {}
        
        public Node(int _val) {
            val = _val;
        }
    
        public Node(int _val, Node _left, Node  _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
    private Node VKSol(Node root){
        if(root == null)return root;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int levelLen = queue.size();
            Node prev = null;
            for(int i = 0; i < levelLen; i++){
                Node node = queue.poll();
                if(prev != null){
                    prev.next = node;
                }
                prev = node;
                if(node.left != null)queue.offer(node.left);
                if(node.right != null)queue.offer(node.right);
            }
        }
        return root;
    }
    public Node connect(Node root) {
        if(root == null)return root;
        Node leftMost = root;
        while(leftMost.left != null){
            Node curr = leftMost;
            while(curr != null){
                curr.left.next = curr.right;
                if(curr.next != null)curr.right.next = curr.next.left;
                curr = curr.next;
            }
            leftMost = leftMost.left;
        }
        return root;
    }
}
