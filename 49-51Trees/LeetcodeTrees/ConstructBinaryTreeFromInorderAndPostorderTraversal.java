package LeetcodeTrees;

import java.util.Arrays;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    //Tree cannot be made from preorder and postorder if tree is not full but for full tree
    /* 
    int preIndex = 0;

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return construct(preorder, postorder, 0, postorder.length - 1);
    }

    private TreeNode construct(int[] preorder, int[] postorder, int postStart, int postEnd) {
        TreeNode root = new TreeNode(preorder[preIndex++]);
        if (postStart == postEnd || preIndex >= preorder.length) return root;

        int nextVal = preorder[preIndex];
        int index = postStart;
        while (postorder[index] != nextVal) {
            index++;
        }

        root.left = construct(preorder, postorder, postStart, index);
        root.right = construct(preorder, postorder, index + 1, postEnd - 1);

        return root;
    }
    */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length == 0)return null;
        int root = postorder[postorder.length - 1];

        int index = -1;
        for(int i = 0; i < inorder.length; i++){
            if(inorder[i] == root){
                index = i;
                break;
            }
        }

        TreeNode node = new TreeNode(root);

        node.left = buildTree(Arrays.copyOfRange(inorder, 0, index), Arrays.copyOfRange(postorder, 0, index));
        node.right = buildTree(Arrays.copyOfRange(inorder, index + 1, inorder.length), Arrays.copyOfRange(postorder, index, postorder.length - 1));

        return node;
    }
}
