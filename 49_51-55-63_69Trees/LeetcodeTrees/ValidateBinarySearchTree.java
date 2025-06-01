package LeetcodeTrees;

public class ValidateBinarySearchTree {
    TreeNode prev = null;
    public boolean isValidBST(TreeNode root) {
        return (isBST(root))? isBST(root): helper(root, null, null);
    }
    //This uses In-Order
    boolean isBST(TreeNode node){
        if (node == null) return true;
        //Move to extreme left
        if (!isBST(node.left)) return false;
        //Give a pass to extreme left node
        if (prev != null && node.val <= prev.val) return false;
        //Add the prev to curr after extreme left node
        prev = node;
        //Check right
        return isBST(node.right);
    }
    //This uses pre-Order
    public boolean helper(TreeNode node, Integer low, Integer high){
        if(node == null)return true;
        //You can use null for wrapper but not int.
        if(low != null && node.val <= low)return false;
        if(high != null && node.val >= high)return false;

        boolean leftTree = helper(node, node.val, high);
        boolean rightTree = helper(node, low, node.val);

        return leftTree && rightTree;
    }

}
