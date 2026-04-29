from collections import defaultdict
from typing import List


class Solution:
    def smallestMissingValueSubtree(self, parents: List[int], nums: List[int]) -> List[int]:
        #Distinct values so just the ancestor of node having 1 will have challenging values. Min Heap to fetch the next smallest
        def dfs(node):
            if visited[nums[node]]:
                return
            visited[nums[node]] = True
            for child in tree[node]:
                dfs(child)
            
        n = len(nums)
        # If there is no 1 return 1 for all
        if 1 not in nums:
            return [1]*n
        
        tree = defaultdict(list)
        for i, p in enumerate(parents):
            tree[p].append(i)
        
        curNode = nums.index(1)

        # 1 based indexing and if 1,2,3,4 are the node then next small is 5 thus +2
        visited = [False]*(max(nums) + 2)
        ans = [1]*n
        curMissing = 1

        while curNode != -1:
            # Mark all the node for subtree below curNode
            dfs(curNode)

            # Find the first missing to be populated for above tree
            while visited[curMissing]:
                curMissing += 1
            
            ans[curNode] = curMissing
            
            # Move Up
            curNode = parents[curNode]
        
        return ans
        