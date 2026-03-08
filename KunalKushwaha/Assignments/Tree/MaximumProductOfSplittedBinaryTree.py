# Definition for a binary tree node.
from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def maxProduct(self, root: Optional[TreeNode]) -> int:
        self.total = 0
        def dfs(node):
            if not node:
                return
            self.total += node.val
            dfs(node.left)
            dfs(node.right)
        
        dfs(root)
        self.min_diff = self.total
        self.sub_tree_sum = 0
        def ret_dfs(node):
            if not node:
                return 0
            cur_val = node.val + ret_dfs(node.left) + ret_dfs(node.right)
            best_mult = abs(self.total/2 - cur_val)
            if self.min_diff > best_mult:
                self.min_diff = best_mult
                self.sub_tree_sum = cur_val
            
            return cur_val

        ret_dfs(root)
        return ((self.total - self.sub_tree_sum)*(self.sub_tree_sum))%(1000000007)

if __name__ == '__main__':
    print(Solution().maxProduct(TreeNode(1, TreeNode(2, TreeNode(4), TreeNode(5)), TreeNode(3,TreeNode(6)))))