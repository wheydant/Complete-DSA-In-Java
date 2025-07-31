package Striver.DynamicProgramming.LeetCode;

import java.util.Arrays;

public class BestTimeToBuyAndSellStockWithTransactionFee {
    public int maxProfit(int[] prices, int fee) {

        //Without recursion solution
        int max = 0;
        int buy = prices[0];
        for(int i = 1; i < prices.length; i++){
            if(buy < prices[i]){
                max += prices[i] - buy;
            }
            buy = prices[i];
        }
        // return max;
        //can buy - 1, sell - 0
        // return helperRec(0, 1, prices, fee);

        int n = prices.length;
        int[][] dp = new int[n][2];
        for(int[] d: dp)Arrays.fill(d, - 1);
        // return helperMem(0, 1, prices, dp, fee);

        // return helperTab(prices, fee);
        // return helperSO(prices, fee);
        return helperSSO(prices, fee);
    }

    int helperRec(int i, int buy, int[] prices, int fee){
        if(i == prices.length){
            // If we have already bought it might store negative
            return 0;
        }

        //Buy
        if(buy ==  1){
            // take means money gets negative, turn buy to 0
            int take = -prices[i] - fee + helperRec(i + 1, 0, prices, fee);
            //Not take - but stays the same
            int notTake = 0 + helperRec(i + 1, 1, prices, fee);

            return Math.max(take, notTake);
        }else{
            //Sell
            int sell = +prices[i] + helperRec(i + 1, 1, prices, fee);

            int notSell = 0 + helperRec(i + 1, 0, prices, fee);

            return Math.max(sell, notSell);
        }
    }

    int helperMem(int i, int buy, int[] prices,int[][] dp, int fee){
        if(i == prices.length){
            // If we have already bought it might store negative
            return 0;
        }

        if(dp[i][buy] != -1) return dp[i][buy];
        //Buy
        if(buy ==  1){
            // take means money gets negative, turn buy to 0
            int take = -prices[i] - fee + helperMem(i + 1, 0, prices, dp, fee);
            //Not take - but stays the same
            int notTake = 0 + helperMem(i + 1, 1, prices, dp, fee);

            return dp[i][buy] = Math.max(take, notTake);
        }else{
            //Sell
            int sell = +prices[i] + helperMem(i + 1, 1, prices, dp, fee);

            int notSell = 0 + helperMem(i + 1, 0, prices, dp, fee);

            return dp[i][buy] = Math.max(sell, notSell);
        }
    }

    int helperTab(int[] prices, int fee){
        int n = prices.length;
        int[][] dp = new int[n + 1][2];

        for(int i = n - 1; i >= 0; i--){
            for(int buy = 0; buy <= 1; buy++){
                if(buy == 1){
                    int take = -prices[i] - fee + dp[i + 1][0];
                    int notTake = 0 + dp[i + 1][1];

                    dp[i][buy] = Math.max(take, notTake);
                }else{
                    int sell = +prices[i] + dp[i + 1][1];
                    int notSell = 0 + dp[i + 1][0];

                    dp[i][buy] = Math.max(sell, notSell);
                }
            }
        }

        return dp[0][1];
    }

    int helperSO(int[] prices, int fee){
        int n = prices.length;
        int[] dpNext = new int[2];

        for(int i = n - 1; i >= 0; i--){
            int[] dpCurr = new int[2];
            for(int buy = 0; buy <= 1; buy++){
                if(buy == 1){
                    int take = -prices[i] - fee + dpNext[0];
                    int notTake = 0 + dpNext[1];

                    dpCurr[buy] = Math.max(take, notTake);
                }else{
                    int sell = +prices[i] + dpNext[1];
                    int notSell = 0 + dpNext[0];

                    dpCurr[buy] = Math.max(sell, notSell);
                }
            }

            dpNext = dpCurr;
        }

        return dpNext[1];
    }

    int helperSSO(int[] prices, int fee){
        int aheadNotBuy = 0, aheadBuy = 0, currBuy, currNotBuy;

        int n = prices.length;
        for(int i = n - 1; i >= 0; i--){
            for(int buy = 0; buy <= 1; buy++){
                currNotBuy = Math.max(prices[i] + aheadBuy, 0 + +aheadNotBuy);

                currBuy = Math.max(-prices[i] -fee + aheadNotBuy, 0 + aheadBuy);

                aheadBuy = currBuy;
                aheadNotBuy = currNotBuy;
            }
        }

        return aheadBuy;
    }
}
