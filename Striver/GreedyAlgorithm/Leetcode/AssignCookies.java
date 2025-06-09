package Striver.GreedyAlgorithm.Leetcode;

import java.util.Arrays;

public class AssignCookies{
    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int gPtr = 0, sPtr = 0;

        while(sPtr < s.length){
            if(g[gPtr] <= s[sPtr]){
                gPtr++;
            }
            sPtr++;
        }

        return gPtr;
    }
    public static void main(String[] args) {
        int[] g = {1,2,3};
        int[] s = {1,1};

        System.out.println(findContentChildren(g, s));
        // System.out.println("Hello World");
    }
}