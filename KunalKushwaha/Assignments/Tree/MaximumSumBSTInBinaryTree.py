# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
import sys
from typing import Optional


class Solution:
    def maxSumBST(self, root: Optional[TreeNode]) -> int:
        self.max_sum = 0
        #Single Negative Leaf can also be a BST but max_sum = 0 i.e. sum of empty BST is zero which is greater than negative leaf
        def dfs(node, range = [-sys.maxsize, sys.maxsize]):
            if not node:
                return True, 0
            
            left_bst, left_sum = False, 0
            right_bst, right_sum = False, 0

            
            if node.left:
                if range[0] < node.left.val < node.val:
                    left_bst, left_sum = dfs(node.left, [range[0], node.val])
                else:
                    dfs(node.left)
            else:
                left_bst = True


            if node.right:
                if range[1] > node.right.val > node.val:
                    right_bst, right_sum = dfs(node.right, [node.val, range[1]])
                else:
                    dfs(node.right)
            else:
                right_bst = True
            
            if right_bst and left_bst:
                cur_sum = (left_sum + right_sum + node.val)
                self.max_sum = max(self.max_sum, cur_sum)
                return True, cur_sum
        
            
            return False, 0
        
        dfs(root)
        return self.max_sum #Breaks for [1,null,10,-5,20]
    
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class OptimizedSolution:
    def maxSumBST(self, root: Optional[TreeNode]) -> int:
        self.max_sum = 0
        #Single Negative Leaf can also be a BST but max_sum = 0 i.e. sum of empty BST is zero which is greater than negative leaf
        def dfs(node):
            if not node:
                return True, sys.maxsize, -sys.maxsize, 0
            
            left_bst, left_min, left_max, left_sum = dfs(node.left)
            right_bst, right_min, right_max, right_sum = dfs(node.right)

            if left_bst and right_bst and left_max < node.val < right_min:
                curr_sum = left_sum +right_sum + node.val
                self.max_sum = max(self.max_sum, curr_sum)

                # Using this condition is the key
                return (
                    True,
                    min(left_min, node.val),
                    max(right_max, node.val),
                    curr_sum
                )
            else:
                return False, 0, 0,0 
        
        dfs(root)
        return self.max_sum