import collections


class Solution:
    def findNoOfGraphs(self, V, edges):
        graph = collections.defaultdict(list)
        for u, v in edges:
            graph[u].append(v)
            graph[v].append(u)
        
        self.vis = [False]*V
        
        def bfs(node):
            self.vis[node] = True
            
            for nei in graph[node]:
                if self.vis[nei]:
                    continue
                
                bfs(nei)
        
        no_of_graphs = 0
        for i in range(V):
            if self.vis[i]:
                continue
            no_of_graphs += 1
            bfs(i)
        
        return no_of_graphs

if __name__ == '__main__':
    print(Solution().findNoOfGraphs(7, [[0, 1], [1, 2], [2, 3], [4, 5]]))