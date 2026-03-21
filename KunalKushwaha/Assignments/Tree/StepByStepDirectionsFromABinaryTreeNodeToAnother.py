# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
from typing import Optional


class Solution:
    def getDirections(self, root: Optional[TreeNode], startValue: int, destValue: int) -> str:
        route_start = []
        route_dest = []
        route_start.append([root.val, 'R'])
        route_dest.append([root.val, 'R'])
        def dfs(node, dest, dfs_for):
            if not node:
                return False
            if node.val == dest:
                # print('Found')
                return True
            
            if node.left:
                if dfs_for == 'S':
                    route_start.append([node.left.val, 'L'])
                else:
                    route_dest.append([node.left.val, 'L'])
                if dfs(node.left, dest, dfs_for):
                    return True
                if dfs_for == 'S':
                    route_start.pop()
                else:
                    route_dest.pop()
                
            
            if node.right:
                if dfs_for == 'S':
                    route_start.append([node.right.val, 'R'])
                else:
                    route_dest.append([node.right.val, 'R'])
                if dfs(node.right, dest, dfs_for):
                    return True
                if dfs_for == 'S':
                    route_start.pop()
                else:
                    route_dest.pop()

            return False
        
        dfs(root, startValue, 'S')
        dfs(root, destValue, 'D')

        # print(route_start)
        # print(route_dest)
        lca = root.val
        while route_start and route_dest and route_start[0][0] == route_dest[0][0]:
            route_start.pop(0)
            route_dest.pop(0)
        # print(route_start)
        # print(route_dest)
        route = 'U'*len(route_start)
        # print(route)
        for i in range(len(route_dest)):
            route += route_dest[i][1]
        return route

            
            