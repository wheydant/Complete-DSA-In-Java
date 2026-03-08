# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
from bisect import bisect_left
from typing import List, Optional


class Solution:
    def closestNodes(self, root: Optional[TreeNode], queries: List[int]) -> List[List[int]]:
        def inorder(node):
            if not node:
                return []
            return inorder(node.left) + [node.val] + inorder(node.right)

        arr = inorder(root)
        n = len(arr)
        ans = []

        for q in queries:
            idx = bisect_left(arr, q)

            # If exact value exists
            if idx < n and arr[idx] == q:
                ans.append([q, q])
            else:
                mini = arr[idx - 1] if idx > 0 else -1
                maxi = arr[idx] if idx < n else -1
                ans.append([mini, maxi])

        return ans
        