# Definition for a binary tree node.
from typing import List, Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
        
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class IntuitiveSolution:
    def treeQueries(self, root: Optional[TreeNode], queries: List[int]) -> List[int]:
        level_map = {}
        node_map = {} # level, height
        def dfs(node, level):
            if not node:
                return -1
            curr_level = level_map.get(level, [])
            curr_level.append(node.val)
            level_map[level] = curr_level

            left_height = 1 + dfs(node.left, level + 1)
            right_height = 1 + dfs(node.right, level + 1)

            curr_height = max(left_height, right_height)
            node_map[node.val] = [level, curr_height]

            return curr_height
        dfs(root, 0)
        
        height_queries = []

        for q in queries:
            level, height = node_map[q]
            level_node = level_map[level]
            max_height = -1
            for node in level_node:
                if node == q:
                    continue
                max_height = max(max_height, node_map[node][1])
            if max_height == -1:
                #Single node in that level 
                height_queries.append(level - 1)
            else:
                height_queries.append(max_height + level)
        return height_queries

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class OptimizedIntuitiveSolution:
    def treeQueries(self, root: Optional[TreeNode], queries: List[int]) -> List[int]:
        level_map = {} # Optimized store only max1, max2
        node_map = {} # level, height
        def dfs(node, level):
            if not node:
                return -1

            left_height = 1 + dfs(node.left, level + 1)
            right_height = 1 + dfs(node.right, level + 1)

            curr_height = max(left_height, right_height)

            if level not in level_map:
                level_map[level] = [curr_height, -1]
            else:
                max1, max2 = level_map[level]
                if curr_height > max1:
                    level_map[level] = [curr_height, max1]
                elif curr_height > max2:
                    level_map[level] = [max1 ,curr_height]

            
            node_map[node.val] = [level, curr_height]

            return curr_height
        dfs(root, 0)
        
        height_queries = []

        for q in queries:
            level, height = node_map[q]
            max1, max2 = level_map[level]
            max_height = -1
            if height == max1:
                max_height = max2
            else:
                max_height = max1
            if max_height == -1:
                #Single node in that level 
                height_queries.append(level - 1)
            else:
                height_queries.append(max_height + level)
        return height_queries
class Solution:
    def treeQueries(self, root: Optional[TreeNode], queries: List[int]) -> List[int]:
        height = {}
        res = {}

        def dfs(node):
            if not node:
                return -1
            left = dfs(node.left)
            right = dfs(node.right)
            height[node.val] = 1 + max(left, right)
            return height[node.val]
        
        dfs(root)

        # Re-rooting DFS
        def dfs2(node, depth, max_height_from_above):
            if not node:
                return
            
            res[node.val] = max_height_from_above

            left_h = height[node.left.val] if node.left else -1
            right_h = height[node.right.val] if node.right else -1

            if node.left:
                # Important step
                # print(f'Printing {node.val} -> {node.left.val if node.left else ''}')
                # print(max_height_from_above)
                # print(depth + 1 + right_h)
                dfs2(node.left, depth + 1, max(max_height_from_above, depth + 1 + right_h))
            
            if node.right:
                # Important step
                # print(f'Printing {node.val} -> {node.right.val if node.right else ''}')
                # print(max_height_from_above)
                # print(depth + 1 + left_h)
                dfs2(node.right, depth + 1, max(max_height_from_above, depth + 1 + left_h))
        
        dfs2(root, 0, 0)

        return [res[q] for q in queries]