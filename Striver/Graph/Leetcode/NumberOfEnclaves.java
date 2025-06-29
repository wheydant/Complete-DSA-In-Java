package Striver.Graph.Leetcode;

public class NumberOfEnclaves {
    private void dfs(int x, int n,int y, int m, int[][] board, boolean[][] vis, int[] del){
        vis[x][y] = true;
        for(int i = 0; i < 4; i++){
            int nRow = x + del[i];
            int nCol = y + del[i + 1];

            if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m){
                if(board[nRow][nCol] == 1 && !vis[nRow][nCol]){
                    dfs(nRow, n, nCol, m, board, vis, del);
                }
            }
        }
    }
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];

        int[] del = {1, 0, -1, 0, 1};

        //Beginging Row Border
        for(int i = 0; i < n; i++){
            if(grid[i][0] == 1 && !vis[i][0]){
                dfs(i, n, 0, m, grid, vis, del);
            }
        }
        //End row border
        for(int i = 0; i < n; i++){
            if(grid[i][m - 1] == 1 && !vis[i][m - 1]){
                dfs(i, n, m - 1, m, grid, vis, del);
            }
        }

        //Top border
        for(int i = 0; i < m; i++){
            if(grid[0][i] == 1 && !vis[0][i]){
                dfs(0, n, i, m, grid, vis, del);
            }
        }

        //Bottom border
        for(int i = 0; i < m; i++){
            if(grid[n - 1][i] == 1 && !vis[n - 1][i]){
                dfs(n - 1, n, i, m, grid, vis, del);
            }
        }

        int noOfEnclaves = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1 && !vis[i][j]){
                    noOfEnclaves++;
                }
            }
        }

        return noOfEnclaves;
    }
}
