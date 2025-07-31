package Striver.DynamicProgramming.LeetCode;

import java.util.Arrays;

public class BestTimeToBuyAndSellIV {
    public int maxProfit(int k, int[] prices) {
        //Will solve this keeping track of transactions
        // return helperRec(0, 0, prices, prices.length, k);
        
        int[][] dp = new int[prices.length][2*k + 1];
        for(int[] d:dp)Arrays.fill(d, -1);
        // return helperMem(0, 0, prices, prices.length, k, dp);

        // return helperTab(prices, k);
        return helperSO(prices, k);
    }

    int helperRec(int i, int txnNo, int[] prices, int n, int k){
        if(i == n || txnNo == 2*k) return 0;

        //Even we buy
        if(txnNo % 2 == 0){
            return Math.max( -prices[i] + helperRec(i + 1, txnNo + 1, prices, n, k), 0 + helperRec(i + 1, txnNo, prices, n, k));
        }
        //Sell
        return Math.max(+prices[i] + helperRec(i + 1, txnNo + 1, prices, n, k), 0 + helperRec(i + 1, txnNo, prices, n, k));
    }

    int helperMem(int i, int txnNo, int[] prices, int n, int k, int[][] dp){
        if(i == n || txnNo == 2*k) return 0;

        if(dp[i][txnNo] != -1) return dp[i][txnNo];
        //Even we buy
        if(txnNo % 2 == 0){
            return dp[i][txnNo] = Math.max( -prices[i] + helperMem(i + 1, txnNo + 1, prices, n, k, dp), 0 + helperMem(i + 1, txnNo, prices, n, k, dp));
        }
        //Sell
        return dp[i][txnNo] = Math.max(+prices[i] + helperMem(i + 1, txnNo + 1, prices, n, k, dp), 0 + helperMem(i + 1, txnNo, prices, n, k, dp));
    }

    int helperTab(int[] prices, int k){
        int[][] dp = new int[prices.length + 1][2*k + 1];
        for(int i = prices.length - 1; i >= 0; i--){
            for(int txnNo = 2*k - 1; txnNo >= 0; txnNo--){
                if(txnNo % 2 == 0){
                    dp[i][txnNo] = Math.max( -prices[i] + dp[i + 1][txnNo + 1], 0 + dp[i + 1][txnNo]);
                }else{
                    dp[i][txnNo] = Math.max(+prices[i] + dp[i + 1][txnNo + 1], 0 + dp[i + 1][txnNo]);                
                }
            }
        }

        return dp[0][0];
    }

    int helperSO(int[] prices, int k){
        int[] dpNext = new int[2*k + 1];
        for(int i = prices.length - 1; i >= 0; i--){
            int[] dpCurr = new int[2*k + 1];
            for(int txnNo = 2*k - 1; txnNo >= 0; txnNo--){
                if(txnNo % 2 == 0){
                    dpCurr[txnNo] = Math.max( -prices[i] + dpNext[txnNo + 1], 0 + dpNext[txnNo]);
                }else{
                    dpCurr[txnNo] = Math.max(+prices[i] + dpNext[txnNo + 1], 0 + dpNext[txnNo]);                
                }
            }
            dpNext = dpCurr;
        }

        return dpNext[0];
    }
}
