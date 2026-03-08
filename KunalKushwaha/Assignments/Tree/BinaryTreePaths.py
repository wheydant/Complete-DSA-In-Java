# Definition for a binary tree node.
from typing import List, Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def binaryTreePaths(self, root: Optional[TreeNode]) -> List[str]:
        root_to_leaf = []
        def dfs(node, curr_str):
            if not node:
                return ""
            if not node.left and not node.right:
                root_to_leaf.append(curr_str + str(node.val))
            dfs(node.left, curr_str + str(node.val) + "->")
            dfs(node.right, curr_str + str(node.val) + "->")
        dfs(root, "")
        return root_to_leaf
    
if __name__ == '__main__':
    print(Solution().binaryTreePaths(TreeNode(1, TreeNode(2), TreeNode(3, None, TreeNode(4)))))