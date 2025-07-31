package Striver.DynamicProgramming.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSubset {
    //arr[i]%arr[j] == 0 or arr[j]%arr[i] == 0
    public List<Integer> largestDivisibleSubset(int[] nums) {
        //Basic logic in an sorted array [a, b, c] -> if b is divisible by a and c is divisible by b then c is automatically divisible by a.
        Arrays.sort(nums);
        //Now like the question -> longest increasing subseq we get longest divisible subseq where we just need to check if next number is divisible.
        return tablulationPrint(nums);
    }
    
    //TC - O(n*n) + O(n) But this solution is important if we want to trace back the alias
    List<Integer> tablulationPrint(int[] nums){
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
                if(nums[i] % nums[prev] == 0 && 1 + dp[prev] > dp[i]){
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
        List<Integer> LDS = new ArrayList<>();
        LDS.addLast(nums[lastIndex]);
        while(hash[lastIndex] != lastIndex){
            lastIndex = hash[lastIndex];
            LDS.addLast(nums[lastIndex]);
        }
        return LDS;
    }
}
