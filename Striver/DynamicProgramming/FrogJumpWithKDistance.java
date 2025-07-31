package Striver.DynamicProgramming;

import java.util.Arrays;

public class FrogJumpWithKDistance {

    // Recursive
    static int frogJumpRec(int n, int k, int[] heights) {
        if (n == 0) return 0;

        int minSteps = Integer.MAX_VALUE;
        for (int j = 1; j <= k; j++) {
            if (n - j >= 0) {
                int jump = frogJumpRec(n - j, k, heights) + Math.abs(heights[n] - heights[n - j]);
                minSteps = Math.min(minSteps, jump);
            }
        }
        return minSteps;
    }

    // Memoization
    static int frogJumpMem(int n, int k, int[] heights) {
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return helper(n - 1, k, heights, dp);
    }

    static int helper(int i, int k, int[] heights, int[] dp) {
        if (i == 0) return 0;
        if (dp[i] != -1) return dp[i];

        int minSteps = Integer.MAX_VALUE;
        for (int j = 1; j <= k; j++) {
            if (i - j >= 0) {
                int jump = helper(i - j, k, heights, dp) + Math.abs(heights[i] - heights[i - j]);
                minSteps = Math.min(minSteps, jump);
            }
        }

        return dp[i] = minSteps;
    }

    // Tabulation
    static int frogJumpTab(int n, int k, int[] heights) {
        int[] dp = new int[n];
        dp[0] = 0;

        for (int i = 1; i < n; i++) {
            int minSteps = Integer.MAX_VALUE;
            for (int j = 1; j <= k; j++) {
                if (i - j >= 0) {
                    int jump = dp[i - j] + Math.abs(heights[i] - heights[i - j]);
                    minSteps = Math.min(minSteps, jump);
                }
            }
            dp[i] = minSteps;
        }
        return dp[n - 1];
    }

    //For space optimized we have to carry an array of k elements

    public static void main(String[] args) {
        int[] heights = {7, 4, 4, 2, 6, 6, 3, 4};
        int n = heights.length;
        int k = 4;

        System.out.println("Recursive: " + frogJumpRec(n - 1, k, heights));
        System.out.println("Memoized: " + frogJumpMem(n, k, heights));
        System.out.println("Tabulation: " + frogJumpTab(n, k, heights));
    }
}
