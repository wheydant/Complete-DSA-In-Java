package KunalKushwaha.Assignments.Recursion;

import java.util.Arrays;

// Input : A = {1, 2, 3, 4, 5}
// Output : [48]
//          [20, 28] 
//          [8, 12, 16] 
//          [3, 5, 7, 9] 
//          [1, 2, 3, 4, 5] 

// Explanation :
// Here,   [48]
//         [20, 28] -->(20 + 28 = 48)
//         [8, 12, 16] -->(8 + 12 = 20, 12 + 16 = 28)
//         [3, 5, 7, 9] -->(3 + 5 = 8, 5 + 7 = 12, 7 + 9 = 16)
//         [1, 2, 3, 4, 5] -->(1 + 2 = 3, 2 + 3 = 5, 3 + 4 = 7, 4 + 5 = 9)

public class SumTriangleFromArray{
    public static void helper(int[] arr, int n){
        if(n == 0) return;
        int[] ans = new int[n - 1];
        for(int i = 0; i < n - 1; i++){
            ans[i] = arr[i] + arr[i + 1];
        }
        System.out.println(Arrays.toString(ans));

        helper(ans, ans.length);
    }
    public static void printTriangle(int[] A){
        if(A.length == 1)return;
        int n = A.length;
        int[] ans = new int[n - 1];
        for(int i = 0; i < n - 1; i++){
            ans[i] = A[i] + A[i + 1];
        }
        printTriangle(ans);
        System.out.println(Arrays.toString(ans));
    }
    public static void main(String[] args) {
        printTriangle(new int[]{1, 2, 3, 4, 5});
    }
}