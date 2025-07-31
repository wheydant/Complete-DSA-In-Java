package Striver.DynamicProgramming.LeetCode;

import java.util.Arrays;

public class WildcardMatching {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        // return helperRec(n - 1, m - 1, s, p);

        int[][] dp = new int[n + 1][m + 1];
        for(int[] d:dp) Arrays.fill(d, - 1);
        // return helperMem(n, m, s, p, dp);
        
        // return helperTab(s, p);
        return helperSO(s, p);
    }

    boolean helperRec(int i, int j, String s, String p){
        //Base case
        //If both have exhausted
        if(i < 0 && j < 0) return true;
        //pattern is still left we will check if each left pattern is '*' if it is then true else false
        if(i < 0 && j >= 0){
            for(int jI = 0; jI < j; jI++){
                if(p.charAt(jI) != '*') return false;
            }
            return true;
        }
        //If pattern is exhausted before s then its already failed.
        if(j < 0) return false;

        //Match - if its char match or ? reduce both

        if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?'){
            return helperRec(i - 1, j - 1, s, p);
        }

        //If j is *
        if(p.charAt(j) == '*'){
            //skip it consider it as empty string.
            boolean skipStar = helperRec(i, j - 1, s, p);
            //Do not skip it keep it as it is consuming one from string and stay as * this will create an illusion where we iterate from consider it to 0 till rest of the strings replacement as skip will trigger this phenomena
            boolean takeStar = helperRec(i - 1, j, s, p);

            return skipStar || takeStar;
        }

        //No match
        return false;
    }

    boolean helperMem(int i, int j, String s, String p, int[][] dp){
        //Base case
        //If both have exhausted
        if(i == 0 && j == 0) return true;
        //pattern is still left we will check if each left pattern is '*' if it is then true else false
        if(i == 0 && j > 0){
            for(int jI = 1; jI <= j; jI++){
                if(p.charAt(jI - 1) != '*') return false;
            }
            return true;
        }
        //If pattern is exhausted before s then its already failed.
        if(j == 0) return false;

        //dp
        if(dp[i][j] != -1) return dp[i][j] == 1;


        //Match - if its char match or ? reduce both

        if(s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?'){
            boolean match = helperMem(i - 1, j - 1, s, p, dp);

            dp[i][j] = (match)? 1:0;

            return dp[i][j] == 1;
        }

        //If j is *
        if(p.charAt(j - 1) == '*'){
            //skip it consider it as empty string.
            boolean skipStar = helperMem(i, j - 1, s, p, dp);
            //Do not skip it keep it as it is consuming one from string and stay as * this will create an illusion where we iterate from consider it to 0 till rest of the strings replacement as skip will trigger this phenomena
            boolean takeStar = helperMem(i - 1, j, s, p, dp);

            dp[i][j] = (skipStar || takeStar)? 1:0;
            return skipStar || takeStar;
        }

        //No match
        dp[i][j] = 0;
        return dp[i][j] == 1;
    }

    boolean isAllStars(String p, int i){
        for(int j = 1; j <= i; j++){
            if(p.charAt(j - 1) != '*') return false;
        }

        return true;
    }
    boolean helperTab(String s, String p){
        int n = s.length();
        int m = p.length();

        boolean[][] dp = new boolean[n + 1][m + 1];

        dp[0][0] = true;

        // Initialize the first row and column based on wildcard '*' in S1
        for(int i = 1; i <= n; i++) dp[i][0] = false;

        for(int j = 1; j <= m; j++){
            dp[0][j] = isAllStars(p, j);
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                //Match - if its char match or ? reduce both
                if(s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?'){
                    boolean match = dp[i - 1][j - 1];
                    dp[i][j] = match;
                }
                //If j is *
                else if(p.charAt(j - 1) == '*'){
                    //skip it consider it as empty string.
                    boolean skipStar = dp[i][j - 1];
                    //Do not skip it keep it as it is consuming one from string and stay as * this will create an illusion where we iterate from consider it to 0 till rest of the strings replacement as skip will trigger this phenomena
                    boolean takeStar = dp[i - 1][j];

                    dp[i][j] = (skipStar || takeStar);
                }
                else{
                    //No match
                    dp[i][j] = false;
                }
            }
        }

        return dp[n][m];
    }

    boolean helperSO(String s, String p){
        int n = s.length();
        int m = p.length();

        boolean[] dpPrev = new boolean[m + 1];
        boolean[] dpCurr = new boolean[m + 1];
        
        dpPrev[0] = true;

        // Initialize the first row and column based on wildcard '*' in S1
        // for(int i = 1; i <= n; i++) dp[i][0] = false;

        for(int j = 1; j <= m; j++){
            dpPrev[j] = isAllStars(p, j);
        }

        for(int i = 1; i <= n; i++){
            dpCurr[0] = false;
            for(int j = 1; j <= m; j++){
                //Match - if its char match or ? reduce both
                if(s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?'){
                    boolean match = dpPrev[j - 1];
                    dpCurr[j] = match;
                }
                //If j is *
                else if(p.charAt(j - 1) == '*'){
                    //skip it consider it as empty string.
                    boolean skipStar = dpCurr[j - 1];
                    //Do not skip it keep it as it is consuming one from string and stay as * this will create an illusion where we iterate from consider it to 0 till rest of the strings replacement as skip will trigger this phenomena
                    boolean takeStar = dpPrev[j];

                    dpCurr[j] = (skipStar || takeStar);
                }
                else{
                    //No match
                    dpCurr[j] = false;
                }
            }

            dpPrev = dpCurr.clone();
        }

        return dpPrev[m];
    }
}
