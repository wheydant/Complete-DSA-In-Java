package Striver.DynamicProgramming.LeetCode;

import java.util.Arrays;


public class CherryPickupII {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        // i, j1, j2, grid. i can be common as both robots can move only to the next row choosing any path
        // return helperRec(0, 0, m - 1, grid);
        int[][][] dp = new int[n][m][m];
        for(int[][] twoD: dp){
            for(int[] oneD : twoD) Arrays.fill(oneD, -1);
        }
        // return helperMem(0, 0, m - 1, grid, dp);
        // return helperTab(grid);
        return helperSO(grid);
    }
    int helperRec(int i, int j1, int j2, int[][] grid){
        if(j1 < 0 || j1 >= grid[0].length || j2 < 0 || j2 >= grid[0].length) return (int) -1e8;
        
        if(i == grid.length - 1){
            if(j1 == j2) return grid[i][j1];
            else return grid[i][j1] + grid[i][j2];
        }

        int maxi = Integer.MIN_VALUE;
        for(int r1 = -1; r1 <= 1; r1++){
            for(int r2 = -1; r2 <=1; r2++){
                int value;
                if(j1 == j2){
                    value = grid[i][j1] + helperRec(i + 1, j1 + r1, j2 + r2, grid);
                }
                else{
                    value = grid[i][j1] + grid[i][j2] + helperRec(i + 1, j1 + r1, j2 + r2, grid);
                }

                maxi = Math.max(maxi, value);
            }
        }
        return maxi;
    }
    int helperMem(int i, int j1, int j2, int[][] grid, int[][][] dp){
        if(j1 < 0 || j1 >= grid[0].length || j2 < 0 || j2 >= grid[0].length) return (int) -1e8;
        
        if(i == grid.length - 1){
            if(j1 == j2) return grid[i][j1];
            else return grid[i][j1] + grid[i][j2];
        }

        if(dp[i][j1][j2] != -1) return dp[i][j1][j2];

        int maxi = Integer.MIN_VALUE;
        for(int r1 = -1; r1 <= 1; r1++){
            for(int r2 = -1; r2 <=1; r2++){
                int value;
                if(j1 == j2){
                    value = grid[i][j1] + helperMem(i + 1, j1 + r1, j2 + r2, grid, dp);
                }
                else{
                    value = grid[i][j1] + grid[i][j2] + helperMem(i + 1, j1 + r1, j2 + r2, grid, dp);
                }

                maxi = Math.max(maxi, value);
            }
        }
        return dp[i][j1][j2] = maxi;
    }

    int helperTab(int[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        int[][][] dp = new int[n][m][m];

        for(int i = n - 1; i >= 0; i--){
            for(int j1 = 0; j1 < m; j1++){
                for(int j2 = 0; j2 < m; j2++){
                    if(i == n-1){
                        if(j1 == j2){
                            dp[i][j1][j2] = grid[i][j1];
                            continue;
                        }else{
                            dp[i][j1][j2] = grid[i][j1] + grid[i][j2];
                            continue;
                        }
                    }

                    int maxi = Integer.MIN_VALUE;
                    for(int d1 = -1; d1 <= 1; d1++){
                        for(int d2 = -1; d2 <= 1; d2++){
                            int value = Integer.MIN_VALUE;

                            if(j1 + d1 >= 0 && j2 + d2 >= 0 && j1 + d1 < m && j2 + d2 < m){
                                if(j1 == j2){
                                    value = grid[i][j1] + dp[i + 1][j1 + d1][j2 + d2];
                                }else{
                                    value = grid[i][j1] + grid[i][j2] + dp[i + 1][j1 + d1][j2 + d2];
                                }

                                maxi = Math.max(maxi, value);
                            }
                        }
                    }

                    dp[i][j1][j2] = maxi;
                }
            } 
        }

        return dp[0][0][m - 1];
    }

    int helperSO(int[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        int[][] nextDp = new int[m][m];

        for(int i = n - 1; i >= 0; i--){
            int[][] currDp = new int[m][m];
            for(int j1 = 0; j1 < m; j1++){
                for(int j2 = 0; j2 < m; j2++){
                    if(i == n-1){
                        if(j1 == j2){
                            currDp[j1][j2] = grid[i][j1];
                            continue;
                        }else{
                            currDp[j1][j2] = grid[i][j1] + grid[i][j2];
                            continue;
                        }
                    }

                    int maxi = Integer.MIN_VALUE;
                    for(int d1 = -1; d1 <= 1; d1++){
                        for(int d2 = -1; d2 <= 1; d2++){
                            int value = Integer.MIN_VALUE;

                            if(j1 + d1 >= 0 && j2 + d2 >= 0 && j1 + d1 < m && j2 + d2 < m){
                                if(j1 == j2){
                                    value = grid[i][j1] + nextDp[j1 + d1][j2 + d2];
                                }else{
                                    value = grid[i][j1] + grid[i][j2] + nextDp[j1 + d1][j2 + d2];
                                }

                                maxi = Math.max(maxi, value);
                            }
                        }
                    }

                    currDp[j1][j2] = maxi;
                }
            }
            nextDp = currDp;
        }

        return nextDp[0][m - 1];
    }
}
