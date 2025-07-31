package Striver.DynamicProgramming;

import java.util.Arrays;

public class MatrixChainMultiplication {
    static int matrixMultiplication(int[] arr, int N){
        //Array will run from ending dimension
        // return helperRec(1, N - 1, arr);

        int[][] dp = new int[N][N];
        for(int[] d: dp)Arrays.fill(d, -1);
        
        // return helperMem(1, N - 1, arr, dp);
        return helperTab(arr, N);
    }
    //TC - O(exponential)
    static int helperRec(int i, int j, int[] arr){
        //Partition logic
        //When there is only one matrix no need of any operation
        if(i == j) return 0;

        int mini = Integer.MAX_VALUE;
        //try out all the partitions k will move from i -> j - 1 or i + 1 -> j
        for(int k = i; k < j; k++){
            //10, 20, 30, 40, 50 -> k = 2 -> [10, 20, 30] [40, 50] ie. [A * B]10x30*[C * D]40x50 => currMulti => 10*30*50
            int currMulti = arr[i - 1] * arr[k] * arr[j];
            int leftBlock = helperRec(i, k, arr);
            int rightBlock = helperRec(k + 1, j, arr);
            int operations = leftBlock + currMulti + rightBlock;

            mini = Math.min(mini, operations);
        }

        return mini;
    }

    //TC - O(n*n)*n as in every time loop runs i.e. O(n*n*n)
    static int helperMem(int i, int j, int[] arr, int[][] dp){
        //Partition logic
        //When there is only one matrix no need of any operation
        if(i == j) return 0;

        if(dp[i][j] != -1) return dp[i][j];
        int mini = Integer.MAX_VALUE;
        //try out all the partitions k will move from i -> j - 1 or i + 1 -> j
        for(int k = i; k < j; k++){
            //10, 20, 30, 40, 50 -> k = 2 -> [10, 20, 30] [40, 50] ie. [A * B]10x30*[C * D]40x50 => currMulti => 10*30*50
            int currMulti = arr[i - 1] * arr[k] * arr[j];
            int leftBlock = helperMem(i, k, arr, dp);
            int rightBlock = helperMem(k + 1, j, arr, dp);
            int operations = leftBlock + currMulti + rightBlock;

            mini = Math.min(mini, operations);
        }

        return dp[i][j] = mini;
    }

    static int helperTab(int[] arr, int N){
        int[][] dp = new int[N][N];

        for(int i = 0; i < N; i++)dp[i][i] = 0;

        for(int i = N - 1; i > 0; i--){
            //This doesn't work as j is always to the right of i so we need some base to calculate j -> i + 1 to N - 1
            // for(int j = 1; j < N; j++)
            for(int j = i + 1; j < N; j++){
                int mini = Integer.MAX_VALUE;
                for(int k = i; k < j; k++){
                    //10, 20, 30, 40, 50 -> k = 2 -> [10, 20, 30] [40, 50] ie. [A * B]10x30*[C * D]40x50 => currMulti => 10*30*50
                    int currMulti = arr[i - 1] * arr[k] * arr[j];
                    int leftBlock = dp[i][k];
                    int rightBlock = dp[k + 1][j];
                    int operations = leftBlock + currMulti + rightBlock;

                    mini = Math.min(mini, operations);
                }
                dp[i][j] = mini;
            }
        }

        return dp[1][N - 1];
    }

    //This can't be further optimized as dp[k + 1] is dependant on multiple rows

    public static void main(String args[]) {
        //This array represents dimension of n - 1 matrix
        //A - 10x20, B - 20x30, C - 30x40, D - 40x50
        int arr[] = {10, 20, 30, 40, 50};
        
        int n = arr.length;
        
        System.out.println("The minimum number of operations are "+
            matrixMultiplication(arr,n));
        
    }
}
