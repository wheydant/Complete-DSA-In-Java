package KunalKushwaha.Assignments.Tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {
	void helper(TreeNode root, List<Integer> inOrder) {
		if (root == null)
			return;
		helper(root.left, inOrder);
		inOrder.add(root.val);
		helper(root.right, inOrder);
	}

	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> inOrder = new ArrayList<>();
		helper(root, inOrder);
		return inOrder;
	}

	public static void main(String[] args) {
		System.out.println(new BinaryTreeInorderTraversal().inorderTraversal(
				new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5, new TreeNode(6), new TreeNode(7))),
						new TreeNode(3, null, new TreeNode(8, new TreeNode(9), null)))));
	}
}
