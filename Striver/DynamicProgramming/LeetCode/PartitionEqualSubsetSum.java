package Striver.DynamicProgramming.LeetCode;

import java.util.Arrays;

//For this problem 1st time, Better time complexity -> SO > Tab > Mem
public class PartitionEqualSubsetSum {
    // If we want to divide Exactly 2 subset thus s1 = s2 = s/2. If sum is odd then we can't divide it in 2 subset. Thus we just need to check if we can have sum s/2.
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for(int num : nums) sum += num;
        if((sum & 1) == 1) return false;
        int target = sum/2;
        int[][] dp = new int[n][target + 1];
        for (int[] row : dp) Arrays.fill(row, -1);
        return helperMem(n - 1, target, nums, dp);
    }
    // TC - O(2^n) SC - O(n)
    static boolean helperRec(int index, int target, int[] arr){
        if(target == 0) return true;
        if(index == 0) return (arr[0] == target);

        boolean notTake = helperRec(index - 1, target, arr);

        boolean take = false;
        if(target >= arr[index])
            take = helperRec(index - 1, target - arr[index], arr);

        return take || notTake;
    }
    // TC -> O(n*target) SC -> O(n*target) + O(n) 
    static boolean helperMem(int index, int target, int[] arr, int[][] dp){
        if(target == 0) return true;
        if(index == 0) return (arr[0] == target);

        if(dp[index][target] != -1)
            return dp[index][target] == 1;
        
        boolean notTake = helperMem(index - 1, target, arr, dp);

        boolean take = false;
        if(target >= arr[index])
            take = helperMem(index - 1, target - arr[index], arr, dp);

        dp[index][target] = notTake || take ? 1 : 0;
        return dp[index][target] == 1;
    }
    static boolean helperTab(int[] arr, int sum){
        int n = arr.length;
        boolean[][] dp = new boolean[n][sum + 1];
        for(boolean[] ar: dp) Arrays.fill(ar, false);
        //For all the index where target is 0 its true
        for(int i = 0; i < n; i++) dp[i][0] = true;

        //For 0th index only if the target is a[0] we can find it n thus true.
        //For 0th index only if the target is a[0] we can find it and thus true. Imp Addition
        if (arr[0] <= sum) dp[0][arr[0]] = true;

        //bottom up
        for(int index = 1; index < n; index++){
            for(int target = 1; target <= sum; target++){
                boolean notTake = dp[index - 1][target];

                boolean take = false;
                if(target >= arr[index])
                    take = dp[index - 1][target - arr[index]];

                dp[index][target] = take || notTake;
            }
        }

        return dp[n - 1][sum];
    }
    //We can space optimize it as index - 1. But all 0th index is marked as true
    static boolean helperSO(int[] arr, int sum){
        int n = arr.length;
        boolean[] dpPrev = new boolean[sum + 1];
        //target is 0 its true
        dpPrev[0] = true;

        //For 0th index only if the target is a[0] we can find it n thus true.
        if (arr[0] <= sum) dpPrev[arr[0]] = true;

        //bottom up
        for(int index = 1; index < n; index++){
            //Reset is important
            boolean[] dpCurr = new boolean[sum + 1];
            dpCurr[0] = true;
            for(int target = 1; target <= sum; target++){
                boolean notTake = dpPrev[target];

                boolean take = false;
                if(target >= arr[index])
                    take = dpPrev[target - arr[index]];

                dpCurr[target] = take || notTake;
            }
            dpPrev = dpCurr;
        }

        return dpPrev[sum];
    }
}
