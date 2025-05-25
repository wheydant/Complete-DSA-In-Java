package LeetcodeTrees;

public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        invertHelper(root);
        return root;
    }
    void invertHelper(TreeNode node){
        if(node == null)return;
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
        invertHelper(node.left);
        invertHelper(node.right);
    }
}
