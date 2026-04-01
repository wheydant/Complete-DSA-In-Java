from collections import defaultdict
import math
from typing import List


class Solution:
    def getCoprimes(self, nums: List[int], edges: List[List[int]]) -> List[int]:
        n = len(nums)

        tree = defaultdict(list)
        for u, v in edges:
            tree[u].append(v)
            tree[v].append(u)
        
        # Precompute coprimes
        coprime_map = {}
        for i in range(1, 51):
            coprime_map[i] = []
            for j in range(1, 51):
                if math.gcd(i, j) == 1:
                    coprime_map[i].append(j)
        
        res = [-1]*n
        #Stores ancestor as we go down value -> node, depth
        ancestor_map = {}

        def dfs(node, parent, depth):
            val = nums[node]

            best_depth = -1
            best_node = -1
            for c in coprime_map[val]:
                if c in ancestor_map:
                    anc_node, anc_depth = ancestor_map[c]
                    if anc_depth > best_depth:
                        best_depth = anc_depth
                        best_node = anc_node
                
            res[node] = best_node

            # save current state -- Importand as coming back from 3 to 4 we need to store anc till 1 and remove 3
            prev = ancestor_map.get(val)
            ancestor_map[val] = (node, depth)

            #DFS
            for nei in tree[node]:
                if nei != parent:
                    dfs(nei, node, depth + 1)
            
            if prev:
                ancestor_map[val] = prev
            else:
                #Handles Root
                del ancestor_map[val]

        dfs(0, -1, 0)
        return res