package Striver.DynamicProgramming.LeetCode;

import java.util.Arrays;

public class EditDistance {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        // return helperRec(n - 1, m - 1, word1, word2);

        //1 based index
        int[][] dp = new int[n + 1][m + 1];
        for(int[] d : dp) Arrays.fill(d, -1);
        // return helperMem(n , m , word1, word2, dp);

        // return helperTab(word1, word2);
        return helperSO(word1, word2);
    }

    int helperRec(int i, int j, String word1, String word2){
        if(i < 0){
            //We need to insert rest of the string
            return j + 1;
        }

        if(j < 0) return i + 1;

        //If match no action requires
        if(word1.charAt(i) == word2.charAt(j)){
            return 0 + helperRec(i - 1, j - 1, word1, word2);
        }

        //If not matched try everything

        //Insert - insert in word1 and thus matching the char from word2's. i stays there itself as insert is been done next to it
        int insert = 1 + helperRec(i, j - 1, word1, word2);
        //Delete - Delete from word1 and compare the next char with word2's current card
        int delete = 1 + helperRec(i - 1, j, word1, word2);
        //Replace - Just replace word1's char with word2's, thus moving both i and j
        int replace = 1 + helperRec(i - 1, j - 1, word1, word2);

        return Math.min(insert, Math.min(delete, replace));
    }

    int helperMem(int i, int j, String word1, String word2, int[][] dp){
        if(i == 0){
            //We need to insert rest of the string
            return j;
        }

        //In 1 based indexing we can return 1 = 1 as here 0  no longer means word1[0]
        if(j == 0) return i;

        if(dp[i][j] != -1) return dp[i][j];

        //If match no action requires
        if(word1.charAt(i - 1) == word2.charAt(j - 1)){
            return dp[i][j] = 0 + helperMem(i - 1, j - 1, word1, word2, dp);
        }

        //If not matched try everything

        //Insert - insert in word1 and thus matching the char from word2's. i stays there itself as insert is been done next to it
        int insert = 1 + helperMem(i, j - 1, word1, word2, dp);
        //Delete - Delete from word1 and compare the next char with word2's current card
        int delete = 1 + helperMem(i - 1, j, word1, word2, dp);
        //Replace - Just replace word1's char with word2's, thus moving both i and j
        int replace = 1 + helperMem(i - 1, j - 1, word1, word2, dp);

        return dp[i][j] = Math.min(insert, Math.min(delete, replace));
    }

    int helperTab(String word1, String word2){
        int n = word1.length();
        int m = word2.length();
        // return helperRec(n - 1, m - 1, word1, word2);

        //1 based index
        int[][] dp = new int[n + 1][m + 1];
        
        for(int i = 0; i <= n; i++) dp[i][0] = i;
        for(int j = 0; j <= m; j++) dp[0][j] = j;

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                //If match no action requires
                if(word1.charAt(i - 1) == word2.charAt(j - 1)){
                    dp[i][j] = 0 + dp[i - 1][j - 1];
                }else{
                    //If not matched try everything

                    //Insert - insert in word1 and thus matching the char from word2's. i stays there itself as insert is been done next to it
                    int insert = 1 + dp[i][j - 1];
                    //Delete - Delete from word1 and compare the next char with word2's current card
                    int delete = 1 + dp[i - 1][j];
                    //Replace - Just replace word1's char with word2's, thus moving both i and j
                    int replace = 1 + dp[i - 1][j - 1];

                    dp[i][j] = Math.min(insert, Math.min(delete, replace));
                }
            }
        }

        return dp[n][m];
    }

    int helperSO(String word1, String word2){
        int n = word1.length();
        int m = word2.length();
        // return helperRec(n - 1, m - 1, word1, word2);

        //1 based index
        int[] dpPrev = new int[m + 1];
        int[] dpCurr = new int[m + 1];
        
        // for(int i = 0; i <= n; i++) dp[i][0] = i;
        for(int j = 0; j <= m; j++) dpPrev[j] = j;

        for(int i = 1; i <= n; i++){
            //Oth column also needs to be initialized
            dpCurr[0] = i;
            for(int j = 1; j <= m; j++){
                //If match no action requires
                if(word1.charAt(i - 1) == word2.charAt(j - 1)){
                    dpCurr[j] = 0 + dpPrev[j - 1];
                }else{
                    //If not matched try everything

                    //Insert - insert in word1 and thus matching the char from word2's. i stays there itself as insert is been done next to it
                    int insert = 1 + dpCurr[j - 1];
                    //Delete - Delete from word1 and compare the next char with word2's current card
                    int delete = 1 + dpPrev[j];
                    //Replace - Just replace word1's char with word2's, thus moving both i and j
                    int replace = 1 + dpPrev[j - 1];

                    dpCurr[j] = Math.min(insert, Math.min(delete, replace));
                }
            }

            dpPrev = dpCurr.clone();
        }

        return dpPrev[m];
    }
}
