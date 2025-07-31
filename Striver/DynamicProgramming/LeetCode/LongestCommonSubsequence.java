package Striver.DynamicProgramming.LeetCode;

import java.util.Arrays;

public class LongestCommonSubsequence{
    //Brute Force generate all the subsequence than compare but its exponential.
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        // return helperRec(n, m, text1, text2);

        int[][] dp = new int[n][m];
        for(int[] d : dp) Arrays.fill(d, -1);
        
        // return helperMem(n - 1, m - 1, text1, text2, dp);

        int[][] dpIndexShift = new int[n + 1][m + 1];
        for(int[] d : dpIndexShift) Arrays.fill(d, -1);
        
        // return helperMemIndexShift(n - 1, m - 1, text1, text2, dpIndexShift);

        // return helperTab(text1, text2);

        return helperSO(text1, text2);
    }

    //TC - O(2^n * 2^m) SC - O(n + m) auxiliary stack space
    int helperRec(int i, int j, String text1, String text2){
        if(i < 0 || j < 0) return 0;

        //Match - Move both index by 1 when matches
        if(text1.charAt(i) == text2.charAt(j)){
            return 1 + helperRec(i - 1, j - 1, text1, text2);
        }

        //Not Match - 2 cases can occur move i or j
        return 0 + Math.max(helperRec(i - 1, j, text1, text2), helperRec(i, j - 1, text1, text2));
    }

    // TC - O(n*m) SC = O(n*m) + O(n + m)
    int helperMem(int i, int j, String text1, String text2, int[][] dp){
        if(i < 0 || j < 0) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        //Match - Move both index by 1 when matches
        if(text1.charAt(i) == text2.charAt(j)){
            return dp[i][j] = 1 + helperMem(i - 1, j - 1, text1, text2, dp);
        }

        //Not Match - 2 cases can occur move i or j
        //0 can be skipped
        return dp[i][j] =  Math.max(helperMem(i - 1, j, text1, text2, dp), helperMem(i, j - 1, text1, text2, dp));
    }

    int helperMemIndexShift(int i, int j, String text1, String text2, int[][] dp){
        if(i == 0 || j == 0) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        //Match - Move both index by 1 when matches
        if(text1.charAt(i - 1) == text2.charAt(j - 1)){
            return dp[i][j] = 1 + helperMemIndexShift(i - 1, j - 1, text1, text2, dp);
        }

        //Not Match - 2 cases can occur move i or j
        //0 can be skipped
        return dp[i][j] =  Math.max(helperMemIndexShift(i - 1, j, text1, text2, dp), helperMemIndexShift(i, j - 1, text1, text2, dp));
    }

    int helperTab(String text1, String text2){
        int n = text1.length();
        int m = text2.length();

        int[][] dpIndexShift = new int[n + 1][m + 1];

        //Base Case - No need to explicitly state that as array is initialized with 0. 
        for(int i = 0; i <= n; i++) dpIndexShift[i][0] = 0;
        for(int j = 0; j <= m; j++) dpIndexShift[0][j] = 0;

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                //This whole can be skip using i,j -> 1 
                // if(i == 0 || j == 0){
                    // No need to explicitly state it.
                    // dpIndexShift[i][j] = 0;
                    // continue;
                // }
                if(text1.charAt(i - 1) == text2.charAt(j - 1)){
                    dpIndexShift[i][j] = 1 + dpIndexShift[i - 1][j - 1];
                }else{
                    dpIndexShift[i][j] = 0 + Math.max(dpIndexShift[i - 1][j], dpIndexShift[i][j - 1]);
                }
            }
        }
        
        return dpIndexShift[n][m];
    }

    int helperSO(String text1, String text2){
        int n = text1.length();
        int m = text2.length();

        int[] dpPrev = new int[m + 1];

        //Base Case - No need to explicitly state that as array is initialized with 0. 
        // for(int i = 0; i <= n; i++) dpIndexShift[i][0] = 0;
        for(int j = 0; j <= m; j++) dpPrev[j] = 0;

        for(int i = 1; i <= n; i++){
            int[] dpCurr = new int[m + 1];
            for(int j = 1; j <= m; j++){
                //This whole can be skip using i,j -> 1 
                // if(i == 0 || j == 0){
                    // No need to explicitly state it.
                    // dpIndexShift[i][j] = 0;
                    // continue;
                // }
                if(text1.charAt(i - 1) == text2.charAt(j - 1)){
                    dpCurr[j] = 1 + dpPrev[j - 1];
                }else{
                    dpCurr[j] = 0 + Math.max(dpPrev[j], dpCurr[j - 1]);
                }
            }

            dpPrev = dpCurr;
        }
        
        return dpPrev[m];
    }
}