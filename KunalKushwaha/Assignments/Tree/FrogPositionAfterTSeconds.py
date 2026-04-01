import collections
from typing import List


class Solution:
    def frogPosition(self, n: int, edges: List[List[int]], t: int, target: int) -> float:
        graph = collections.defaultdict(list)
        for u,v in edges:
            graph[u].append(v)
            graph[v].append(u)
        
        def dfs(node, parent, time, prob):
            # Count Childrens
            children = [nei for nei in graph[node] if nei != parent]
            # if target reached
            if node == target:
                # Valid only if
                # 1. Time exactly used or
                # 2. Leaf node
                if time == t or len(children) == 0:
                    return prob
                return 0
            
            # if time exceeded
            if time == t:
                return 0
            
            # if no children stuck
            if len(children) == 0:
                return 0

            next_prob = prob / len(children)

            for nei in children:
                res = dfs(nei, node, time + 1, next_prob)
                # Whenever a path is found
                if res > 0:
                    return res
            
            return 0
        
        return dfs(1, -1, 0, 1.0)
    
if __name__ == '__main__':
    print(Solution().frogPosition(3, [[2,1],[3,2]], 1, 2))

