package Striver.DynamicProgramming.LeetCode;

import java.util.Arrays;

public class PartitionArrayForMaximumSum {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        // return helperRec(0, arr, k, n);

        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        // return helperMem(0, arr, k, n, dp);

        return helperTab(arr, k);
    }

    //TC - Exponential
    int helperRec(int i, int[] arr, int k, int n){
        if(i == n) return 0;

        int len = 0, blockMax = Integer.MIN_VALUE;
        //Crazy way to check j stays inbound and also follows logic
        int maxSum = Integer.MIN_VALUE;
        for(int j = i; j < Math.min(n, i + k); j++){
            len++;
            blockMax = Math.max(blockMax, arr[j]);

            // current sum becomes len*blockMax coz whole block changes to the max value of that block
            int sum = len*blockMax + helperRec(j + 1, arr, k, n);

            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }

    //TC - O(n*k)
    int helperMem(int i, int[] arr, int k, int n, int[] dp){
        if(i == n) return 0;

        if(dp[i] != -1) return dp[i];
        int len = 0, blockMax = Integer.MIN_VALUE;
        //Crazy way to check j stays inbound and also follows logic
        int maxSum = Integer.MIN_VALUE;
        for(int j = i; j < Math.min(n, i + k); j++){
            len++;
            blockMax = Math.max(blockMax, arr[j]);

            // current sum becomes len*blockMax coz whole block changes to the max value of that block
            int sum = len*blockMax + helperMem(j + 1, arr, k, n, dp);

            maxSum = Math.max(maxSum, sum);
        }

        return dp[i] = maxSum;
    }

    int helperTab(int[] arr, int k){
        int n = arr.length;
        int[] dp = new int[n + 1];

        for(int i = n - 1; i>= 0; i--){
            int len = 0, blockMax = Integer.MIN_VALUE;
            //Crazy way to check j stays inbound and also follows logic
            int maxSum = Integer.MIN_VALUE;
            for(int j = i; j < Math.min(n, i + k); j++){
                len++;
                blockMax = Math.max(blockMax, arr[j]);

                // current sum becomes len*blockMax coz whole block changes to the max value of that block
                int sum = len*blockMax + dp[j + 1];

                maxSum = Math.max(maxSum, sum);
            }

            dp[i] = maxSum;
        }

        return dp[0];
    }
}
