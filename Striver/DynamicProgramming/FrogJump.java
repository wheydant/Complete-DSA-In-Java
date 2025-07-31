package Striver.DynamicProgramming;

// i + 1 or i + 2 jumps. Count minimum energy.

import java.util.Arrays;

public class FrogJump {
    static int frogJumpRec(int n, int[] heights){
        if(n == 0) return 0;

        int oneStep = frogJumpRec(n - 1, heights) + Math.abs(heights[n] - heights[n - 1]);
        int twoStep = Integer.MAX_VALUE;
        if(n > 1){
            twoStep = frogJumpRec(n - 2, heights) + Math.abs(heights[n] - heights[n - 2]);
        }

        return Math.min(oneStep, twoStep);
    }
    static int frogJumpMem(int n, int[] heights){
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return helper(n - 1, heights, dp);
    }
    static int helper(int n, int[] heights, int[] dp){
        if(n == 0) return 0;

        if(dp[n] != -1) return dp[n];

        int oneStep = helper(n - 1, heights, dp) + Math.abs(heights[n] - heights[n - 1]);
        int twoStep = Integer.MAX_VALUE;
        if(n > 1){
            twoStep = helper(n - 2, heights, dp) + Math.abs(heights[n] - heights[n - 2]);
        }
        return dp[n] = Math.min(oneStep, twoStep);
    }
    static int frogJumpTab(int n, int[]heights){
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for(int i = 1; i < n; i++){
            int jumpTwo = Integer.MAX_VALUE;
            int jumpOne = dp[i - 1] + Math.abs(heights[i] - heights[i - 1]);
            if(i > 1)
                jumpTwo = dp[i - 2] + Math.abs(heights[i] - heights[i - 2]);

            dp[i] = Math.min(jumpOne, jumpTwo);
        }
        return dp[n - 1];
    }
    static int frogJumpSO(int n, int[] heights){
        int prev1 = 0;
        int prev2 = 0;
        for(int i = 1; i < n; i++){
            int jumpTwo = Integer.MAX_VALUE;
            int jumpOne = prev1 + Math.abs(heights[i] - heights[i - 1]);
            if(i > 1)
                jumpTwo = prev2 + Math.abs(heights[i] - heights[i - 2]);

            int curr = Math.min(jumpOne, jumpTwo);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
    public static void main(String[] args) {
        int[] heights = {7, 4, 4, 2, 6, 6, 3, 4};
        int n = heights.length;
        //n - 1 coz zero based indexing
        System.out.println("Recursive: " + frogJumpRec(n - 1, heights));
        System.out.println("Memoized: " + frogJumpMem(n, heights));
        System.out.println("Tabulation: " + frogJumpTab(n, heights));
        System.out.println("Space Optimized: " + frogJumpSO(n, heights));
    }
}
