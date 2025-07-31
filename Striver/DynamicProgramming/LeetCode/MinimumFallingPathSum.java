package Striver.DynamicProgramming.LeetCode;

//Any cell from 1st row to last row we can move down and diagonal left right

import java.util.Arrays;

public class MinimumFallingPathSum {
    //We will call recursion for all the elements on the last row.
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix[0].length;
        int m = matrix.length;
        int min = Integer.MAX_VALUE;

        int[][] dp = new int[m][n];

        //Test Cases have negatives in it, thus -1 are present in test cases which clashes with the code.
        for(int[] arr: dp) Arrays.fill(arr, Integer.MIN_VALUE);

        // min = helperTab(matrix);
        min = helperSO(matrix);

        for(int i = 0; i < n; i++){
            // min = Math.min(min, helperRec(m - 1, i, n,matrix));
            // min = Math.min(min, helperMem(m - 1, i, n,matrix, dp));
        }

        return min;
    }

    //TC - (3 ^ (path space i.e. n)) SC - O(stack space i.e. N)
    int helperRec(int i, int j, int n, int[][] matrix){
        if(j < 0) return (int) Math.pow(10, 9);
        if(j >= n) return (int) Math.pow(10, 9);

        if(i == 0) return matrix[i][j];

        //up
        int up = matrix[i][j] + helperRec(i - 1, j, n, matrix);

        int diagLeft = matrix[i][j] + helperRec(i - 1, j - 1, n, matrix);

        int diagRight = matrix[i][j] + helperRec(i - 1, j + 1, n, matrix);

        return Math.min(up, Math.min(diagLeft, diagRight));
    }

    //TC - O(n*m) SC - O(n + n*m)
    int helperMem(int i, int j, int n, int[][] matrix, int[][] dp){
        if(j < 0) return (int) Math.pow(10, 9);
        if(j >= n) return (int) Math.pow(10, 9);

        if(i == 0) return matrix[i][j];

        if(dp[i][j] != Integer.MIN_VALUE) return dp[i][j];
        
        int up = matrix[i][j] + helperMem(i - 1, j, n, matrix, dp);

        int diagLeft = matrix[i][j] + helperMem(i - 1, j - 1, n, matrix, dp);

        int diagRight = matrix[i][j] + helperMem(i - 1, j + 1, n, matrix, dp);

        return dp[i][j] = Math.min(up, Math.min(diagLeft, diagRight));
    }

    //TC - O(n*m) SC - O(n*m)
    int helperTab(int [][] matrix){
        int n = matrix.length;
        int m = matrix[0].length;

        int[][] dp = new int[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(i == 0){
                    dp[i][j] = matrix[i][j];
                    continue;
                }
                int up = (int) Math.pow(10, 9), diagLeft = (int) Math.pow(10, 9), diagRight = (int) Math.pow(10, 9);

                if(i > 0) up = matrix[i][j] + dp[i - 1][j];

                if(j > 0) diagLeft = matrix[i][j] + dp[i - 1][j - 1];

                //j + 1 needs to be inside bound
                if(j + 1 < m) diagRight = matrix[i][j] + dp[i - 1][j + 1]; 

                dp[i][j] = Math.min(up, Math.min(diagLeft, diagRight));
            }
        }

        int maxi = Integer.MAX_VALUE;

        //Calculation is done here itself
        for(int j = 0; j < m; j++){
            maxi = Math.min(maxi, dp[n - 1][j]);
        }

        return maxi;
    }

    //TC - O(n*m) SC - O(m)
    int helperSO(int [][] matrix){
        int n = matrix.length;
        int m = matrix[0].length;

        int[] prev = new int[m];

        for(int i = 0; i < n; i++){

            int[] curr = new int[m];
            for(int j = 0; j < m; j++){
                if(i == 0){
                    curr[j] = matrix[i][j];
                    continue;
                }
                int up = (int) Math.pow(10, 9), diagLeft = (int) Math.pow(10, 9), diagRight = (int) Math.pow(10, 9);

                if(i > 0) up = matrix[i][j] + prev[j];

                if(j > 0) diagLeft = matrix[i][j] + prev[j - 1];

                //j + 1 needs to be inside bound
                if(j + 1 < m) diagRight = matrix[i][j] + prev[j + 1]; 

                curr[j] = Math.min(up, Math.min(diagLeft, diagRight));
            }
            prev = curr;
        }

        int maxi = Integer.MAX_VALUE;

        //Calculation is done here itself
        for(int j = 0; j < m; j++){
            maxi = Math.min(maxi, prev[j]);
        }

        return maxi;
    }
}
