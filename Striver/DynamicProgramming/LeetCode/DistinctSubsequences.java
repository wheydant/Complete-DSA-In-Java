package Striver.DynamicProgramming.LeetCode;

import java.util.Arrays;

public class DistinctSubsequences {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        // return helperRec(n - 1, m - 1, s, t);

        //1 based index
        int[][] dp = new int[n + 1][m + 1];
        for(int[] d: dp) Arrays.fill(d, - 1);

        // return helperMem(n, m, s, t, dp);

        // return helperTab(s, t);

        // return helperSO(s, t);

        return helperSSO(s, t);
    }

    int helperRec(int i, int j, String s, String t){
        //Base case 
        //If target is exhausted than we have found the match
        if(j < 0) return 1;
        //If exhausted s string and still target is left than no match
        if(i < 0) return 0;

        //Char Match
        if(s.charAt(i) == t.charAt(j)){
            //Consider that charachter;
            int consider = helperRec(i - 1, j - 1, s, t);

            //Else look for another char if there exist
            int notConsider = helperRec(i - 1, j, s, t);

            return consider + notConsider;
        }

        //If not match find for that char in lower part of s

        int noMatch = helperRec(i - 1, j, s, t);

        return noMatch;
    }

    int helperMem(int i, int j, String s, String t, int[][] dp){
        //Base case 
        //If target is exhausted than we have found the match
        if(j == 0) return 1;
        //If exhausted s string and still target is left than no match
        if(i == 0) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        //Char Match
        if(s.charAt(i - 1) == t.charAt(j - 1)){
            //Consider that charachter;
            int consider = helperMem(i - 1, j - 1, s, t, dp);

            //Else look for another char if there exist
            int notConsider = helperMem(i - 1, j, s, t, dp);

            return dp[i][j] = consider + notConsider;
        }

        //If not match find for that char in lower part of s
        int noMatch = helperMem(i - 1, j, s, t, dp);

        return dp[i][j] = noMatch;
    }

    int helperTab(String s, String t){
        int n = s.length();
        int m = t.length();
        //1 based index
        int[][] dp = new int[n + 1][m + 1];

        dp[0][0] = 1;
        for(int i = 1; i <= n; i++){
            for(int j = 0; j <= m; j++){
                //Skip i == 0 as it is already initialized with 0 on declaration
                if(j == 0){
                    dp[i][j] = 1;
                    continue;
                }
                //Char Match
                if(s.charAt(i - 1) == t.charAt(j - 1)){
                    //Consider that charachter;
                    int consider = dp[i - 1][j - 1];

                    //Else look for another char if there exist
                    int notConsider = dp[i - 1][j];

                    dp[i][j] = consider + notConsider;
                }else{
                    //If not match find for that char in lower part of s
                    int noMatch = dp[i - 1][j];

                    dp[i][j] = noMatch;
                }
            }
        }

        // System.out.println(Arrays.deepToString(dp));

        return dp[n][m];
    }

    int helperSO(String s, String t){
        int n = s.length();
        int m = t.length();
        //1 based index
        int[] dpPrev = new int[m + 1];

        dpPrev[0] = 1;
        for(int i = 1; i <= n; i++){
            int[] dpCurr = new int[m + 1];
            for(int j = 0; j <= m; j++){
                //Skip i == 0 as it is already initialized with 0 on declaration
                if(j == 0){
                    dpCurr[j] = 1;
                    continue;
                }
                //Char Match
                if(s.charAt(i - 1) == t.charAt(j - 1)){
                    //Consider that charachter;
                    int consider = dpPrev[j - 1];

                    //Else look for another char if there exist
                    int notConsider = dpPrev[j];

                    dpCurr[j] = consider + notConsider;
                }else{
                    //If not match find for that char in lower part of s
                    int noMatch = dpPrev[j];

                    dpCurr[j] = noMatch;
                }
            }

            dpPrev = dpCurr;
        }

        // System.out.println(Arrays.deepToString(dp));

        return dpPrev[m];
    }

    int helperSSO(String s, String t){
        int n = s.length();
        int m = t.length();
        //1 based index
        int[] dpSuper = new int[m + 1];

        dpSuper[0] = 1;
        for(int i = 1; i <= n; i++){
            //Super space optimization always go in reverse fashion
            for(int j = m; j >= 0; j--){
                //Skip i == 0 as it is already initialized with 0 on declaration
                if(j == 0){
                    dpSuper[j] = 1;
                    continue;
                }
                //Char Match
                if(s.charAt(i - 1) == t.charAt(j - 1)){
                    //Consider that charachter;
                    // int consider = dpSuper[j - 1];

                    //Else look for another char if there exist
                    // int notConsider = dpSuper[j];

                    dpSuper[j] = dpSuper[j - 1] + dpSuper[j];
                }
                //No need to write this part also as j stays at j
                // else{
                //     //If not match find for that char in lower part of s
                //     int noMatch = dpSuper[j];

                //     dpSuper[j] = noMatch;
                // }
            }
        }

        // System.out.println(Arrays.deepToString(dp));

        return dpSuper[m];
    }
}
