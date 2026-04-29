from collections import defaultdict
import sys
from typing import List


class Solution:
    def minimumScore(self, nums: List[int], edges: List[List[int]]) -> int:
        '''
        # Story Board
        1. Assume root is 0
        2. n^2 is acceptable time complexity, Thus we will traverse all the node pairs who we can split
        3. Pre Subtree XoR calculation keeps the complexity n^2 (Individual Question on its own XOR of subtree)
        4. Tricky party if the split is amongst Ancestor and Descendant then issue of duplicate XoR values. Follow time based approach to keep track of Ancestor Descendant (Individual Question is Ancestor Descendant)
        '''
        n = len(nums)
        graph = defaultdict(list)

        for u, v in edges:
            graph[u].append(v)
            graph[v].append(u)
        
        subTreeXor = [0]*n
        inTime = [0]*n
        outTime = [0]*n

        self.timer = 0

        def dfs(node, par):
            subTreeXor[node] = nums[node]

            inTime[node] = self.timer
            self.timer += 1

            for nei in graph[node]:
                if nei != par:
                    dfs(nei, node)
                    # After DFS call subTreeXor for its nei will be populated
                    subTreeXor[node] ^= subTreeXor[nei]
                
            outTime[node] = self.timer
            # Timer keeps on incrementing
            self.timer += 1
        
        dfs(0, -1)

        def isAncestor(u, v):
            # Simple check for ancestor
            return inTime[v] >= inTime[u] and outTime[v] <= outTime[u]

        def getScore(xor1, xor2, xor3):
            maxXor = max(xor1, xor2, xor3)
            minXor = min(xor1, xor2, xor3)

            return maxXor - minXor
        
        result = sys.maxsize

        # Traverse from 1 to n as subtree split at 0 is complete tree itself
        for u in range(1, n):
            for v in range(u + 1, n):
                xor1, xor2, xor3 = 0, 0, 0
                if isAncestor(u, v):
                    xor1 = subTreeXor[v]
                    xor2 = subTreeXor[u] ^ subTreeXor[v]
                    xor3 = subTreeXor[0] ^ xor1 ^ xor2
                elif isAncestor(v, u):
                    xor1 = subTreeXor[u]
                    xor2 = subTreeXor[v] ^ subTreeXor[u]
                    xor3 = subTreeXor[0] ^ xor1 ^ xor2
                else:
                    xor1 = subTreeXor[u]
                    xor2 = subTreeXor[v]
                    xor3 = subTreeXor[0] ^ xor1 ^ xor2
                
                result = min(result, getScore(xor1, xor2, xor3))
        
        return result