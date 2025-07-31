package Striver.DynamicProgramming.LeetCode;

import java.util.Arrays;

public class BurstBalloons {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] modifiedNums = new int[n + 2];
        
        for(int i = 0; i < n + 2; i++){
            //Keeping 1 on the edges safeguards the array
            if(i == 0 || i == n + 1){
                modifiedNums[i] = 1;
                continue;
            }
            modifiedNums[i] = nums[i - 1];
        }

        // return helperRec(1, n, modifiedNums);

        int[][] dp = new int[n + 2][n + 2];
        for(int[] d: dp)Arrays.fill(d, -1);

        // return helperMem(1, n, modifiedNums, dp);

        return helperTab(modifiedNums, n);
    }

    int helperRec(int i, int j, int[] nums){
        if(i > j) return 0;

        int maxi = Integer.MIN_VALUE;

        for(int ind = i; ind <= j; ind++){
            //Calculate reverse cost - Last step
            //Where ind is last element and 1 are on the opposite side
            int currCost = nums[i - 1]*nums[ind]*nums[j + 1];
            //Left Second last step
            //j + 1 will give earlier calculated balloon as its neighbor
            int leftCost = helperRec(i, ind - 1, nums);
            //Right Second last step
            //i - 1 will give earlier calculated balloon as its neighbor
            int rightCost = helperRec(ind + 1, j, nums);

            int totalCost = currCost + leftCost + rightCost;

            maxi = Math.max(maxi, totalCost);
        }

        return maxi;
    }

    int helperMem(int i, int j, int[] nums, int[][] dp){
        if(i > j) return 0;
        
        if(dp[i][j] != -1) return dp[i][j];
        int maxi = Integer.MIN_VALUE;

        for(int ind = i; ind <= j; ind++){
            //Calculate reverse cost - Last step
            //Where ind is last element and 1 are on the opposite side
            int currCost = nums[i - 1]*nums[ind]*nums[j + 1];
            //Left Second last step
            //j + 1 will give earlier calculated balloon as its neighbor
            int leftCost = helperMem(i, ind - 1, nums, dp);
            //Right Second last step
            //i - 1 will give earlier calculated balloon as its neighbor
            int rightCost = helperMem(ind + 1, j, nums, dp);

            int totalCost = currCost + leftCost + rightCost;

            maxi = Math.max(maxi, totalCost);
        }

        return dp[i][j] = maxi;
    }

    int helperTab(int[] nums, int n){
        int[][] dp = new int[n + 2][n + 2];

        for(int i = n; i > 0; i--){
            for(int j = 1; j <= n; j++){
                //Base case
                if(i > j) continue;
                int maxi = Integer.MIN_VALUE;

                for(int ind = i; ind <= j; ind++){
                    //Calculate reverse cost - Last step
                    //Where ind is last element and 1 are on the opposite side
                    int currCost = nums[i - 1]*nums[ind]*nums[j + 1];
                    //Left Second last step
                    //j + 1 will give earlier calculated balloon as its neighbor
                    int leftCost = dp[i][ind - 1];
                    //Right Second last step
                    //i - 1 will give earlier calculated balloon as its neighbor
                    int rightCost = dp[ind + 1][j];

                    int totalCost = currCost + leftCost + rightCost;

                    maxi = Math.max(maxi, totalCost);
                }

                dp[i][j] = maxi;
            }
        }

        return dp[1][n];
    }
}
