class Solution:
    def mostProfitablePath(self, edges: List[List[int]], bob: int, amount: List[int]) -> int:
        n = len(amount)

        # build graph
        graph = defaultdict(list)
        for u,v in edges:
            graph[u].append(v)
            graph[v].append(u)

        parents = [-1]*n
        print(parents)
        
        def dfs_parent(node, par):
            parents[node] = par
            for nei in graph[node]:
                if nei != par:
                    dfs_parent(nei, node)

        dfs_parent(0, -1)
        
        path_bob = {}
        time_stamp = 0
        while bob != -1:
            path_bob[bob] = time_stamp
            time_stamp += 1
            bob = parents[bob]
        path_bob[bob] = time_stamp

        time_stamp = 0
        # DFS
        def dfs_alice(node, parent, time):
            profit = 0

            if node not in path_bob or time < path_bob[node]:
                profit += amount[node]
            elif time == path_bob[node]:
                profit += amount[node] // 2
            
            best = float('-inf')
            is_leaf = True

            for neighbors in graph[node]:
                if neighbors != parent:
                    is_leaf = False
                    best = max(best, dfs_alice(neighbors, node, time + 1))
            if is_leaf:
                return profit
            
            return profit + best
        return dfs_alice(0, -1, 0)