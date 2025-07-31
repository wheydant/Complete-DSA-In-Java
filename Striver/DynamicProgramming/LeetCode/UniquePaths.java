package Striver.DynamicProgramming.LeetCode;

import java.util.Arrays;

public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int x = m - 1, y = n - 1;
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++) Arrays.fill(dp[i], -1);
        // return helperRec(m, n, x, y);
        //No need to even provide m and n
        // return helperMem(x, y, dp);
        // return helperTab(m, n);
        return helperSO(m, n);
    }
    // Will start recursion from bottom up, thus our robot will move up and left.
    //TC -> O(2^(m*n)) as each block has 2 options. SC O(path length) path length = (m - 1) + (n - 1)
    int helperRec(int m, int n, int x, int y){
        if(x == 0 && y == 0) return 1;

        if(x < 0 || y < 0) return 0;

        //Up
        int up = helperRec(m, n, x - 1, y);
        int left = helperRec(m, n, x, y - 1);

        return up + left;
    }
    //TC - All the calls will be made only once O(m*n)
    //SC - O((m - 1) + (n - 1)) + O(n*m)
    int helperMem(int x, int y, int[][] dp){
        if(x == 0 && y == 0) return 1;

        if(x < 0 || y < 0) return 0;

        if(dp[x][y] != -1) return dp[x][y];

        //Up
        int up = helperMem(x - 1, y, dp);
        int left = helperMem(x, y - 1, dp);

        return dp[x][y] = up + left;
    }
    int helperTab(int m, int n){
        int[][] dp = new int[m][n];
        // dp[0][0] = 1;
        // for(int i = 1; i < m; i++){
        //     for(int j = 1; j < n; j++){
        //         //This skips 1st row and col
        //         int up = dp[i - 1][j];
        //         int left = dp[i][j - 1];

        //         dp[i][j] = left + up;
        //     }
        // }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                //Base case
                if(i == 0 && j == 0){
                    dp[i][j] = 1;
                    continue;
                }
                int up = 0;
                int left = 0;
                
                //We are traversing in reverse order coz we are figuring how many up and lefts will reach base.
                if(i > 0) up = dp[i - 1][j];
                if(j > 0) left = dp[i][j - 1];

                dp[i][j] = up + left;
            }
        }

        return dp[m - 1][n - 1];
    }
    //dummy dp up filled with 0.
    int helperSO(int m, int n){
        int[] prev = new int[n];
        Arrays.fill(prev, -1);

        for(int i = 0; i < m; i++){
            int[] temp = new int[n];
            for(int j = 0; j < n; j++){
                //Base case
                if(i == 0 && j == 0){
                    temp[j] = 1;
                    continue;
                }
                int up = 0;
                int left = 0;
                
                //We are traversing in reverse order coz we are figuring how many up and lefts will reach base.
                if(i > 0) up = prev[j];
                if(j > 0) left = temp[j - 1];

                temp[j] = up + left;
            }
            prev = temp;
        }

        return prev[n - 1];
    }
}
