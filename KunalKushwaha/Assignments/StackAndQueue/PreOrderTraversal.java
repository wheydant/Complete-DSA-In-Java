package KunalKushwaha.Assignments.StackAndQueue;

import java.util.ArrayList;
import java.util.Stack;

import KunalKushwaha.Assignments.Tree.TreeNode;

public class PreOrderTraversal {
    ArrayList<Integer> preOrder(TreeNode root) {
        // Code
		Stack<TreeNode> st = new Stack<>();
		st.push(root);
		ArrayList<Integer> inOrderList = new ArrayList<>();

		while (!st.isEmpty()) {
		    TreeNode curr = st.pop();
		    if(curr.right != null) st.push(curr.right);
		    if(curr.left != null) st.push(curr.left);
		    inOrderList.add(curr.val);
		}
		return inOrderList;
    }
}
