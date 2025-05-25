package LeetcodeTrees;

public class KthSmallestElementInABST {
    int smallest = 0;
    int kSmall = -1;
    boolean flag = false;
    public int kthSmallest(TreeNode root, int k) {
        helper(root, k);
        return kSmall;
    }
    //Inorder traversal.
    void helper(TreeNode node, int k){
        if(node == null){
            return;
        }
        if(node.left == null && !flag){
            flag = true;
            smallest++;
            System.out.println(node.val);
        }
        helper(node.left, k);
        if(k == smallest){
            kSmall = node.val;
        }
        if(flag)smallest++;
        helper(node.right, k);
    }

    public int kthSmallestEfficient(TreeNode root, int k) {
        return helperEfficient(root, k).val;
    }
    int count = 0;
    TreeNode helperEfficient(TreeNode node, int k){
        if(node == null)return null;

        TreeNode left = helperEfficient(node.left, k);

        if(left != null)return left;

        count++;
        
        if(count == k)return node;

        return helperEfficient(node.right, k);
    }
}
