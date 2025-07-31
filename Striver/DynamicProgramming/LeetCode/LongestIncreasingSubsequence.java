package Striver.DynamicProgramming.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        //index -> 0 and prevInd -> -1
        int n = nums.length;
        // return helperRec(0, -1, nums, n);

        //prevInd starts with -1 we cannot store it thus one based indexing.
        int[][] dp = new int[n][n + 1];
        for(int[] d: dp) Arrays.fill(d, -1);
        // return helperMem(0, - 1, nums, n, dp);
        // return helperTab(nums);
        // return helperSO(nums);
        // return tablulation(nums);
        // return tablulationPrint(nums);
        return binarySearch(nums);
    }
    //TC - O(2^n) SC - O(n)
    int helperRec(int i, int prevI, int[] nums, int n){
        if(i == n) return 0;

        //PrevIndex remains same and the length is not added
        int notTake = 0 + helperRec(i + 1, prevI, nums, n);

        int take = Integer.MIN_VALUE;
        //Take
        if(prevI == -1 || nums[prevI] < nums[i]){
            //Current index becomes prevIndex and length increases by 1
            take = 1 + helperRec(i + 1, i, nums, n);
        }

        return Math.max(notTake, take);
    }
    //TC - O(n^n) SC - O(n*n) + O(n)
    int helperMem(int i, int prevI, int[] nums, int n, int[][] dp){
        if(i == n) return 0;

        if(dp[i][prevI + 1] != -1) return dp[i][prevI + 1];

        //PrevIndex remains same and the length is not added
        int notTake = 0 + helperMem(i + 1, prevI, nums, n, dp);

        int take = Integer.MIN_VALUE;
        //Take
        if(prevI == -1 || nums[prevI] < nums[i]){
            //Current index becomes prevIndex and length increases by 1
            take = 1 + helperMem(i + 1, i, nums, n, dp);
        }

        //will store ans not in dp[i][prevI] but in dp[i][prevI + 1]
        return dp[i][prevI + 1] = Math.max(notTake, take);
    }

    int helperTab(int[] nums){
        int n = nums.length;
        //As from n - 1 we are doing n + 1
        int[][] dp = new int[n + 1][n + 1];
        
        for(int ind = n - 1; ind >= 0; ind--){
            for(int prevInd = ind - 1; prevInd >= -1; prevInd--){
                //PrevIndex remains same and the length is not added.
                //While writing dp for prev it will always be +1
                int notTake = 0 + dp[ind + 1][prevInd + 1];

                int take = Integer.MIN_VALUE;
                //Take
                if(prevInd == -1 || nums[prevInd] < nums[ind]){
                    //Current index becomes prevIndex and length increases by 1
                    take = 1 + dp[ind + 1][ind + 1];
                }

                dp[ind][prevInd + 1] = Math.max(notTake, take);
            }
        }
        //dp for prev + 1
        return dp[0][-1 + 1];
    }

    int helperSO(int[] nums){
        int n = nums.length;
        //As from n - 1 we are doing n + 1
        int[] dpNext = new int[n + 1];
        
        for(int ind = n - 1; ind >= 0; ind--){
            int[] dpCurr = new int[n + 1];
            for(int prevInd = ind - 1; prevInd >= -1; prevInd--){
                //PrevIndex remains same and the length is not added.
                //While writing dp for prev it will always be +1
                int notTake = 0 + dpNext[prevInd + 1];

                int take = Integer.MIN_VALUE;
                //Take
                if(prevInd == -1 || nums[prevInd] < nums[ind]){
                    //Current index becomes prevIndex and length increases by 1
                    take = 1 + dpNext[ind + 1];
                }

                dpCurr[prevInd + 1] = Math.max(notTake, take);
            }

            dpNext = dpCurr;
        }
        //dp for prev + 1
        return dpNext[-1 + 1];
    }
    //TC - O(n*n) But this solution is important if we want to trace back the alias
    int tablulation(int[] nums){
        int n = nums.length;

        //dp[i] -> Signifies the longest increasing substring that ends at index i
        int dp[] = new int[n];
        //Even if  there is nothing before that element LIS of that element is going to be 1 including itself.
        Arrays.fill(dp, 1);
        int maxi = 1;

        for(int i = 0; i < n; i++){
            for(int prev = 0; prev < i; prev++){
                if(nums[prev] < nums[i]){
                    dp[i] = Math.max(dp[i], 1 + dp[prev]);
                }
            }
            maxi = Math.max(maxi, dp[i]);
        }

        return maxi;
    }    
    //TC - O(n*n) But this solution is important if we want to trace back the alias
    int tablulationPrint(int[] nums){
        int n = nums.length;

        //dp[i] -> Signifies the longest increasing substring that ends at index i
        int[] dp = new int[n];
        //Even if  there is nothing before that element LIS of that element is going to be 1 including itself.
        Arrays.fill(dp, 1);
        int maxi = 1;

        //For printing LIS. Hash will store the parent of that element
        int[] hash = new int[n];
        int lastIndex = 0;
        for(int i = 0; i < n; i++){
            //Initially the parent will be the element itself
            hash[i] = i;
            for(int prev = 0; prev < i; prev++){
                //For printing
                // if(nums[prev] < nums[i]){
                if(nums[prev] < nums[i] && 1 + dp[prev] > dp[i]){
                    // dp[i] = Math.max(dp[i], 1 + dp[prev]);
                    // If we are already checking we will definitely add it to dp[i]
                    dp[i] = 1 + dp[prev];
                    hash[i] = prev;
                }
            }
            if(dp[i] > maxi){
                maxi = Math.max(maxi, dp[i]);
                lastIndex = i;
            }
        }
        ArrayList<Integer> LIS = new ArrayList<>();
        LIS.addLast(nums[lastIndex]);
        while(hash[lastIndex] != lastIndex){
            lastIndex = hash[lastIndex];
            LIS.addLast(nums[lastIndex]);
        }
        // LIS.reversed();
        System.out.println(LIS);
        return maxi;
    }

    //Crazy logic - TC - N*LogN - Used only for getting length and not to print LIS
    int binarySearch(int[] nums){
        int n = nums.length;
        List<Integer> temp = new ArrayList<>();
        temp.add(nums[0]);
        int len = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > temp.get(temp.size() - 1)) {
                // arr[i] > the last element of temp array
                temp.add(nums[i]);
                len++;
            } else {
                // Replacement step
                int ind = Collections.binarySearch(temp, nums[i]);
                if (ind < 0) {
                    //Property of Collections.binarySearch
                    //If the search key is found in the list, the method returns the index of the key. 
                    // If the search key is not found, the method returns a negative value. This negative value can be used to determine the "insertion point" – specifically, (-(insertion point) - 1), where the insertion point is the index at which the key would be inserted to maintain the list's sorted order. 
                    ind = -ind - 1;
                }

                temp.set(ind, nums[i]);
            }
        }

        //Temp is not LIS
        return len;
    }
}
