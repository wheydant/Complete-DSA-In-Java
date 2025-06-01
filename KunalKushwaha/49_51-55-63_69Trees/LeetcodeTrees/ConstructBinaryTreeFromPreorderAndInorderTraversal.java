package LeetcodeTrees;

import java.util.Arrays;
import java.util.HashMap;

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
    /*
    Better Solution as it uses Map thus Time complexity O(n) & space O(n). While prev solution had O(n*n) coz of CopyOfRange
    */
    public TreeNode buildTreeHashMap(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < inorder.length; i++)map.put(inorder[i], i);

        int[] index = new int[]{0};
        return helper(preorder, inorder, 0, preorder.length - 1, map, index);
    }

    public TreeNode helper(int[] preorder, int[] inorder, int left, int right, HashMap<Integer, Integer> map, int[] index){
        if(left > right)return null;

        int current = preorder[index[0]];
        index[0]++;
        TreeNode node = new TreeNode(current);

        if(left == right)return node;

        int inorderIndex = map.get(current);

        node.left = helper(preorder, inorder, left, inorderIndex - 1, map, index);
        node.right = helper(preorder, inorder, inorderIndex + 1, right, map, index);

        return node;
    }
}
