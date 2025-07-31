package Striver.DynamicProgramming.LeetCode;

import java.util.Stack;

public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[] dp = new int[m];

        int maxi = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(matrix[i][j] == '1'){
                    dp[j] += 1;
                }else dp[j] = 0;
            }

            maxi = Math.max(maxi,largestRectangleHistogram(dp));
        }

        return maxi;
    }

    int largestRectangleHistogram(int[] histo){
        Stack<Integer> st = new Stack<>();
        int maxA = 0;

        int n = histo.length;

        for(int i = 0; i <= n; i++){
            while(!st.isEmpty() && (i == n || histo[st.peek()] >= histo[i])){
                int height = histo[st.pop()];
                int width;

                if(st.isEmpty()) width = i;
                else width = i - st.peek() - 1;

                maxA = Math.max(maxA, width*height);
            }

            st.push(i);
        }

        return maxA;
    }
}
