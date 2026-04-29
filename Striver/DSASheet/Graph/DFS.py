import collections


class Solution:
    def printDFS(self, V, adj):
        vis = [False]*(V + 1)
        dfs_path = []
        
        def dfs(node):
            dfs_path.append(node)
            vis[node] = True
            
            for a in adj[node - 1]:
                if not vis[a]:
                    dfs(a)
        dfs(1)
        
        return dfs_path

if __name__ == '__main__':
    print(Solution().printDFS(5, [[2,3], [1,4,5], [1], [2,5], [4,5]]))