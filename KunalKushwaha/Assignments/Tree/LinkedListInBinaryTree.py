# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
from typing import Optional


class Solution:
    def isSubPath(self, head: Optional[ListNode], root: Optional[TreeNode]) -> bool:
        def match(listNode, treeNode):
            if not listNode:
                return True
            if not treeNode:
                return False
            if listNode.val != treeNode.val:
                return False
            return match(listNode.next, treeNode.left) or match(listNode.next, treeNode.right)

        def dfs(node):
            if not node:
                return False
            if match(head, node):
                return True            
            return dfs(node.left) or dfs(node.right)

        return dfs(root)