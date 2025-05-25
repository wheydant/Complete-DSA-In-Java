package LeetcodeTrees;

public class BinaryTreeMaximumPathSum {
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return maxSum;
    }

    int helper(TreeNode node){
        if(node == null)return 0;
        int left = helper(node.left);
        int right = helper(node.right);

        left = Math.max(0, left);
        right = Math.max(0, right);
        int currMax = left + right + node.val;

        maxSum = Math.max(maxSum, currMax);

        return Math.max(left, right) + node.val;
    }
}
