package LeetcodeTrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class BinaryTreeLevelOrderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int levelSize = queue.size();
            List<Integer> currLevel = new ArrayList<>();
            for(int i = 0; i < levelSize; i++){
                TreeNode currentNode = queue.poll();
                currLevel.add(currentNode.val);
                if(currentNode.left != null)queue.offer(currentNode.left);
                if(currentNode.right != null)queue.offer(currentNode.right);
            }
            result.add(currLevel);
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println("Hello Wold");
    }   
}
