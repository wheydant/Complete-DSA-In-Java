package LeetcodeTrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevelsInBinaryTree {
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
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Double> avgOfLevels = new ArrayList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int levelLen = queue.size();
            double sum = 0;
            for(int i = 0; i < levelLen; i++){
                TreeNode node = queue.poll();
                sum += node.val;
                if(node.left != null)queue.offer(node.left);
                if(node.right != null)queue.offer(node.right);
            }
            double levelAvg = sum/levelLen;
            avgOfLevels.add(levelAvg);
        }
        return avgOfLevels;
    }
}
