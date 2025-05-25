package LeetcodeTrees;

//Example of Post Order 1st we checked left then right then did the calculation for root
public class DiameterOfBinaryTree {
    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter - 1;
    }
    int height(TreeNode node){
        if(node == null)return 0;
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        int dia = leftHeight + rightHeight + 1;
        diameter = Math.max(dia, diameter);
        
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
