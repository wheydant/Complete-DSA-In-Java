package Striver.DynamicProgramming.LeetCode;

import java.util.Arrays;

//Cannot buy right after sell
public class BestTimeToBuyAndSellStockWithCooldown {
    public int maxProfit(int[] prices) {
        // return helperRec(0, 1, prices);

        int n = prices.length;
        int[][] dp = new int[n][2];
        for(int[] d: dp)Arrays.fill(d, - 1);
        // return helperMem(0, 1, prices, dp);

        return helperTab(prices);
        // return helperSO(prices);
        // return helperSSO(prices);
    }

    int helperRec(int i, int buy, int[] prices){
        //+2 could exceed the limit
        if(i >= prices.length){
            // If we have already bought it might store negative
            return 0;
        }

        //Buy
        if(buy ==  1){
            // take means money gets negative, turn buy to 0
            int take = -prices[i] + helperRec(i + 1, 0, prices);
            //Not take - but stays the same
            int notTake = 0 + helperRec(i + 1, 1, prices);

            return Math.max(take, notTake);
        }else{
            //Sell - Post sell there is cooldown of one day thus i + 2
            int sell = +prices[i] + helperRec(i + 2, 1, prices);

            int notSell = 0 + helperRec(i + 1, 0, prices);

            return Math.max(sell, notSell);
        }
    }

    int helperMem(int i, int buy, int[] prices,int[][] dp){
        if(i >= prices.length){
            // If we have already bought it might store negative
            return 0;
        }

        if(dp[i][buy] != -1) return dp[i][buy];
        //Buy
        if(buy ==  1){
            // take means money gets negative, turn buy to 0
            int take = -prices[i] + helperMem(i + 1, 0, prices, dp);
            //Not take - but stays the same
            int notTake = 0 + helperMem(i + 1, 1, prices, dp);

            return dp[i][buy] = Math.max(take, notTake);
        }else{
            //Sell
            int sell = +prices[i] + helperMem(i + 2, 1, prices, dp);

            int notSell = 0 + helperMem(i + 1, 0, prices, dp);

            return dp[i][buy] = Math.max(sell, notSell);
        }
    }

    int helperTab(int[] prices){
        int n = prices.length;
        //+2
        int[][] dp = new int[n + 2][2];

        for(int i = n - 1; i >= 0; i--){
            for(int buy = 0; buy <= 1; buy++){
                if(buy == 1){
                    int take = -prices[i] + dp[i + 1][0];
                    int notTake = 0 + dp[i + 1][1];

                    dp[i][buy] = Math.max(take, notTake);
                }else{
                    //Cooldown day +2
                    int sell = +prices[i] + dp[i + 2][1];
                    int notSell = 0 + dp[i + 1][0];

                    dp[i][buy] = Math.max(sell, notSell);
                }
            }
        }

        return dp[0][1];
    }
    //Space optimization not that good as we are dependant on +1 and +2

    //Modified Tab
    int helperModTab(int[] prices){
        int n = prices.length;
        //+2
        int[][] dp = new int[n + 2][2];

        for(int i = n - 1; i >= 0; i--){
                int take = -prices[i] + dp[i + 1][0];
                int notTake = 0 + dp[i + 1][1];

                //For buy this will run
                dp[i][1] = Math.max(take, notTake);
                //Cooldown day +2
                int sell = +prices[i] + dp[i + 2][1];
                int notSell = 0 + dp[i + 1][0];

                // for sell this will be responsible
                dp[i][0] = Math.max(sell, notSell);
            }
        return dp[0][1];
    }

}
