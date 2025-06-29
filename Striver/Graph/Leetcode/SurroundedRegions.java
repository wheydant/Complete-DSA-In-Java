package Striver.Graph.Leetcode;

public class SurroundedRegions {
    private void dfs(int x, int n,int y, int m, char[][] board, boolean[][] vis, int[] del){
        vis[x][y] = true;
        for(int i = 0; i < 4; i++){
            int nRow = x + del[i];
            int nCol = y + del[i + 1];

            if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m){
                if(board[nRow][nCol] == 'O' && !vis[nRow][nCol]){
                    dfs(nRow, n, nCol, m, board, vis, del);
                }
            }
        }
    }
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        boolean[][] vis = new boolean[n][m];

        int[] del = {1, 0, -1, 0, 1};

        //Beginging Row Border
        for(int i = 0; i < n; i++){
            if(board[i][0] == 'O' && !vis[i][0]){
                dfs(i, n, 0, m, board, vis, del);
            }
        }
        //End row border
        for(int i = 0; i < n; i++){
            if(board[i][m - 1] == 'O' && !vis[i][m - 1]){
                dfs(i, n, m - 1, m, board, vis, del);
            }
        }

        //Top border
        for(int i = 0; i < m; i++){
            if(board[0][i] == 'O' && !vis[0][i]){
                dfs(0, n, i, m, board, vis, del);
            }
        }

        //Bottom border
        for(int i = 0; i < m; i++){
            if(board[n - 1][i] == 'O' && !vis[n - 1][i]){
                dfs(n - 1, n, i, m, board, vis, del);
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == 'O' && !vis[i][j]){
                    board[i][j] = 'X';
                }
            }
        }
    }
}
