# Definition for a binary tree node.
from collections import defaultdict
from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Brute:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> int:
        self.total = 0
        def helper(node, cur):
            if not node:
                return
            helper(node.left, cur + node.val)
            helper(node.right, cur + node.val)
            if cur + node.val == targetSum:
                self.total += 1
        
        def dfs(node):
            if not node:
                return
            helper(node, 0)
            dfs(node.left)
            dfs(node.right)
        
        dfs(root)

        return self.total
class Optimal:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> int:
        self.total = 0
        self.lookup = defaultdict(int)
        # Path 0 exists
        self.lookup[0] = 1
        def dfs(node, root_sum):
            if not node:
                return
            root_sum += node.val

            #Check is in this tree the remaining part exists
            self.total += self.lookup[root_sum - targetSum]

            self.lookup[root_sum] += 1
            dfs(node.left, root_sum)
            dfs(node.right, root_sum)
            
            #Backtrack as rest of the root to leaf path must not be affected
            self.lookup[root_sum] -= 1
        
        dfs(root, 0)

        return self.total