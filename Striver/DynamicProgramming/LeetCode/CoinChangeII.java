package Striver.DynamicProgramming.LeetCode;

import java.util.Arrays;

public class CoinChangeII {
    //Any coin can be used any number of times thus take will stay in the same index
    public int change(int amount, int[] coins) {
        int n = coins.length;
        // return helperRec(amount, coins, n - 1);

        int[][] dp = new int[n][amount + 1];
        for(int[] d: dp) Arrays.fill(d, -1);
        // return helperMem(amount, coins, n - 1, dp);
        // return helperTab(amount, coins);
        return helperSO(amount, coins);
    }
    
    int helperRec(int amount, int[] coins, int i){
        if(i == 0){
            //If we reached the end return 1 i.e. one solution found
            return (amount % coins[i] == 0)? 1 : 0;
        }

        int notTake = helperRec(amount, coins, i - 1);

        int take = 0;
        if(amount >= coins[i])
            //Change can be used any number of times thus index remains there itself
            take = helperRec(amount - coins[i], coins, i);

        return take + notTake;
    }

    int helperMem(int amount, int[] coins, int i, int[][] dp){
        if(i == 0){
            //If we reached the end return 1 i.e. one solution found
            return (amount % coins[i] == 0)? 1 : 0;
        }

        if(dp[i][amount] != -1) return dp[i][amount];

        int notTake = helperMem(amount, coins, i - 1, dp);

        int take = 0;
        if(amount >= coins[i])
            //Change can be used any number of times thus index remains there itself
            take = helperMem(amount - coins[i], coins, i, dp);

        return dp[i][amount] = take + notTake;
    }

    int helperTab(int amount, int[] coins){
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];

        for(int i = 0; i < n; i++){
            for(int amt = 0; amt <= amount; amt++){
                if(i == 0){
                    if(amt % coins[i] == 0) dp[i][amt] = 1;
                    continue;
                }

                int notTake = dp[i - 1][amt];

                int take = 0;
                if(amt >= coins[i])
                    take = dp[i][amt - coins[i]];

                dp[i][amt] = take + notTake;
            }
        }

        return dp[n - 1][amount];
    }

    int helperSO(int amount, int[] coins){
        int n = coins.length;
        int[] dpPrev = new int[amount + 1];

        for(int i = 0; i < n; i++){
            int[] dpCurr = new int[amount + 1];
            for(int amt = 0; amt <= amount; amt++){
                if(i == 0){
                    if(amt % coins[i] == 0) dpCurr[amt] = 1;
                    continue;
                }

                int notTake = dpPrev[amt];

                int take = 0;
                if(amt >= coins[i])
                    take = dpCurr[amt - coins[i]];

                dpCurr[amt] = take + notTake;
            }

            dpPrev = dpCurr;
        }

        return dpPrev[amount];
    }

}
