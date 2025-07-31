package Striver.DynamicProgramming;

import java.util.Arrays;

public class CountPartitionsWithGivenDifference {
    static int countPartitions(int d,int[] arr){
        int sum = 0;
        for(int num : arr) sum += num;

        if(sum - d < 0 || ((sum - d) & 1 )== 1) return -1;

        
        int n = arr.length;
        int target = (sum - d)/2;

        System.out.println("Modified sum " + target);

        int[][] dp = new int[n][target + 1];
        for(int[] dpArr : dp) Arrays.fill(dpArr, -1);

        // return helperMem(n - 1, target, arr, dp);
        return helperTab(arr, target);
        // return helperSO(arr, target);
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
        // if(k == 0) return 1;
        // if(i == 0) return (num[i] == k)? 1:0;

    
        // To Tackle 0 in array thing
        // Remove k == 0 thing as it is stopping us from fetching all the digits
        if(i == 0){
            if(k == 0 && num[0] == 0) return 2;
            if(k == 0 || k == num[0]) return 1;
            return 0;
        }


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
        // for(int i = 0; i < n; i++) dp[i][0] = 1;

        //To tackle 0 in array 
        if(num[0] == 0){
            //At 0 sum 0 and number is also 0 its 2
            dp[0][0] = 2;
        }else{
            //Else normal for all target 0 at 0th position its possible
            dp[0][0] = 1;
        }

        //This will also fail coz if at num[0] its 0 it will reset the value to 1 which is supposed to be 2
        if(num[0] != 0 && k >= num[0]) dp[0][num[0]] = 1;

        System.out.println("Printing DP with initialization");
        System.out.println(Arrays.deepToString(dp));

        for(int i = 1; i < n; i++){
            for(int target = 0; target <= k; target++){
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
        // dpPrev[0] = 1;

        // if(k >= num[0]) dpPrev[num[0]] = 1;

        //To tackle 0 in array 
        if(num[0] == 0){
            //At 0 sum 0 and number is also 0 its 2
            dpPrev[0] = 2;
        }else{
            //Else normal for all target 0 at 0th position its possible
            dpPrev[0] = 1;
        }

        //This will also fail coz if at num[0] its 0 it will reset the value to 1 which is supposed to be 2
        if(num[0] != 0 && k >= num[0]) dpPrev[num[0]] = 1;

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

        int arr[] = {5,2,6,4};
        int d=3;
                                        
        System.out.println("The number of subsets found are "+countPartitions(d,arr));
    }
}
