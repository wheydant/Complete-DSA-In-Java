package LeetcodeTrees;

import java.util.PriorityQueue;

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

    public int kthSmallestUsingHeap(TreeNode root, int k){
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        helperUsingHeap(root,k, minHeap);
        for(int i =0; i < k -1; i++){
            minHeap.poll();
        }

        return minHeap.poll();

    }

    private void helperUsingHeap(TreeNode node, int k, PriorityQueue<Integer> minHeap){
        if(node == null)return;

        helperUsingHeap(node.left, k, minHeap);
        minHeap.offer(node.val);
        helperUsingHeap(node.right, k, minHeap);
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

    private int k;
    private int ans;
    public int kthSmallestEasyAndEfficient(TreeNode root, int k){
        this.k = k;
        helper(root);
        return ans;

    }

    private void helper(TreeNode node){
        if(node == null)return;
        //In-order
        helper(node.left);
        k--;
        if(k == 0){
            ans = node.val;
            return;
        }
        helper(node.right);
    }

}
