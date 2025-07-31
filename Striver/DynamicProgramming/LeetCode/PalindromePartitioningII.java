package Striver.DynamicProgramming.LeetCode;

import java.util.Arrays;

public class PalindromePartitioningII {
    public int minCut(String s) {
        int n = s.length();
        //We do the partition at the end a|b|c| we need to eliminate this last partition
        // return helperRec(0, s, n) - 1;

        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        //We do the partition at the end a|b|c| we need to eliminate this last partition
        // return helperMem(0, s, n, dp) - 1;

        return helperTab(s);
    }

    static boolean isPalindrome(int i, int j, String s) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    //TC - Exponential
    int helperRec(int i, String str, int n){
        if(i == n) return 0;

        //Front Partition start from front and try all possible ans
        int minCost = Integer.MAX_VALUE;
        // String[i...j]
        for (int j = i; j < n; j++) {
            if (isPalindrome(i, j, str)) {
                //Check for next string
                int cost = 1 + helperRec(j + 1, str, n);
                minCost = Math.min(minCost, cost);
            }
        }
        return minCost;
    }
    //TC - O(N)*N ->  O(N^2)
    int helperMem(int i, String str, int n, int[] dp){
        if(i == n) return 0;

        if(dp[i] != -1) return dp[i];
        //Front Partition start from front and try all possible ans
        int minCost = Integer.MAX_VALUE;
        // String[i...j]
        for (int j = i; j < n; j++) {
            if (isPalindrome(i, j, str)) {
                //Check for next string
                int cost = 1 + helperMem(j + 1, str, n, dp);
                minCost = Math.min(minCost, cost);
            }
        }
        return dp[i] = minCost;
    }

    int helperTab(String str){
        int n = str.length();
        int[] dp = new int[n + 1];

        for(int i = n - 1; i >= 0; i--){
            int minCost = Integer.MAX_VALUE;
            // String[i...j]
            for (int j = i; j < n; j++) {
                if (isPalindrome(i, j, str)) {
                    //Check for next string
                    int cost = 1 + dp[j + 1];
                    minCost = Math.min(minCost, cost);
                }
            }
            dp[i] = minCost;
        }

        return dp[0] - 1;
    }
}
