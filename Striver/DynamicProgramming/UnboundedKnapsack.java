package Striver.DynamicProgramming;

import java.util.Arrays;

public class UnboundedKnapsack {
    
    static int unboundedKnapsack(int n, int W, int[] val, int[] wt) {
        // return helperRec(n - 1, W, val, wt);
        
        int[][] dp = new int[n][W + 1];
        for(int[] d: dp) Arrays.fill(d, -1);
        // return helperMem(n - 1, W, val, wt, dp);
        // return helperTab(n, W, val, wt);
        return helperSO(n, W, val, wt);
    }

    static int helperRec(int index, int W, int[] val, int[] wt){
        if(index == 0){
            //Imp Case
            int count = W/wt[index];
            return count * val[index];
        }

        int notTake = helperRec(index - 1, W, val, wt);

        int take = Integer.MIN_VALUE;
        if(W >= wt[index])
            //Infinite supply index remains the same
            take = val[index] + helperRec(index, W - wt[index], val, wt);

        return Math.max(take, notTake);
    }

    static int helperMem(int index, int W, int[] val, int[] wt, int[][] dp){
        if(index == 0){
            //Imp Case
            int count = W/wt[index];
            return count * val[index];
        }

        if(dp[index][W] != -1) return dp[index][W];
        int notTake = helperRec(index - 1, W, val, wt);

        int take = Integer.MIN_VALUE;
        if(W >= wt[index])
            //Infinite supply index remains the same
            take = val[index] + helperRec(index, W - wt[index], val, wt);

        return dp[index][W] = Math.max(take, notTake);
    }

    static int helperTab(int n, int W, int[] val, int[] wt){

        int[][] dp = new int[n][W + 1];

        for(int i = 0; i < n; i++){
            for(int w = 0; w <= W; w++){
                if(i == 0){
                    int count = w/wt[i];
                    dp[i][w] = count * val[i];
                    continue;
                }

                int notTake = dp[i - 1][w];

                int take = Integer.MIN_VALUE;
                if(w >= wt[i])
                    take = val[i] + dp[i][w - wt[i]];

                dp[i][w] = Math.max(notTake, take);
            }
        }

        System.out.println(Arrays.deepToString(dp));
        return dp[n - 1][W];
    }

    static int helperSO(int n, int W, int[] val, int[] wt){

        int[] dpPrev = new int[W + 1];

        for(int i = 0; i < n; i++){
            int[] dpCurr = new int[W + 1];
            for(int w = 0; w <= W; w++){
                if(i == 0){
                    int count = w/wt[i];
                    dpCurr[w] = count * val[i];
                    continue;
                }

                int notTake = dpPrev[w];

                int take = Integer.MIN_VALUE;
                if(w >= wt[i])
                    take = val[i] + dpCurr[w - wt[i]];

                dpCurr[w] = Math.max(notTake, take);
            }

            dpPrev = dpCurr;
        }

        return dpPrev[W];
    }

    public static void main(String args[]) {
        int wt[] = { 2, 4, 6 };
        int val[] = { 5, 11, 13 };
        int W = 10;

        int n = wt.length;

        // Call the unboundedKnapsack function and print the result
        System.out.println("The Maximum value of items, the thief can steal is " + unboundedKnapsack(n, W, val, wt));
    }
}
