package Striver.DynamicProgramming.LeetCode;

import java.util.Arrays;

public class MinimumCostToCutAStick {
    public int minCost(int n, int[] cuts) {
        // ArrayList<Integer> cuts = new ArrayList<>(Arrays.asList(cuts));
        // cuts.add(n);
        // cuts.add(0);
        // Collections.sort(cuts);
        int m = cuts.length;
        int[] cutsModified = Arrays.copyOf(cuts, m + 2);

        //To get upper and lower bound
        cutsModified[m] = 0;
        //Now no need to carry n in function call as cuts have the lower and upper bound of the stick
        cutsModified[m + 1] = n;

        //If arrays are not sorted than we cannot split the problem as RHS will be dependant of LHS and vice versa
        Arrays.sort(cutsModified);

        // return helperRec(1, m, cutsModified);

        int[][] dp = new int[m + 1][m + 1];
        for(int[] d: dp) Arrays.fill(d, -1);

        // return helperMem(1, m, cutsModified, dp);
        return helperTab(n, cutsModified);
    }

    int helperRec(int i, int j, int[] cuts){
        if(i > j) return 0;

        int mini = Integer.MAX_VALUE;

        for(int ind = i; ind <= j; ind++){
            int currCost = cuts[j + 1] - cuts[i - 1];
            int leftCut = helperRec(i, ind - 1, cuts);
            int rightCut = helperRec(ind + 1, j, cuts);

            int totalCost = currCost + leftCut + rightCut;

            mini = Math.min(mini, totalCost);
        }

        return mini;
    }

    int helperMem(int i, int j, int[] cuts, int[][] dp){
        if(i > j) return 0;

        if(dp[i][j] != -1) return dp[i][j];
        int mini = Integer.MAX_VALUE;

        for(int ind = i; ind <= j; ind++){
            int currCost = cuts[j + 1] - cuts[i - 1];
            int leftCut = helperMem(i, ind - 1, cuts, dp);
            int rightCut = helperMem(ind + 1, j, cuts, dp);

            int totalCost = currCost + leftCut + rightCut;

            mini = Math.min(mini, totalCost);
        }

        return dp[i][j] = mini;
    }

    int helperTab(int n, int[] cuts){
        int m = cuts.length;
        
        int[][] dp = new int[m + 1][m + 1];

        //Adjust to original cuts array
        m = m - 2;
        for(int i = m; i >= 1; i--){
            for(int j = 1; j <= m; j++){
                if(i > j) continue;
                int mini = Integer.MAX_VALUE;

                for(int ind = i; ind <= j; ind++){
                    int currCost = cuts[j + 1] - cuts[i - 1];
                    int leftCut = dp[i][ind - 1];
                    int rightCut = dp[ind + 1][j];
                    int totalCost = currCost + leftCut + rightCut;
                    mini = Math.min(mini, totalCost);
                }
                dp[i][j] = mini;
            }
        }

        return dp[1][m];
    }


    public static void main(String[] args) {
        MinimumCostToCutAStick q= new MinimumCostToCutAStick();
        int[] cuts = {3, 5, 1, 4};
        int n = 7;
        System.out.println(q.minCost(n, cuts));
    }
}
