package Striver.DynamicProgramming.LeetCode;

public class NumberOfLongestIncreasingSubsequence {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        //Keeps the fount of LIS reaching to that position
        int[] cnt = new int[n];

        int maxi = 1;

        for(int i = 0; i < n; i++){
            //Initializes each element is LIS of itself and can be reached by itself
            dp[i] = 1;
            cnt[i] = 1;

            for(int prev = 0; prev < i; prev++){
                if(nums[prev] < nums[i]){
                    if(dp[i] < 1 + dp[prev]){
                        dp[i] = Math.max(dp[i], 1 + dp[prev]);
                        cnt[i] = cnt[prev];
                    }
                    //Don't first check coz prev values are usually 1 + dp[prev] first assign then check if its this case or not
                    else if(dp[i] == 1 + dp[prev]){
                        cnt[i] = cnt[i] + cnt[prev];
                    }
                }
            }

            maxi = Math.max(maxi, dp[i]);
        }


        int maxCnt = 0;
        for(int i = 0; i < n; i++){
            //Count all the lengths of all the alias eg. 1, 2, 4, 3 -> 1, 2, 4 and 1, 2, 3 thus + and not just assign 
            if(dp[i] == maxi) maxCnt += cnt[i];
        }

        return maxCnt;
    }
}
