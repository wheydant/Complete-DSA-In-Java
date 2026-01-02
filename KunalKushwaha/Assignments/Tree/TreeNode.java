package KunalKushwaha.Assignments.Tree;

public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;

	public TreeNode() {
	}

	public TreeNode(int val) {
		this.val = val;
	}

	public TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}

	static void inOrder(TreeNode root){
		if(root == null) return;
		inOrder(root.left);
		System.out.print(root.val + " ");
		inOrder(root.right);
	}
}