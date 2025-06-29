package Striver.Graph.Leetcode;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class ZeroOneMatrix {
    //This is also a method to traverse left right
    int[] DIR = new int[]{0, 1, 0, -1, 0};
    public int[][] updateMatrixLC(int[][] mat) {
        int m = mat.length, n = mat[0].length; // The distance of cells is up to (M+N)
        //Get from arrayDeque rather than LinkedList
        Queue<int[]> q = new ArrayDeque<>();
        for (int r = 0; r < m; ++r)
            for (int c = 0; c < n; ++c)
                if (mat[r][c] == 0) q.offer(new int[]{r, c});
                else mat[r][c] = -1; // Marked as not processed yet!

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0], c = curr[1];
            for (int i = 0; i < 4; ++i) {
                int nr = r + DIR[i], nc = c + DIR[i+1];
                if (nr < 0 || nr == m || nc < 0 || nc == n || mat[nr][nc] != -1) continue;
                mat[nr][nc] = mat[r][c] + 1;
                q.offer(new int[]{nr, nc});
            }
        }
        return mat;
    }
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        boolean[][] vis = new boolean[n][m];
        int[][] dist = new int[n][m];
        Queue<int[]> q = new LinkedList<>();

        //Reverse approach
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m ; j++){
                if(mat[i][j] == 0){
                    q.add(new int[]{i, j, 0});
                    vis[i][j] = true;
                }
            }
        }

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, -1, 0, 1};

        while(!q.isEmpty()){
            int[] nodeVals = q.poll();
            int row = nodeVals[0];
            int col = nodeVals[1];
            int steps = nodeVals[2];
            dist[row][col] = steps;
            for(int i = 0; i < 4; i++){
                int nRow = row + delRow[i];
                int nCol = col + delCol[i];

                if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && !vis[nRow][nCol]){
                    vis[nRow][nCol] = true;
                    q.add(new int[]{nRow, nCol, steps + 1});
                }
            }
        }

        return dist;
    }
}
