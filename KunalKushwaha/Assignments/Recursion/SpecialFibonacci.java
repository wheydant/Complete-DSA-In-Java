package KunalKushwaha.Assignments.Recursion;

import java.util.Arrays;

public class SpecialFibonacci {
    static int helper(int a, int b, int n, int[] map){
        if(n == 0) return a;
        if(n == 1) return b;
        if(map[n] != -1) return map[n];
        return map[n] = helper(a, b, n - 1, map) ^ helper(a, b, n - 2, map);
    }
    static int specialFibonacci(int a, int b, int n){
        int[] map = new int[n + 1];
        Arrays.fill(map, -1);

        return helper(a, b, n, map);
    }
    public static void main(String[] args) {
        System.out.println(specialFibonacci(86, 77, 15));
        System.out.println(specialFibonacci(93, 35, 86));
    }
}
