package LeetcodeTrees;

import java.util.LinkedList;
import java.util.Queue;

public class CousinsInBinaryTree {
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

    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) return false;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            TreeNode xParent = null;
            TreeNode yParent = null;
        
            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();
            
                if (current.left != null) {
                    if (current.left.val == x) xParent = current;
                    if (current.left.val == y) yParent = current;
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    if (current.right.val == x) xParent = current;
                    if (current.right.val == y) yParent = current;
                    queue.offer(current.right);
                }
            }
        
            if (xParent != null && yParent != null) {
                return xParent != yParent;
            }
            if ((xParent != null) || (yParent != null)) {
                return false;
            }
        }
    
        return false;
    }
}
