package LeetcodeTrees;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {
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
    public boolean isSymmetricKK(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);

        while(!queue.isEmpty()){
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();

            if(left == null && right == null){
                continue;
            }else if(left == null || right == null){
                return false;
            }else if(left.val != right.val){
                return false;
            }

            queue.add(left.left);
            queue.add(right.right);
            queue.add(left.right);
            queue.add(right.left);
        }
        return true;
    }
    public boolean isSymmetricRec(TreeNode root) {
        return isMirror(root.left, root.right);
    }
    
    private boolean isMirror(TreeNode n1, TreeNode n2) {
        if (n1 == null && n2 == null) {
            return true;
        }
        
        if (n1 == null || n2 == null) {
            return false;
        }
        
        return n1.val == n2.val && isMirror(n1.left, n2.right) && isMirror(n1.right, n2.left);
    }
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int levelLen = queue.size();
            int[] treeVals = new int[levelLen];
            for(int i = 0; i < levelLen; i++){
                TreeNode node = queue.poll();
                if(node == null)treeVals[i] = 101;
                else{
                    treeVals[i] = node.val;
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
            }
            for(int i = 0; i < levelLen; i++){
                if(treeVals[i] != treeVals[levelLen - i - 1])return false;
            }
        }
        return true;
    }
}
