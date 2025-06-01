package LeetcodeTrees;

public class ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        return insertSorted(nums, 0, nums.length - 1);
    }

    TreeNode insertSorted(int[] nums, int start, int end){
        if(start > end)return null;

        int mid = start + (end - start)/2;
        TreeNode node = new TreeNode(nums[mid]);

        node.left = insertSorted(nums, start, mid - 1);
        node.right = insertSorted(nums, mid + 1, end);

        return node;
    }
}
