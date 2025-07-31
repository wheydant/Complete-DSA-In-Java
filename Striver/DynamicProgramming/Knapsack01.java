package Striver.DynamicProgramming;
//Why Greedy Fails? Lack of uniformity - For less weight value is more for more wight value is less.

import java.util.Arrays;

public class Knapsack01 {
    static int knapsack(int[] wt, int[] val, int n, int W) {
        // return helperRec(n - 1, W, wt, val);
        int[][] dp = new int[n][W + 1];
        
        for(int[] d : dp) Arrays.fill(d, -1);
        // return helperMem(n - 1, W, wt, val, dp);
        // return helperTab(wt, val, n, W);
        // return helperSO(wt, val, n, W);
        return helperSOO(wt, val, n, W);
    }

    static int helperRec(int index, int w, int[] wt, int[] val){
        if(index == 0){
            if(wt[index] <= w) return val[index];
            else return 0;
        }

        //Not Take
        int notTake = 0 + helperRec(index - 1, w, wt, val);
        //Take
        int take = Integer.MIN_VALUE;
        if(wt[index] <= w)
            take = val[index] + helperRec(index - 1, w - wt[index], wt, val);
        
        return Math.max(take, notTake);
    }

    static int helperMem(int index, int w, int[] wt, int[] val, int[][] dp){
        if(index == 0){
            if(wt[index] <= w) return val[index];
            else return 0;
        }

        if(dp[index][w] != -1) return dp[index][w];

        //Not Take
        int notTake = 0 + helperRec(index - 1, w, wt, val);
        //Take
        int take = Integer.MIN_VALUE;
        if(wt[index] <= w)
            take = val[index] + helperRec(index - 1, w - wt[index], wt, val);
        
        return dp[index][w] = Math.max(take, notTake);
    }

    static int helperTab(int[] wt, int[] val, int n, int W){
        int[][] dp = new int[n][W + 1];

        //Another way to initialize the dp array where all the weights above wt[0] for first row will return value.
        // for(int w = wt[0]; w <= W; w++) dp[0][w] = val[0];

        for(int index = 0; index < n; index++){
            for(int w = 0; w <= W; w++){
                if(index == 0){
                    if(wt[index] <= w){
                        dp[index][w] = val[index];
                    }
                    continue;
                }

                int notTake = 0 + dp[index - 1][w];
                int take = Integer.MIN_VALUE;
                if(wt[index] <= w)
                    take = val[index] + dp[index - 1][w - wt[index]];

                dp[index][w] = Math.max(take, notTake);
            }
        }

        return dp[n - 1][W];
    }


    static int helperSO(int[] wt, int[] val, int n, int W){
        int[] dpPrev = new int[W + 1];
        //Another way to initialize the dp array where all the weights above wt[0] for first row will return value.
        for(int w = wt[0]; w <= W; w++) dpPrev[w] = val[0];

        for(int index = 1; index < n; index++){
            int[] dpCurr = new int[W + 1];
            for(int w = 0; w <= W; w++){

                int notTake = 0 + dpPrev[w];
                int take = Integer.MIN_VALUE;
                if(wt[index] <= w)
                    take = val[index] + dpPrev[w - wt[index]];

                dpCurr[w] = Math.max(take, notTake);
            }
            dpPrev = dpCurr;
        }

        return dpPrev[W];
    }

    static int helperSOO(int[] wt, int[] val, int n, int W){

        // As dependency is on index - 1 and wt or wt - 1;
        // So if we go from wt -> 0 we can use the values to LHS
        int[] dpSO = new int[W + 1];
        //Another way to initialize the dp array where all the weights above wt[0] for first row will return value.
        for(int w = wt[0]; w <= W; w++) dpSO[w] = val[0];

        for(int index = 1; index < n; index++){
            for(int w = W; w >= 0; w--){

                int notTake = 0 + dpSO[w];
                int take = Integer.MIN_VALUE;
                if(wt[index] <= w)
                    take = val[index] + dpSO[w - wt[index]];

                dpSO[w] = Math.max(take, notTake);
            }
        }

        return dpSO[W];
    }

    public static void main(String args[]) {
        int wt[] = {1, 2, 4, 5};
        int val[] = {5, 4, 8, 6};
        int W = 5;
        int n = wt.length;

        // Calculate and print the maximum value of items the thief can steal
        System.out.println("The Maximum value of items the thief can steal is " + knapsack(wt, val, n, W));
    }
}
