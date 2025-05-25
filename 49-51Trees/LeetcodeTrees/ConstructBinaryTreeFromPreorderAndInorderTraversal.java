package LeetcodeTrees;

import java.util.Arrays;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0)return null;

        int root = preorder[0];
        int index = -1;

        for(int i = 0 ; i < inorder.length; i++){
            if(inorder[i] == root){
                index = i;
            }
        }

        TreeNode node = new TreeNode(root);

        /* 
        copyOfRange acts like beginning is inclusive and ending is exclusive. 
        preorder - 0th is root so we exclude it and pass the rest array till index + 1 coz it will have all the left elements till that pont only.

        inorder - index is the root thus we don't add it init and starting from 0. As all are left elements.
        */

        //This is inefficient as copyOfRange creates new array each time using lot of space.
        node.left = buildTree(Arrays.copyOfRange(preorder, 1, index + 1), Arrays.copyOfRange(inorder, 0, index));

        node.right = buildTree(Arrays.copyOfRange(preorder, index + 1, preorder.length), Arrays.copyOfRange(inorder, index + 1, inorder.length));

        return node;
    }
}
