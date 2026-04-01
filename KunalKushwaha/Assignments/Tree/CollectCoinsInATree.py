import collections
import sys
from typing import List

# greedy + topological pruning approach.
class SolutionOptimized:
    def collectTheCoins(self, coins: List[int], edges: List[List[int]]) -> int:
        n = len(coins)

        graph = collections.defaultdict(list)
        degree = [0] * n

        for u, v in edges:
            graph[u].append(v)
            graph[v].append(u)
            degree[u] += 1
            degree[v] += 1

        # 1️⃣ Remove leaf nodes with no coins
        q = collections.deque()

        for i in range(n):
            if degree[i] == 1 and coins[i] == 0:
                q.append(i)

        while q:
            node = q.popleft()
            degree[node] -= 1

            for nei in graph[node]:
                if degree[nei] > 0:
                    degree[nei] -= 1
                    if degree[nei] == 1 and coins[nei] == 0:
                        q.append(nei)

        # 2️⃣ Remove 2 layers of leaves
        q = collections.deque()

        for i in range(n):
            if degree[i] == 1:
                q.append(i)

        steps = 2
        while q and steps > 0:
            size = len(q)
            for _ in range(size):
                node = q.popleft()
                degree[node] -= 1

                for nei in graph[node]:
                    if degree[nei] > 0:
                        degree[nei] -= 1
                        if degree[nei] == 1:
                            q.append(nei)
            steps -= 1

        # 3️⃣ Count remaining edges
        remaining_edges = 0
        for u, v in edges:
            if degree[u] > 0 and degree[v] > 0:
                remaining_edges += 1

        return remaining_edges * 2

# In and Out With Re-rooting
class Solution:
    def collectTheCoins(self, coins: List[int], edges: List[List[int]]) -> int:
        tree = collections.defaultdict(list)
        for u,v in edges:
            tree[u].append(v)
            tree[v].append(u)
        
        vis_coin_map = {}
        def dfs(node, par):
            curr_coin_list = [0]*4
            curr_vis = 0
            if coins[node]:
                curr_coin_list[0] = 1
            
            nei = tree[node]
            for n in nei:
                if n != par:
                    dfs(n, node)
            for n in nei:
                if n != par:
                    n_vis ,n_list = vis_coin_map[n]
                    for i in range(3):
                        curr_coin_list[i + 1] += n_list[i]
                    curr_coin_list[-1] += n_list[-1]
                    if n_vis or n_list[2] + n_list[3] > 0:
                        curr_vis += 2 + n_vis

            vis_coin_map[node] = [curr_vis, curr_coin_list]
            
        # print(tree)
        dfs(0, -1)
        #Re-rooting BFS
        # print(vis_coin_map)
        
        # BFS re-rooting
        q = collections.deque()
        q.append((0, -1, 0, [0,0,0,0])) #node, parent, parent_vis, parent_coin
        
        min_vis = vis_coin_map[0][0]
        
        while q:
            node, parent, p_vis, p_coin = q.popleft()
            
            cur_vis, cur_coin = vis_coin_map[node]
            cur_coin = cur_coin[:] #Fetch copu
            
            # include parent contribution
            if parent != -1:
                if p_vis or (p_coin[2] + p_coin[3] > 0):
                    cur_vis += p_vis + 2

                for i in range(3):
                    cur_coin[i + 1] += p_coin[i]
                
                cur_coin[3] += p_coin[3]
                
            min_vis = min(min_vis, cur_vis)
            
            for nei in tree[node]:
                if nei == parent:
                    continue
                
                # remove child contribution
                n_vis, n_coin = vis_coin_map[nei]
                
                next_vis = cur_vis
                next_coin = cur_coin[:]
                
                if n_vis or (n_coin[2] + n_coin[3] > 0):
                    next_vis -= (n_vis + 2)
                
                for i in range(3):
                    next_coin[i + 1] -= n_coin[i]
                next_coin[3] -= n_coin[3]
                
                q.append((nei, node, next_vis, next_coin))
        return min_vis

if __name__ == '__main__':
    # print(Solution().collectTheCoins([1,0,0,0,0,1], [[0,1],[1,2],[2,3],[3,4],[4,5]]))
    # print(Solution().collectTheCoins([0,0,0,1,1,0,0,1], [[0,1],[0,2],[1,3],[1,4],[2,5],[5,6],[5,7]]))
    print(Solution().collectTheCoins([1,0,1,0,1,0,1,0,1,0,1,0,1,1], [[0,1],[0,2],[1,3],[1,4],[3,6],[3,7],[3,8],[2,5],[5,9],[5,10],[5,11],[10,12],[10,13]]))