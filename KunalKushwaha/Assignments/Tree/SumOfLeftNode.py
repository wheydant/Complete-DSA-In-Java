# Definition for a binary tree node.
from collections import deque
from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def sumOfLeftLeavesBFS(self, root: Optional[TreeNode]) -> int:
        bfs_queue = deque()
        left_sum = 0
        bfs_queue.append(root)
        while bfs_queue:
            n = len(bfs_queue)
            for i in range(n):
                node = bfs_queue.popleft()
                if node.left:
                    node_left = node.left
                    if not node_left.left and not node_left.right:
                        left_sum += node_left.val
                    bfs_queue.append(node_left)
                if node.right:
                    bfs_queue.append(node.right)
        return left_sum
    def sumOfLeftLeaves(self, root: Optional[TreeNode]) -> int:
        self.total = 0
        def preorder(node):
            if not node:
                return
            if node.left and not node.left.left and not node.left.right:
                self.total += node.left.val
            
            preorder(node.left)
            preorder(node.right)

        preorder(root)
        return self.total
    