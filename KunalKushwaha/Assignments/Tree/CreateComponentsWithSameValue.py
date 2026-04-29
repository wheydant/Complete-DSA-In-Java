from collections import defaultdict
from typing import List


class Solution:
    def componentValue(self, nums: List[int], edges: List[List[int]]) -> int:
        
        n = len(nums)
        graph = defaultdict(list)

        for u, v in edges:
            graph[u].append(v)
            graph[v].append(u)
        
        sum = 0

        # Calculate the sum, Ideally we can divide till sum/nodes if each node has same value
        for i in range(0, n):
            sum += nums[i]
        
        def dfs(node, par, target):
            val = nums[node]

            for nei in graph[node]:
                if nei == par: continue
                val += dfs(nei, node, target)
            
            # If target is achieved pass children can make 0 contribution as it is already a selfsustained subtree
            if val == target:
                return 0
            
            # Current + Children are unable to completely satisfy the request
            return val
        
        result = 0

        # we will try to make all the parts 1 -> n
        for parts in range(1, n + 1):

            # But target can be achieved only when parts are perfect factor of sum
            if(sum % parts != 0):
                continue
            
            # Target is remainder of sum//parts
            if dfs(0, -1, sum // parts) != 0:
                continue
            
            # Edges is parts - 1
            result = max(result, parts - 1)
        
        return result