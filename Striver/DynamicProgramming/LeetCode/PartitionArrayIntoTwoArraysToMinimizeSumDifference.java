package Striver.DynamicProgramming.LeetCode;

import java.util.Arrays;

public class PartitionArrayIntoTwoArraysToMinimizeSumDifference {

    //Wrong
    public int minimumDifference(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += Math.abs(num);
        int n = nums.length;

        // Max possible absolute sum range: from -total to +total
        int offset = sum;
        int maxSum = 2 * sum;

        int[][] dp = new int[n][maxSum + 1];
        for (int[] row : dp) Arrays.fill(row, -1);

        // Fill the DP table with subset sum possibilities
        //So we will get the all the possibilities
        for (int target = - sum; target <= sum; target++) {
            helperMem(n - 1, target, nums, dp, offset);
        }

        // Now try to find minimum absolute difference between two partitions
        int minDiff = Integer.MAX_VALUE;
        for (int s1 = 0; s1 <= sum / 2; s1++) {
            if (dp[n - 1][s1] == 1) {
                int s2 = sum - s1;
                minDiff = Math.min(minDiff, Math.abs(s1 - s2));
            }
        }

        return minDiff;
    }

    boolean helperMem(int index, int target, int[] nums, int[][] dp, int offset) {
        if (target == 0) return true;
        if (index == 0) return nums[0] == target;

        if (dp[index][target + offset] != -1) return dp[index][target + offset] == 1;

        boolean notTake = helperMem(index - 1, target, nums, dp, offset);

        boolean take = helperMem(index - 1, target - nums[index], nums, dp, offset);

        dp[index][target + offset] = (take || notTake) ? 1 : 0;

        return take || notTake;
    }

    int helperTab(int[] nums){
        int sum = 0;
        for (int num : nums) sum += num;
        int n = nums.length;

        boolean[][] dp = new boolean[n][sum + 1];

        //Base case
        for(int i = 0; i < n; i++) dp[i][0] = true;
        if(nums[0] <= sum) dp[0][nums[0]] = true;

        for(int i = 1; i < n; i++){
            for(int target = 1; target <= sum; target++){
                boolean notTake = dp[i - 1][target];
                boolean take = false;
                if(target >= nums[0]) take = dp[i - 1][target - nums[0]];

                dp[i][target] = take || notTake;
            }
        }

        //minDiff
        int minDiff = Integer.MAX_VALUE;

        for(int s1 = 0 ; s1 <= sum/2; s1++){
            if(dp[n - 1][s1]){
                int s2 = sum - s1;
                minDiff = Math.min(minDiff, Math.abs(s1-s2));
            }
        }

        return minDiff;
    }

    public static void main(String[] args) {
        PartitionArrayIntoTwoArraysToMinimizeSumDifference q = new PartitionArrayIntoTwoArraysToMinimizeSumDifference();
        int[] nums = {3, 9, 7, 3};
        System.out.println(q.minimumDifference(nums)); // Output: 2
    }
}
