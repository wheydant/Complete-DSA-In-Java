# Definition for a binary tree node.
import sys
from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def maxPathSum(self, root: Optional[TreeNode]) -> int:
        self.maxSum = -sys.maxsize
        def dfs(node):
            if not node:
                return 0
            
            # If its negative then better to avoid 
            left_val = max(dfs(node.left), 0)
            right_val = max(dfs(node.right), 0)

            # Max Sum passing through this node
            curr_val = left_val + right_val + node.val
            self.maxSum = max(self.maxSum, curr_val)

            # Max sum from this node
            return max(left_val, right_val) + node.val
        
        dfs(root)
        return self.maxSum