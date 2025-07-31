package Striver.DynamicProgramming;

import java.util.Arrays;

public class CountSubsetsWithSumK {
    static int findWays(int[] num, int k){
        int n = num.length;
        // return helperRec(n - 1, k, num);

        int[][] dp = new int[n][k + 1];
        for(int[] d : dp) Arrays.fill(d, -1);
        
        // return helperMem(n - 1, k, num, dp);
        // return helperTab(num, k);
        return helperSO(num, k);
    }

    //TC - O(2^n) SC -> O(n)
    static int helperRec(int i, int k, int[] num){
        if(k == 0) return 1;
        if(i == 0) return (num[i] == k)? 1:0;

        int notTake = helperRec(i - 1, k, num);
        int take = 0;
        if(k >= num[i]) take = helperRec(i - 1, k - num[i], num);

        return notTake + take;
    }

    //TC - O(n*sum) SC - O(n*sum) + O(n)
    static int helperMem(int i, int k, int[] num, int[][] dp){
        if(k == 0) return 1;
        if(i == 0) return (num[i] == k)? 1:0;

        /*
         * To Tackle 0 in array thing
         * Remove k == 0 thing as it is stopping us from fetching all the digits
         * if(i == 0){
         *  if(k == 0 && arr[0] == 0) return 2;
         *  if(k == 0 || sum == arr[0]) return 1;
         *  return 0;
         * }
        */

        if(dp[i][k] != -1) return dp[i][k];

        int notTake = helperRec(i - 1, k, num);
        int take = 0;
        if(k >= num[i]) take = helperRec(i - 1, k - num[i], num);

        return dp[i][k] = notTake + take;
    }

    static int helperTab(int[] num, int k){
        int n = num.length;
        int[][] dp = new int[n][k + 1];

        //Every k = 0 is true;
        for(int i = 0; i < n; i++) dp[i][0] = 1;

        if(k >= num[0]) dp[0][num[0]] = 1;

        System.out.println("Printing DP with initialization");
        System.out.println(Arrays.deepToString(dp));

        for(int i = 1; i < n; i++){
            for(int target = 1; target <= k; target++){
                int notTake = dp[i - 1][target];
                int take = 0;
                if(target >= num[i]) take =  dp[i - 1][target - num[i]];

                dp[i][target] = take + notTake;
            }
        }

        System.out.println("Printing Final DP");
        System.out.println(Arrays.deepToString(dp));
        return dp[n - 1][k];
    }
    static int helperSO(int[] num, int k){
        int n = num.length;
        int[] dpPrev = new int[k + 1];

        //Every k = 0 is true;
        dpPrev[0] = 1;

        if(k >= num[0]) dpPrev[num[0]] = 1;


        for(int i = 1; i < n; i++){
            int[] dpCurr = new int[k + 1];

            //This is important initialization
            // dpCurr[0] = 1;
            for(int target = 0; target <= k; target++){
                int notTake = dpPrev[target];
                int take = 0;
                if(target >= num[i]) take =  dpPrev[target - num[i]];

                dpCurr[target] = take + notTake;
            }

            dpPrev = dpCurr;
        }

        return dpPrev[k];
    }

    public static void main(String args[]) {
        int arr[] = {1, 2, 2, 3};
        int k = 3;
        //It wont work for {0, 0 , 1} as our logic will return 1 but actual ans is 4

        // -> To solve this calculate number of zero and just add pow(2, n) * ans

        // Calculate and print the number of subsets that sum up to k
        System.out.println("The number of subsets found are " + findWays(arr, k));
    }
}
