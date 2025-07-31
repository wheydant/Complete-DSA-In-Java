package Striver.DynamicProgramming.LeetCode;

import java.util.Arrays;

public class CoinChange {
    //Why not greedy? Get the max number divide the number and the remaining is the amount but it fails in some cases.
    //Similar to KnapSack try out all the combo and pick the minimum one. 
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;

        int[][] dp = new int[n][amount + 1];
        for(int[] d: dp) Arrays.fill(d, -1);

        int ans = helperRec(n - 1, amount, coins);
        ans = helperMem(n - 1, amount, coins, dp);
        ans = helperTab(coins, amount);
        ans = helperSO(coins, amount);
        if(ans >= (int) 1e8) return -1;
        return ans;
    }

    //TC - O(>>2^n) As we stay there even after taking thus We just say Exponential
    //SC - >>O(n) As way more recursion call can be made at max O(target)
    int helperRec(int i, int amount, int[] coins){
        if(amount == 0) return 0;
        if(i < 0){
            return 0;
        }
        //This is solution provided by striver but we can use above case also
        // if(i == 0){
        //     //If the amount can be made by the coin make it as much as possible
        //     if(amount % coins[0] == 0) return amount/coins[0];
        // }

        //NotTake
        int notTake = helperRec(i - 1, amount, coins);

        int take = (int) 1e8;

        //For infinite supply of coins we keep the index there itself
        if(amount >= coins[i]) 
            take = 1 + helperRec(i, amount - coins[i], coins);

        return Math.min(take, notTake);
    }
    //TC - O(n*amount) SC - O(n*amount) + O(amount)
    int helperMem(int i, int amount, int[] coins, int[][] dp){
        if(amount == 0) return 0;
        if(i < 0){
            return (int) 1e8;
        }

        if(dp[i][amount] != -1)return dp[i][amount];

        //NotTake
        int notTake = helperMem(i - 1, amount, coins, dp);

        int take = (int) 1e8;

        if(amount >= coins[i]) 
            take = 1 + helperMem(i, amount - coins[i], coins, dp);

        return dp[i][amount] = Math.min(take, notTake);
    }

    int helperTab(int[] coins, int amount){
        int n = coins.length;

        int[][] dp = new int[n][amount + 1];
        for(int[] d: dp) Arrays.fill(d, (int) 1e8);

        for(int i = 0; i < n; i++) dp[i][0] = 0;
        
        for(int i = 0; i < n; i++){
            for(int amt = 0; amt <= amount; amt++){
                if(i == 0){
                    if(amt % coins[i] == 0) dp[i][amt] = amt/coins[i];
                    continue;
                }

                int notTake = dp[i - 1][amt];

                int take = (int) 1e8;
                if(amt >= coins[i])
                    take = 1 + dp[i][amt - coins[i]];

                dp[i][amt] = Math.min(take, notTake);
            }
        }

        return dp[n - 1][amount];
    }

    int helperSO(int[] coins, int amount){
        int n = coins.length;

        int[] dpPrev = new int[amount + 1];
        // Arrays.fill(dpPrev, (int) 1e8);

        // dpPrev[0] = 0;
        
        for(int i = 0; i < n; i++){
            int[] dpCurr = new int[amount + 1];
            for(int amt = 0; amt <= amount; amt++){
                if(i == 0){
                    if(amt % coins[i] == 0) dpCurr[amt] = amt/coins[i];
                    else dpCurr[amt] = (int) 1e8;
                    continue;
                }

                int notTake = dpPrev[amt];

                int take = (int) 1e8;
                if(amt >= coins[i])
                    take = 1 + dpCurr[amt - coins[i]];

                dpCurr[amt] = Math.min(take, notTake);
            }
            dpPrev = dpCurr;
        }

        return dpPrev[amount];
    }

}
