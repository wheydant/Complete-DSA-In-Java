package Striver.DynamicProgramming.LeetCode;

import java.util.Arrays;

public class ClimbingStairs {
    int count = 0;
    public int climbStairs(int n) {
        //Recursion
        helper(n);
        // return count;

        //Memorization
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        // return helperMemo(n, dp);

        //Tabulation
        Arrays.fill(dp, -1);
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        // return dp[n];

        //Space Optimization
        if(n == 0 || n == 1) return 1;

        int prev1 = 1;
        int prev2 = 1;

        for(int i = 2; i <= n; i++){
            int curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
    //recursion
    void helper(int n){
        if(n == 0) count++;
        if(n <= 0) return;
        
        helper(n - 1);
        helper(n - 2);
    }
    int helperMemo(int n, int[] dp){
        if(n == 0) return 1;
        if(n < 0) return 0;

        if(dp[n] != -1) return dp[n];

        dp[n] = helperMemo(n - 1, dp) + helperMemo(n - 2, dp);
        return dp[n];
    }
}
