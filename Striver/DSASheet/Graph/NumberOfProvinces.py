class Solution:
    def findCircleNum(self, isConnected: List[List[int]]) -> int:
        n = len(isConnected)
        vis = [False]*n

        no_of_provinces = 0

        def dfs(node):
            vis[node] = True
            for i in range(len(isConnected[node])):
                if i == node:
                    continue
                if isConnected[node][i] == 1 and not vis[i]:
                    dfs(i)

        for i in range(n):
            if vis[i]:
                continue
            
            dfs(i)
            no_of_provinces += 1
        
        return no_of_provinces

if __name__ == '__main__':
    print(Solution().findCircleNum([[1,0,0],[0,1,0],[0,0,1]]))