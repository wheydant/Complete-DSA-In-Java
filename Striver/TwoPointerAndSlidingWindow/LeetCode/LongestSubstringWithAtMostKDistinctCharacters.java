package Striver.TwoPointerAndSlidingWindow.LeetCode;

import java.util.HashMap;

public class LongestSubstringWithAtMostKDistinctCharacters {
    static int solution(String s, int k){
        int longestSubString = 0;
        int left = 0;
        int right = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        while(right < s.length()){
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
            if(map.size() > k){
                map.put(s.charAt(left), map.get(s.charAt(left))- 1);
                if(map.get(s.charAt(left)) == 0){
                    map.remove(s.charAt(left));
                }
                left++;
            }
            if(map.size() <= k)
                longestSubString = Math.max(longestSubString, right - left + 1);
            right++;
        }
        return longestSubString;
    }
    public static void main(String[] args) {
        String s = "aaabbccd";
        int k = 2;
        System.out.println(solution(s, k));
    }
}
