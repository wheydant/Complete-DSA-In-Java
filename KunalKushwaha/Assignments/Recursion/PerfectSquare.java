package KunalKushwaha.Assignments.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PerfectSquare {
    int leastNumSquareMyLogic(List<Integer> possibleSquares, int count, int sum, int n, int i){
        if (sum > n) return Integer.MAX_VALUE;
        if(sum == n) return count;
        if(i >= possibleSquares.size()) return Integer.MAX_VALUE;

        //Not Take
        int notTakeCount = leastNumSquareMyLogic(possibleSquares, count, sum, n, i + 1);
        //Take
        int takeCount = leastNumSquareMyLogic(possibleSquares, count + 1, sum + possibleSquares.get(i), n, i);

        return Math.min(notTakeCount, takeCount);
    }
    public int numSquaresMyLogic(int n) {
        List<Integer> possibleSquares = new ArrayList<>();
        for(int i = (int)Math.sqrt(n); i > 0; i++){
            possibleSquares.add(i*i);
        }
        int ans = leastNumSquareMyLogic(possibleSquares, 0, 0,n, 0);
        return (ans == Integer.MAX_VALUE) ? 0 : ans;
    }

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        int count = 1;
        while (count * count <= n) {
            int sq = count * count;
            for (int i = sq; i <= n; i++) {
                dp[i] = Math.min(dp[i - sq] + 1, dp[i]);
            }
            count++;
        }
        return dp[n];
    }
}
