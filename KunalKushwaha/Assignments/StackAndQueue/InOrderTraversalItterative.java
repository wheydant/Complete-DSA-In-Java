package KunalKushwaha.Assignments.StackAndQueue;

import KunalKushwaha.Assignments.Tree.TreeNode;
import java.util.ArrayList;
import java.util.Stack;

public class InOrderTraversalItterative {
	ArrayList<Integer> inOrder(TreeNode root) {
		// Code
		Stack<TreeNode> st = new Stack<>();
		st.push(root);
		ArrayList<Integer> inOrderList = new ArrayList<>();
		boolean goLeft = true;

		while (!st.isEmpty()) {
			if (st.peek().left != null && goLeft) {
				st.push(st.peek().left);
			} else {
				TreeNode curr = st.pop();
				inOrderList.add(curr.val);
				goLeft = true;
				if (curr.right != null) {
					st.push(curr.right);
				}else{
					goLeft = false;
				}
			}
		}
		return inOrderList;
	}
	public static void main(String[] args) {
		System.out.println(new InOrderTraversalItterative().inOrder(
				new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5, new TreeNode(6), new TreeNode(7))),
						new TreeNode(3, null, new TreeNode(8, new TreeNode(9), null)))));
	}
}
