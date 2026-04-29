class Solution:
    def checkWays(self, pairs: list[list[int]]) -> int:
        from collections import defaultdict
        
        g = defaultdict(set)
        for u, v in pairs:
            g[u].add(v)
            g[v].add(u)
        
        nodes = list(g.keys())
        n = len(nodes)
        
        root = -1
        for x in nodes:
            if len(g[x]) == n - 1:
                root = x
                break
        
        if root == -1:
            return 0
        
        res = 1
        
        for x in nodes:
            if x == root:
                continue
            
            parent = -1
            parent_deg = float('inf')
            
            for y in g[x]:
                if len(g[y]) >= len(g[x]) and len(g[y]) < parent_deg:
                    parent = y
                    parent_deg = len(g[y])
            
            if parent == -1:
                return 0
            
            for y in g[x]:
                if y == parent:
                    continue
                if y not in g[parent]:
                    return 0
            
            if parent_deg == len(g[x]):
                res = 2
        
        return res