package Striver.DynamicProgramming;

public class LongestBitonicSubsequence{
    // Bitonic Sequence can be just increasing or just decreasing or increasing than decreasing
    static int longestBitonicSequence(int[] arr, int n){
        int[] dpOrder = new int[n];

        for(int i = 0; i < n; i++){
            dpOrder[i] = 1;
            for(int prev = 0; prev < i; prev++){
                if(arr[prev] < arr[i])
                    dpOrder[i] = Math.max(dpOrder[i], 1 + dpOrder[prev]);
            }
        }

        int[] dpRev = new int[n];
        for(int i = n - 1; i >= 0; i--){
            dpRev[i] = 1;
            for(int next = n - 1; next > i; next--){
                if(arr[next] < arr[i])
                    dpRev[i] = Math.max(dpRev[i], 1 + dpRev[next]);
            }
        }

        int maxi = -1;

        for(int i = 0; i < n; i++){
            maxi = Math.max(maxi, dpOrder[i] + dpRev[i] - 1);
        }

        return maxi;
    }
    public static void main(String[] args) {
        int arr[] = {1, 11, 2, 10, 4, 5, 2, 1};
        int n = arr.length;

        System.out.println("The length of the longest bitonic subsequence is " +
                longestBitonicSequence(arr, n));
    }
}