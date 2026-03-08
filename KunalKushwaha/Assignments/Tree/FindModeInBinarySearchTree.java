package KunalKushwaha.Assignments.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class FindModeInBinarySearchTree {
	public int[] findMode(TreeNode root) {
		Map<Integer, Integer> map = new HashMap<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		int max = Integer.MIN_VALUE;

		while (!queue.isEmpty()) {
			int n = queue.size();
			for (int i = 0; i < n; i++) {
				TreeNode curr = queue.poll();
				map.put(curr.val, map.getOrDefault(curr.val, 0) + 1);
				max = Math.max(max, map.get(curr.val));
				if (curr.left != null)
					queue.offer(curr.left);
				if (curr.right != null)
					queue.offer(curr.right);
			}
		}

		List<Integer> modes = new ArrayList<>();
		for (Integer key : map.keySet()) {
			if (map.get(key) == max) {
				modes.add(key);
			}
		}

		return modes.stream().mapToInt(Integer::intValue).toArray();
	}
}