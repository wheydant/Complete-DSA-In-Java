#!/usr/bin/env python3
"""
Longest Univalue Path (LeetCode 687)

Given the root of a binary tree, return the length (in edges) of the longest
path where every node in the path has the same value.
"""

from typing import Optional


class TreeNode:
    """Binary‑tree node."""
    def __init__(self, val: int = 0,
                 left: Optional["TreeNode"] = None,
                 right: Optional["TreeNode"] = None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    """Computes the longest univalue path."""
    def __init__(self):
        # longest length (in edges) found so far
        self.max_len: int = 0

    def longestUnivaluePath(self, root: Optional[TreeNode]) -> int:
        def dfs(node: Optional[TreeNode]) -> int:
            if node is None:
                return 0

            left_len  = dfs(node.left)
            right_len = dfs(node.right)

            left_extend = right_extend = 0

            if node.left and node.left.val == node.val:
                left_extend = left_len + 1
            if node.right and node.right.val == node.val:
                right_extend = right_len + 1

            self.max_len = max(self.max_len, left_extend + right_extend)

            # return the longest single‑side extension for the parent
            return max(left_extend, right_extend)

        dfs(root)                # fills self.max_len
        return self.max_len


# ------------------------------------------------------------
# Simple demonstration (the same tree from the original snippet)
# ------------------------------------------------------------
if __name__ == '__main__':
    # Tree:
    #        5
    #      /   \
    #     4     5
    #    / \     \
    #   1   1     5
    root = TreeNode(
        5,
        TreeNode(4, TreeNode(1), TreeNode(1)),
        TreeNode(5, None, TreeNode(5))
    )
    print(Solution().longestUnivaluePath(root))   # Expected output: 2