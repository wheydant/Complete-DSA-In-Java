package KunalKushwaha.Assignments.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AllNodesDistanceKInBinaryTree {
	public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
		// Find the target and keep on mapping Parent and Child
		// We don't have a way to go back so will create one
		Queue<TreeNode> levelOrder = new LinkedList<>();
		HashMap<TreeNode, TreeNode> parent = new HashMap<>();

		levelOrder.offer(root);

		while (!levelOrder.isEmpty()) {
			int n = levelOrder.size();
			for (int i = 0; i < n; i++) {
				TreeNode curr = levelOrder.poll();
				if (curr.left != null) {
					parent.put(curr.left, curr);
					levelOrder.offer(curr.left);
				}
				if (curr.right != null) {
					parent.put(curr.right, curr);
					levelOrder.offer(curr.right);
				}
			}
		}

		HashMap<TreeNode, Boolean> vis = new HashMap<>();
		levelOrder.offer(target);
		vis.put(target, true);
		int dis = 0;

		while (!levelOrder.isEmpty() && dis < k) {
			int n = levelOrder.size();
			for (int i = 0; i < n; i++) {
				TreeNode curr = levelOrder.poll();
				if (curr.left != null && !vis.containsKey(curr.left)) {
					levelOrder.offer(curr.left);
					vis.put(curr.left, true);
				}
				if (curr.right != null && !vis.containsKey(curr.right)) {
					levelOrder.offer(curr.right);
					vis.put(curr.right, true);
				}
				TreeNode currParent = parent.get(curr);
				if (currParent != null && !vis.containsKey(currParent)) {
					levelOrder.offer(currParent);
					vis.put(currParent, true);
				}
			}
			dis++;
		}

		List<Integer> ans = new ArrayList<>();

		int n = levelOrder.size();
		for (int i = 0; i < n; i++) {
			ans.add(levelOrder.poll().val);
		}

		return ans;
	}
}
