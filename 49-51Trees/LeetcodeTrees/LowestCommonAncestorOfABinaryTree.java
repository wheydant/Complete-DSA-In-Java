package LeetcodeTrees;

public class LowestCommonAncestorOfABinaryTree {
    TreeNode commonAncestor = null;
    /*
    My Approach - But its flawed
        -  p and q are passed by value (Java uses pass-by-value for object references), so setting p = null or q = null won’t reflect outside the function.
    */
    public TreeNode lowestCommonAncestorWrong(TreeNode root, TreeNode p, TreeNode q) {
        helperCorrect(root, p, q);
        return commonAncestor;
    }
    void helperWrong(TreeNode node, TreeNode p, TreeNode q){
        if(node == null)return;
        if(node == p){
            p = null;
            return;
        }else if(q == node){
            q = null;
            return;
        }
        helperWrong(node.left, p, q);
        helperWrong(node.right, p, q);
        if(p == null && q == null){
            System.out.println(commonAncestor.val);
            commonAncestor = node;
            p = node;
            q = node;
        }
    }
    private boolean helperCorrect(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) return false;

        // Check if p or q is found in the left subtree
        boolean left = helperCorrect(node.left, p, q);
        // Check if p or q is found in the right subtree
        boolean right = helperCorrect(node.right, p, q);
        // Check if current node is p or q, checks and carry forward the check too.
        boolean mid = (node == p || node == q);

        // If any two of the three flags (mid, left, right) are true,
        // this node is the common ancestor
        if ((mid && left) || (mid && right) || (left && right)) {
            commonAncestor = node;
        }

        // Return true if p or q is found in this subtree
        return mid || left || right;
    }

    //Better approach
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root; // This node is the lowest common ancestor
        }

        //If we have found something than its going to be the ancestor - Video 3hr 3min
        return left != null ? left : right;
    }
}
