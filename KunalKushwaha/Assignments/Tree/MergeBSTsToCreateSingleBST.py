# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
from typing import List, Optional


class Solution:
    def canMerge(self, trees: List[TreeNode]) -> Optional[TreeNode]:
        # Root of new BST should not be Part of any tree.
        # If there are multiple roots who satisfy this condition this means that tree's cannot merge
        # Leaf nodes cannot have same values
        leaves = set()
        treeDict = {}
        for tree in trees:
            # Makes it easy to fetch all the trees
            treeDict[tree.val] = tree
            # This works because max length of subtrees is 3
            if tree.left:
                leaves.add(tree.left.val)
            
            if tree.right:
                leaves.add(tree.right.val)
            
        root = None

        for tree in trees:
            # Global root shouldn't be leaf
            if tree.val not in leaves:
                root = tree
                break
        
        if not root:
            return None
        
        curLeaves = {}

        if root.left:
            # low, hight, parent node, left/right -> 0/1
            curLeaves[root.left.val] = (-sys.maxsize, root.val, root, 0)
        if root.right:
            curLeaves[root.right.val] = (root.val, sys.maxsize, root, 1)
        # Delete Root from treeDict
        del treeDict[root.val]

        while treeDict:
            findTree = False
            # Fetch all the keys and value
            for leaf, (low, high, par, left_right) in curLeaves.items():
                if leaf in treeDict:
                    newTree = treeDict[leaf]
                    del curLeaves[leaf]

                    if newTree.left:
                        # Leaf must fall in the range and must not be another leaf 
                        if low < newTree.left.val < high and newTree.left.val not in curLeaves:
                            curLeaves[newTree.left.val] = (low, newTree.val, newTree, 0)
                        else:
                            return None
                    
                    if newTree.right:
                        if low < newTree.right.val < high and newTree.right.val not in curLeaves:
                            curLeaves[newTree.right.val] = (newTree.val, high, newTree, 1)
                        else:
                            return None

                    # Update parent node
                    if left_right == 0:
                        par.left = newTree
                    else:
                        par.right = newTree
                    
                    findTree = True

                    del treeDict[newTree.val]
                    break
            
            if not findTree:
                return None
        
        return root

        