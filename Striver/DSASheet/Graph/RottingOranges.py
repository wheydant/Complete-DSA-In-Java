'''
1. 0 empty cell
2. 1 fresh 
2. rotten orange
'''
class Solution():
    def min_to_rot_mango(self, grid):
        row, col = len(grid), len(grid[0])
        
        vis = [[False for _ in range(col)] for _ in range(row)]
        print(vis)
        
        self.min_time = 0
        def dfs(i, j, row, col, grid):
            vis[i][j] = True
            traversed = False
            de = [-1, 0, 1, 0, -1]
            for d in range(len(de) - 1):
                di = i + de[d]
                dj = j + de[d + 1]
                if 0 <= di < row and 0 <= dj < col and grid[di][dj] == 1 and not vis[di][dj]:
                    traversed = True
                    dfs(di, dj, row, col, grid)
            
            if traversed:
                self.min_time += 1
        
        for i in range(row):
            for j in range(col):
                if grid[i][j] == 2 and not vis[i][j]:
                    dfs(i, j, row, col, grid)
        
        for i in range(row):
            for j in range(col):
                if grid[i][j] == 1 and not vis[i][j]:
                    return -1

        return self.min_time

if __name__ == '__main__':
    print(Solution().min_to_rot_mango([[2,1,1], [1,1,0], [0,1,1]]))
    print(Solution().min_to_rot_mango([[2,1,1], [0,1,1], [1,0,1]]))
    print(Solution().min_to_rot_mango([[1,0,2], [0,2,1], [1,0,1]]))