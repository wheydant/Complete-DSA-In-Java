public class TwoSwappedNode {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    TreeNode first;
    TreeNode second;
    TreeNode prev;

    public void helper(TreeNode root){
        inOrder(root);

        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void inOrder(TreeNode node){
        if(node == null)return;

        inOrder(node.left);
        if(prev != null && prev.val > node.val){
            if(first == null){
                first = prev;
            }
            second = node;
        }

        prev = node;

        inOrder(node.right);
    }
}
