package Striver.TwoPointerAndSlidingWindow.LeetCode;

import java.util.Arrays;

public class LongestRepeatingCharacterReplacement {
    public static int characterReplacement(String s, int k) {
        int maxLen = 0;
        for(int i = 0; i < s.length(); i++){
            Character ch = s.charAt(i);
            int kForCh = k;
            int len = 1;
            for(int j = i + 1; j < s.length(); j++){
                if(s.charAt(j) != ch){
                    if(k == 0)break;
                    k--;
                    len++;
                }else{
                    len++;
                }
            }
            maxLen = Math.max(maxLen, len);
        }
        return maxLen;
    }
    // O(2N*26)
    public static int characterReplacementSW(String s, int k) {
        int maxLen = 0;
        int left = 0, right = 0;
        int maxFreq = 0;
        int[] map = new int[26];

        while(right < s.length()){
            map[s.charAt(right) - 'A']++;
            maxFreq = Math.max(maxFreq, map[s.charAt(right) - 'A']);
            
            while((right - left + 1) - maxFreq > k){
                map[s.charAt(left) - 'A']--;
                maxFreq = Arrays.stream(map).max().getAsInt();
                left  = left + 1;
            }

            if((right - left + 1) - maxFreq <= k)
                maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }
        return maxLen;
    }
    // This works coz we already have maxLen lets say 6 so reducing till 5 is enough so rather than fetching whole 3 which doesnt have previous element will try finding 5 capable first than 6 than 7. We can remove 26 fetching dependency as it doesn't favor our case 6 - 3 is already viable solution using 6 - 5 is of no use so keep it as it is
    public static int characterReplacementSWOptimum(String s, int k) {
        int maxLen = 0;
        int left = 0, right = 0;
        int maxFreq = 0;
        int[] map = new int[26];

        while(right < s.length()){
            map[s.charAt(right) - 'A']++;
            maxFreq = Math.max(maxFreq, map[s.charAt(right) - 'A']);
            
            if((right - left + 1) - maxFreq > k){
                map[s.charAt(left) - 'A']--;
                // maxFreq = Arrays.stream(map).max().getAsInt();
                left  = left + 1;
            }

            if((right - left + 1) - maxFreq <= k)
                maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }
        return maxLen;
    }
    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 2;
        System.out.println(characterReplacement(s, k));
    }
}
