package Striver.DynamicProgramming.LeetCode;

import java.util.Arrays;
import java.util.Comparator;

public class LongestStringChain {
    Comparator<String> strComparator = (s1, s2) -> s1.length() - s2.length();
    public int longestStrChain(String[] words) {
        //Sorting arr is required to comprehend proper order of comparison
        Arrays.sort(words, strComparator);

        return tabulation(words);
    }

    boolean compare(String s1, String s2){
        //If length is not just more than one than skip
        if (s1.length() != s2.length() + 1) {
            return false;
        }

        int first = 0;
        int second = 0;

        while (first < s1.length()) {
            //While second is less than s2 and chars are matching
            if (second < s2.length() && s1.charAt(first) == s2.charAt(second)) {
                first++;
                second++;
            } else {
                //If char first doesn't match we can push it forward by one
                //one case abcd, abc -> first has not reached end but second has thus we still push first
                first++;
            }
        }

        //If both reached the end its a valid chain
        return first == s1.length() && second == s2.length();
    }

    //TC - O(n*n) But this solution is important if we want to trace back the alias
    int tabulation(String[] words){
        int n = words.length;

        //dp[i] -> Signifies the longest increasing substring that ends at index i
        int dp[] = new int[n];
        //Even if  there is nothing before that element LIS of that element is going to be 1 including itself.
        Arrays.fill(dp, 1);
        int maxi = 1;

        for(int i = 0; i < n; i++){
            for(int prev = 0; prev < i; prev++){
                if(compare(words[i], words[prev]) && 1 + dp[prev] > dp[i]){
                    dp[i] =  1 + dp[prev];
                }
            }
            maxi = Math.max(maxi, dp[i]);
        }

        return maxi;
    } 
}
