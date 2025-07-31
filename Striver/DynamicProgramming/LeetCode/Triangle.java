package Striver.DynamicProgramming.LeetCode;

import java.util.Arrays;
import java.util.List;

//We can move down or right diagonal, start point is fixed but ending path may vary only reaching the last row matters.
public class Triangle {
    //Here we wont backtrack as no particular start.
    public int minimumTotal(List<List<Integer>> triangle) {
        // return helperRec(0, 0, triangle);
        int n = triangle.size();
        int[][] dp = new int[n][n];
        for(int[] arr: dp)Arrays.fill(arr, -1);
        // return helperMem(0, 0, triangle, dp);
        // return helperTab(triangle);
        return helperSO(triangle);
    }
    int helperRec(int i, int j, List<List<Integer>> triangle){
        if(i == triangle.size() - 1) return triangle.get(i).get(j);
        
        int down = triangle.get(i).get(j) + helperRec(i + 1, j, triangle);

        int diagonal = triangle.get(i).get(j) + helperRec(i + 1, j + 1, triangle);

        return Math.min(down, diagonal);
    }
    int helperMem(int i, int j, List<List<Integer>> triangle, int[][] dp){
        if(i == triangle.size() - 1) return triangle.get(i).get(j);
        
        if(dp[i][j] != -1) return dp[i][j];

        int down = triangle.get(i).get(j) + helperMem(i + 1, j, triangle, dp);

        int diagonal = triangle.get(i).get(j) + helperMem(i + 1, j + 1, triangle, dp);

        return dp[i][j] = Math.min(down, diagonal);
    }
    int helperTab(List<List<Integer>> triangle){
        int n = triangle.size();
        int[][] dp = new int[n][];

        //When going top to bottom tabulation switches to bottom to top
        for(int i = n - 1; i >= 0; i--){
            int m = triangle.get(i).size();
            dp[i] = new int[m];
            for(int j = m - 1; j >= 0; j--){
                if(i == n - 1){
                    dp[i][j] = triangle.get(i).get(j);
                    continue;
                }

                int down = triangle.get(i).get(j) + dp[i + 1][j];
                int diagonal = triangle.get(i).get(j) + dp[i + 1][j + 1];

                dp[i][j] = Math.min(down, diagonal);
            }
        }

        return dp[0][0];
    }
    int helperSO(List<List<Integer>> triangle){
        int n = triangle.size();
        int m = triangle.get(n - 1).size();

        //Its not prev its front
        int[] front = new int[m];

        for(int i = n - 1; i >= 0; i--){
            int[] curr = new int[m];
            //Max number of values in a row is i
            for(int j = i; j >= 0; j--){
                if(i == n - 1){
                    curr[j] = triangle.get(i).get(j);
                    continue;
                }

                int down = triangle.get(i).get(j) + front[j];
                int diagonal = triangle.get(i).get(j) + front[j + 1];

                curr[j] = Math.min(down, diagonal);
            }
            front = curr;
        }

        return front[0];
    }
}
