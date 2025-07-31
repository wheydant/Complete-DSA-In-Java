package Striver.DynamicProgramming;

//Length of rod is given and cost for each part is given try to get maximum cost. Any number of pieces can be cut.

import java.util.Arrays;

public class RodCuttingProblemI {
    //Instead of cutting we will make the logic inverse collect the weight and make rod of length n
	public static int cutRod(int price[], int n) {
		// Write your code here.
        // return helperRec(n - 1, n, price);
        int[][] dp = new int[n][n + 1];
        for(int[] d:dp) Arrays.fill(d, -1);
        // return helperMem(n - 1, n, price, dp);

        // return helperTab(price, n);
        return helperSO(price, n);
	}

    static int helperRec(int i, int n, int[] price){
        if(i == 0){
            //As last part has length of 1 so we will need to cut the rod in n parts
            return n*price[i];
        }

        int notTake = 0 + helperRec(i - 1, n, price);
        int length = i + 1;
        int take = Integer.MIN_VALUE;
        if(length <= n)
            // We can cut the rod into same length any number of times.
            take = price[i] + helperRec(i, n - length, price);

        return Math.max(take, notTake);
    }

    static int helperMem(int i, int n, int[] price, int[][] dp){
        if(i == 0){
            //As last part has length of 1 so we will need to cut the rod in n parts
            return n*price[i];
        }

        if(dp[i][n] != -1) return dp[i][n];

        int notTake = 0 + helperMem(i - 1, n, price, dp);
        int length = i + 1;
        int take = Integer.MIN_VALUE;
        if(length <= n)
            // We can cut the rod into same length any number of times.
            take = price[i] + helperMem(i, n - length, price, dp);

        return dp[i][n] = Math.max(take, notTake);
    }

    static int helperTab(int price[], int N){
        int[][] dp = new int[N][N + 1];

        for(int i = 0; i < N; i++){
            for(int n = 0; n <= N; n++){
                if(i == 0){
                    dp[i][n] = n*price[i];
                    continue;
                }

                int notTake = 0 + dp[i - 1][n];
                int length = i + 1;
                int take = Integer.MIN_VALUE;
                if(length <= n)
                    // We can cut the rod into same length any number of times.
                    take = price[i] + dp[i][n - length];

                dp[i][n] = Math.max(take, notTake);
            }
        }

        // System.out.println(Arrays.deepToString(dp));

        return dp[N - 1][N];
    }

    static int helperSO(int price[], int N){
        int[] dpPrev = new int[N + 1];

        for(int i = 0; i < N; i++){
            int[] dpCurr = new int[N + 1];
            for(int n = 0; n <= N; n++){
                if(i == 0){
                    dpCurr[n] = n*price[i];
                    continue;
                }

                int notTake = 0 + dpPrev[n];
                int length = i + 1;
                int take = Integer.MIN_VALUE;
                if(length <= n)
                    // We can cut the rod into same length any number of times.
                    take = price[i] + dpCurr[n - length];

                dpCurr[n] = Math.max(take, notTake);
            }

            dpPrev = dpCurr;
        }

        // System.out.println(Arrays.deepToString(dp));

        return dpPrev[N];
    }

    public static void main(String args[]) {
        int price[] = { 2, 5, 7, 8, 10 };

        int n = price.length;

        System.out.println("The Maximum value by cutting, the steel rod " + cutRod(price, n));
    }
}
