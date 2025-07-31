package Striver.DynamicProgramming.LeetCode;

import java.util.Arrays;

public class BestTimeToBuyAndSellIII {
    //At max 2 transaction
    public int maxProfit(int[] prices) {
        int n = prices.length;
        //Index, 1 Buy 0 sell, cap 2
        // return helperRec(0, 1, 2, prices);

        int[][][] dp = new int[n][2][3];
        for(int[][] d : dp) for(int[] dArr : d) Arrays.fill(dArr, -1);

        // return helperMem(0, 1, 2, prices, dp);

        // return helperTab(prices);
        // return helperSO(prices);
        return helperSSO(prices);
    }

    //TC - exponential
    int helperRec(int i, int buy, int cap, int[] prices){
        //Nothing to get from market
        if(cap == 0) return 0;
        //If days are exhausted nothing to get from market
        if(i == prices.length) return 0;

        //Buy
        if(buy == 1){
            //Invest in market and sell becomes 0 but cap remains as it is as without sell a transaction is not completed very imp
            int take = -prices[i] + helperRec(i + 1, 0, cap, prices);
            int notTake = 0 + helperRec(i + 1, 1, cap, prices);

            return Math.max(take, notTake);
        }else{
            //Sell adds the money from market and cap is reduced as txn is completed, make switch to buy again
            int sell = +prices[i] + helperRec(i + 1, 1, cap - 1, prices);

            //Sell still remains intact so does cap as transaction is not completed
            int notSell = 0 + helperRec(i + 1, 0, cap, prices);

            return Math.max(sell, notSell);
        }
    }

    int helperMem(int i, int buy, int cap, int[] prices, int[][][] dp){
        //Nothing to get from market
        if(cap == 0) return 0;
        //If days are exhausted nothing to get from market
        if(i == prices.length) return 0;

        if(dp[i][buy][cap] != -1) return dp[i][buy][cap];

        //Buy
        if(buy == 1){
            //Invest in market and sell becomes 0 but cap remains as it is as without sell a transaction is not completed very imp
            int take = -prices[i] + helperMem(i + 1, 0, cap, prices, dp);
            int notTake = 0 + helperMem(i + 1, 1, cap, prices, dp);

            return dp[i][buy][cap] = Math.max(take, notTake);
        }else{
            //Sell adds the money from market and cap is reduced as txn is completed, make switch to buy again
            int sell = +prices[i] + helperMem(i + 1, 1, cap - 1, prices, dp);

            //Sell still remains intact so does cap as transaction is not completed
            int notSell = 0 + helperMem(i + 1, 0, cap, prices, dp);

            return dp[i][buy][cap] = Math.max(sell, notSell);
        }
    }
    
    int helperTab(int[] prices){
        int n = prices.length;
        int[][][] dp = new int[n + 1][2][3];

        for(int i = n - 1; i >= 0; i--){
            for(int buy = 0; buy <= 1; buy++){
                for(int cap = 1; cap <= 2; cap++){
                    //Buy
                    if(buy == 1){
                        //Invest in market and sell becomes 0 but cap remains as it is as without sell a transaction is not completed very imp
                        int take = -prices[i] + dp[i + 1][0][cap];
                        int notTake = 0 + dp[i + 1][1][cap];

                        dp[i][buy][cap] = Math.max(take, notTake);
                    }else{
                        //Sell adds the money from market and cap is reduced as txn is completed, make switch to buy again
                        int sell = +prices[i] + dp[i + 1][1][cap - 1];

                        //Sell still remains intact so does cap as transaction is not completed
                        int notSell = 0 + dp[i + 1][0][cap];

                        dp[i][buy][cap] = Math.max(sell, notSell);
                    }
                }
            }
        }

        return dp[0][1][2];
    }

    int helperSO(int[] prices){
        int n = prices.length;
        int[][] dpNext = new int[2][3];

        for(int i = n - 1; i >= 0; i--){
            int[][] dpCurr = new int[2][3];
            for(int buy = 0; buy <= 1; buy++){
                for(int cap = 1; cap <= 2; cap++){
                    //Buy
                    if(buy == 1){
                        //Invest in market and sell becomes 0 but cap remains as it is as without sell a transaction is not completed very imp
                        int take = -prices[i] + dpNext[0][cap];
                        int notTake = 0 + dpNext[1][cap];

                        dpCurr[buy][cap] = Math.max(take, notTake);
                    }else{
                        //Sell adds the money from market and cap is reduced as txn is completed, make switch to buy again
                        int sell = +prices[i] + dpNext[1][cap - 1];

                        //Sell still remains intact so does cap as transaction is not completed
                        int notSell = 0 + dpNext[0][cap];

                        dpCurr[buy][cap] = Math.max(sell, notSell);
                    }
                }
            }
            dpNext = dpCurr;
        }

        return dpNext[1][2];
    }

    int helperSSO(int[] prices){
        int n = prices.length;
        //There can be only 4 transaction
        int[] dpNext = new int[5];

        for(int i = n - 1; i >= 0; i--){
            int[] dpCurr = new int[5];
            for(int txnNo = 3; txnNo >= 0; txnNo--){
                //Buy - every even 
                if((txnNo & 1) == 0){
                    //Invest in market and sell becomes 0 but cap remains as it is as without sell a transaction is not completed very imp
                    int take = -prices[i] + dpNext[txnNo + 1];
                    int notTake = 0 + dpNext[txnNo];
                    
                    dpCurr[txnNo] = Math.max(take, notTake);
                }else{
                    //Sell adds the money from market and cap is reduced as txn is completed, make switch to buy again
                    int sell = +prices[i] + dpNext[txnNo + 1];

                    //Sell still remains intact so does cap as transaction is not completed
                    int notSell = 0 + dpNext[txnNo];

                    dpCurr[txnNo] = Math.max(sell, notSell);
                }
            }
            dpNext = dpCurr;
        }

        return dpNext[0]; // Start from transaction 0
    }
}
