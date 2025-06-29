package Striver.Graph;

import java.util.ArrayList;
import java.util.HashSet;

public class NumberOfDistinctIsland {
    //https://www.youtube.com/watch?v=7zmgQSJghpo&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=16&ab_channel=takeUforward
    //Nice Question
    private static void dfs(int row, int col, boolean[][] vis, int[][] grid, ArrayList<String> vec, int row0, int col0){
        vis[row][col] = true;
        vec.add(toString(row - row0, col - col0));
        int n = grid.length;
        int m = grid[0].length;
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, -1, 0, 1};
        for(int i = 0; i < 4; i++){
            int nRow = row + delRow[i];
            int nCol = col + delCol[i];
            if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m){
                if(!vis[nRow][nCol] && grid[nRow][nCol] == 1){
                    dfs(nRow, nCol, vis, grid, vec, row0, col0);
                }
            }
        }
    }
    static String toString(int r, int c){
        return Integer.toString(r)+ " " + Integer.toString(c);
    }
    static int NoOfDistinctIsland(int[][] grid){
        int n = grid.length;
        int m = grid[0].length;

        boolean vis[][] = new boolean[n][m];
        HashSet<ArrayList<String>> st = new HashSet<>();
        for(int i = 0; i < n ; i++){
            for(int j = 0; j < m; j++){
                if(!vis[i][j] && grid[i][j] == 1){
                    ArrayList<String> vec = new ArrayList<>();
                    dfs(i, j , vis, grid, vec, i, j);
                    st.add(vec);
                }
            }
        }
        return st.size();
    }
    public static void main(String[] args) {
        int[][] islands = {
            {1, 1, 0, 1, 1},
            {1, 0, 0, 0, 0},
            {0, 0, 0, 1, 1},
            {1, 1, 0, 1, 0}
        };
        System.out.println(NoOfDistinctIsland(islands));
    }
}
