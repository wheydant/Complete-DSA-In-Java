package Striver.DynamicProgramming.LeetCode;

import java.util.Arrays;

public class HouseRobber {
    public int robMem(int[] nums){
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return helper(nums, n - 1, dp);
    }
    int helper(int[] nums, int i, int[] dp){
        //This can be reached via 2 only
        if(i == 0) return dp[i] = nums[i];
        //edge case
        if(i < 0) return 0;

        if(dp[i] != -1) return dp[i];
        //Pick
        int pick = nums[i] + helper(nums, i - 2, dp);

        //Not Pick
        int notPick = 0 + helper(nums, i - 1, dp);

        return dp[i] = Math.max(pick, notPick);
    }

    public int robTab(int[] nums){
        int n = nums.length;
        if(n == 1) return nums[0];

        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        dp[0] = nums[0];

        for(int i = 1; i < n; i++){
            //Pick
            int pick = nums[i];
            if(i > 1) pick += dp[i - 2];
                
            //Not Pick
            int notPick = 0 + dp[i - 1];
            
            dp[i] = Math.max(pick, notPick);
        }

        return dp[n - 1];
    }

    public int robSO(int[] nums){
        int n = nums.length;

        int prev = nums[0];
        int prev2 = 0;

        for (int i = 1; i < n; i++) {
            int pick = nums[i];
            if(i > 1) pick += prev2;

            int notPick = 0 + prev;
            int curr = Math.max(pick, notPick);
            prev2 = prev;
            prev = curr;
        }

        return prev;
    }

    public int robRec(int[] nums){
        int n = nums.length;
        return helper(nums, n - 1);
    }
    int helper(int[] nums, int i){
        //This can be reached via 2 only
        if(i == 0) return nums[i];
        //edge case
        if(i < 0) return 0;

        //Pick
        int pick = nums[i] + helper(nums, i - 2);

        //Not Pick
        int notPick = 0 + helper(nums, i - 1);

        return Math.max(pick, notPick);
    }
}
