package Striver.TwoPointerAndSlidingWindow.LeetCode;

import java.util.Arrays;
import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharachters{
    //TC = O(n^2)
    //SC = O(256)
    public static int lengthOfLongestSubstring(String s) {
        int maxLen = 0;

        for (int i = 0; i < s.length(); i++) {
            boolean[] visited = new boolean[256];
            int len = 0;

            for (int j = i; j < s.length(); j++) {
                if (visited[s.charAt(j)]) {
                    break;
                } else {
                    visited[s.charAt(j)] = true;
                    len++;
                }
            }

            maxLen = Math.max(maxLen, len);
        }

        return maxLen;
    }
    //Sliding Window TC - O(N*Log(N)) coz of hashMap
        public static int lengthOfLongestSubstringSW(String s) {
        int maxLen = 0;
        int left = 0;

        HashMap<Character, Integer> map = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {
            char current = s.charAt(right);

            if (map.containsKey(current)) {
                // Move left only forward
                left = Math.max(map.get(current) + 1, left);
            }

            map.put(current, right);

            int len = right - left + 1;
            if (len > maxLen) {
                maxLen = len;
            }
        }

        return maxLen;
    }
    //Optimized O(n)
    public static int lengthOfLongestSubstringSWOpti(String s) {
        int maxLen = 0;
        int left = 0;

        int[] map = new int[256];
        Arrays.fill(map, -1); 

        for (int right = 0; right < s.length(); right++) {
            char current = s.charAt(right);

            if (map[current] != -1) {
                // Move left only forward
                left = Math.max(map[current] + 1, left);
            }

            map[current] = right;

            int len = right - left + 1;
            if (len > maxLen) {
                maxLen = len;
            }
        }

        return maxLen;
    }
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }
}