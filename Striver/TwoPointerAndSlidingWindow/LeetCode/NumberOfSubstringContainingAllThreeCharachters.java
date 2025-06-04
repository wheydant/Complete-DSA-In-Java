package Striver.TwoPointerAndSlidingWindow.LeetCode;

import java.util.Arrays;

public class NumberOfSubstringContainingAllThreeCharachters {
    //Simple Optimization as all the rest of the substring will be ans.
    public static int numberOfSubstrings(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            boolean hasA = false, hasB = false, hasC = false;

            for (int j = i; j < s.length(); j++) {
                char ch = s.charAt(j);
                if (ch == 'a') hasA = true;
                if (ch == 'b') hasB = true;
                if (ch == 'c') hasC = true;

                if (hasA && hasB && hasC) {
                    count += s.length() - j; // all substrings from i to end are valid
                    break;
                }
            }
        }

        return count;
    }
    //Crazy logic
    public static int numberOfSubstringsSW(String s) {
        int count = 0;
        int[] lastSeen = new int[3];
        Arrays.fill(lastSeen, -1);
        for(int i = 0; i < s.length(); i++){
            lastSeen[s.charAt(i) - 'a'] = i;
            //Can even omit this if coz if not encountered than min will be -1 which cancels with 1
            //if(lastSeen[0] != -1 && lastSeen[1] != -1 && lastSeen[2] != -1){
                count = count + (1 + Math.min(lastSeen[0], Math.min(lastSeen[1], lastSeen[2])));
            //}
        }

        return count;
    }
    public static void main(String[] args) {
        String s = "abcabc";
    }
}
