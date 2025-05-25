package LeetcodeTrees;

import java.util.LinkedList;
import java.util.Queue;

public class FlattenBinaryTreeToLinkedList {
    //Optimum No extra space
    public void flatten(TreeNode root) {
        TreeNode curr = root;
        while(curr != null){
            if(curr.left != null){
                TreeNode temp = curr.left;
                while(temp.right != null)temp = temp.right;
                temp.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right;
        }
    }
    Queue<TreeNode> queue = new LinkedList<>();
    //Takes space O(n)
    public void flattenInEfficiently(TreeNode root) {
        fillQueue(root);
        printQueue(queue);
        TreeNode prev = queue.poll(); // Get first node
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            prev.left = null;
            prev.right = curr;
            prev = curr;
        }
        //Last node's LHS and RHS to be set to null
        if (prev != null) {
            prev.left = null;
            prev.right = null;
        }
    }
    void printQueue(Queue<TreeNode> queue){
        System.out.print("[ ");
        for(TreeNode node: queue){
            System.out.print(node.val + " ");
        }
        System.out.println("]");
    }
    void fillQueue(TreeNode node){
        if(node == null)return;
        queue.offer(node);
        fillQueue(node.left);
        fillQueue(node.right);
    }
}
