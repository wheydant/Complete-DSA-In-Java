package Striver.DynamicProgramming.LeetCode;

import java.util.Arrays;

public class MinimumPathSum{
    //Why not greedy is explained nicely, greedy works in uniformity, but where current decision effects future greedy mostly fails.
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        for (int[] row : dp) Arrays.fill(row, -1);
        // return helper(n - 1, m - 1, grid);
        // return helperMem(n - 1, m - 1, grid, dp);
        // return helperTab(n, m, grid);
        return helperSO(grid);
    }
    int helperINTMAX(int x, int y, int[][] grid){
        if (x == 0 && y == 0) return grid[0][0];
        if (x < 0 || y < 0) return Integer.MAX_VALUE;

        int up = helperINTMAX(x - 1, y, grid);
        int left = helperINTMAX(x, y - 1, grid);

        return grid[x][y] + Math.min(up, left);
    }
    int helper(int x, int y, int[][] grid){
        if(x == 0 && y == 0) return grid[x][y];

        //If we are passing Integer.MAX_VALUE, then it fails thus return 1e9
        if(x < 0 || y < 0) return (int) Math.pow(10, 9);

        //MAX VALUE coming here and adding with grid makes the value negative coz of bit overflow making the number negative 
        int up = grid[x][y] + helper(x - 1, y, grid);

        int left = grid[x][y] + helper(x, y - 1, grid);

        return  Math.min(up, left);
    }
    int helperMem(int x, int y, int[][] grid, int[][] dp){
        if(x == 0 && y == 0) return grid[x][y];

        if(x < 0 || y < 0) return (int) Math.pow(10, 9);

        if(dp[x][y] != -1) return dp[x][y];

        int up = grid[x][y] + helperMem(x - 1, y, grid, dp);

        int left = grid[x][y] + helperMem(x, y - 1, grid, dp);

        return dp[x][y] = Math.min(up, left);
    }
    int helperTab(int x, int y, int[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(i == 0 && j == 0){
                    dp[i][j] = grid[i][j];
                    continue;
                }

                int up = (int) Math.pow(10, 9);
                int left = (int) Math.pow(10, 9);

                if(i > 0) up = grid[i][j] + dp[i - 1][j];
                if(j > 0) left = grid[i][j] + dp[i][j - 1];

                dp[i][j] = Math.min(up, left);
            }
        }

        return dp[n - 1][m - 1];
    }
    int helperSO(int[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        int[] prev = new int[n];

        for(int i = 0; i < n; i++){
            int[] curr = new int[n];
            for(int j = 0; j < m; j++){
                if(i == 0 && j == 0){
                    curr[i] = grid[i][j];
                    continue;
                }

                int up = (int) Math.pow(10, 9);
                int left = (int) Math.pow(10, 9);

                if(i > 0) up = grid[i][j] + prev[i - 1];
                if(j > 0) left = grid[i][j] + curr[j - 1];

                curr[j] = Math.min(up, left);
            }
            prev = curr;
        }

        return prev[n - 1];
    }
}