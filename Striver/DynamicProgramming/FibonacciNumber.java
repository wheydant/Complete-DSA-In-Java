package Striver.DynamicProgramming;

import java.util.Arrays;

public class FibonacciNumber{
    static int fMemo(int n, int[] dp){
        if(n <= 1)return n;
        if(dp[n] != -1) return dp[n];
        return dp[n] = fMemo(n - 1, dp) + fMemo(n - 2, dp);
    }
    
    public static void main(String[] args) {
        int n = 5;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println(fMemo(n, dp));

        //Tabulation
        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = 1;

        for(int i = 2; i <=n; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        System.out.println(dp[n]);

        //Space Optimization
        int prev2 = 0;
        int prev = 1;
        
        for(int i=2; i<=n; i++){
            int cur_i = prev2+ prev;
            prev2 = prev;
            prev= cur_i;
        }
        System.out.println(prev);
    }
}