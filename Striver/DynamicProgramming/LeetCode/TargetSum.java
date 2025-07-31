package Striver.DynamicProgramming.LeetCode;

import java.util.Arrays;

public class TargetSum {
    //See Explanation in Notes Crazy approach
    public int findTargetSumWays(int[] nums, int target) {
        return countPartitions(target, nums);
    }

    static int countPartitions(int d, int[] arr) {
        int sum = 0;
        for (int num : arr) sum += num;

        // Corrected condition
        if ((sum + d) % 2 != 0 || sum < Math.abs(d)) return 0;

        int n = arr.length;
        int target = (sum + d) / 2;

        int[][] dp = new int[n][target + 1];
        for (int[] row : dp) Arrays.fill(row, -1);

        // return helperMem(n - 1, target, arr, dp);
        // return helperTab(arr, target);
        return helperSO(arr, target);
    }

    static int helperMem(int i, int k, int[] num, int[][] dp) {
        if (i == 0) {
            if (k == 0 && num[0] == 0) return 2;
            if (k == 0 || k == num[0]) return 1;
            return 0;
        }

        if (dp[i][k] != -1) return dp[i][k];

        int notTake = helperMem(i - 1, k, num, dp);
        int take = 0;
        if (k >= num[i]) take = helperMem(i - 1, k - num[i], num, dp);

        return dp[i][k] = take + notTake;
    }

    static int helperTab(int[] num, int k) {
        int n = num.length;
        int[][] dp = new int[n][k + 1];

        if (num[0] == 0) {
            dp[0][0] = 2;
        } else {
            dp[0][0] = 1;
        }

        if (num[0] != 0 && num[0] <= k) dp[0][num[0]] = 1;

        for (int i = 1; i < n; i++) {
            for (int target = 0; target <= k; target++) {
                int notTake = dp[i - 1][target];
                int take = 0;
                if (target >= num[i]) take = dp[i - 1][target - num[i]];

                dp[i][target] = take + notTake;
            }
        }

        return dp[n - 1][k];
    }

    static int helperSO(int[] num, int k) {
        int n = num.length;
        int[] prev = new int[k + 1];

        if (num[0] == 0) {
            prev[0] = 2;
        } else {
            prev[0] = 1;
        }

        if (num[0] != 0 && num[0] <= k) prev[num[0]] = 1;

        for (int i = 1; i < n; i++) {
            int[] curr = new int[k + 1];
            for (int target = 0; target <= k; target++) {
                int notTake = prev[target];
                int take = 0;
                if (target >= num[i]) take = prev[target - num[i]];

                curr[target] = take + notTake;
            }
            prev = curr;
        }

        return prev[k];
    }
}
