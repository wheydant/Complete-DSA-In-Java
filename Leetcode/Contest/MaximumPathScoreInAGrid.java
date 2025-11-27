package Leetcode.Contest;

public class MaximumPathScoreInAGrid {

    int m,n,K;
    int[][] grid;
    int[][][] dp;
    int helperSol(int i, int j, int cost){
        //EdgeCase
        if(i >= m || j >= n) return Integer.MIN_VALUE;

		// System.out.println(i + " " + j);
        int currScore = grid[i][j];
        int currCost = cost + ((currScore > 0) ? 1:0);
        if(currCost > K) return Integer.MIN_VALUE;

        //Base Case
        if(i == m - 1 && j == n - 1){
            return (currCost <= K) ? currScore:Integer.MIN_VALUE;
        }

        //Memoization
        if(dp[i][j][currCost] != Integer.MIN_VALUE) return Integer.MIN_VALUE;
        //move right;
        int right = helperSol(i, j + 1, currCost);
        //move down;
        int down = helperSol(i + 1, j, currCost);

        int best = Math.max(right, down);
        if(best == Integer.MIN_VALUE)
            dp[i][j][currCost] = Integer.MIN_VALUE;
        else
            dp[i][j][currCost] = currScore + best;

        return dp[i][j][currCost];
        
    }
    public int maxPathScoreSol(int[][] grid, int k) {
        this.m = grid.length;
        this.n = grid[0].length;
        this.K = k;
        this.grid = grid;
        dp = new int[m][n][k + 1];
		for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int l = 0; l <= k; l++) {
                    dp[i][j][l] = Integer.MIN_VALUE;
                }
            }
        }
        int ans = helperSol(0, 0, 0);
        return (ans == Integer.MIN_VALUE)? -1 :ans;
    }

    void helper(int i, int j, int l, int k, int score, int[][] grid, int m, int n, int[] ans){

		if(i == m - 1 && j == n - 1){
			int currScore = grid[i][j];
			if(currScore > 0){
				score += currScore;
				l++;
			}
			if(l <= k){
				ans[0] = Math.max(ans[0], score);
			}
		}

        if(l > k || i > m - 1 || j > n - 1) return;

		System.out.println(i + " " + j);
        
        int currScore = grid[i][j];
        int currCost = (currScore > 0) ? 1:0;
        
        //move right;
        if(j < n){
            helper(i, j + 1, l + currCost, k, score + currScore, grid, m, n, ans);
        }
        //move down;
        if(i < m){
            helper(i + 1, j, l + currCost, k, score + currScore, grid, m, n, ans);
        }
    }
    public int maxPathScore(int[][] grid, int k) {
        int[] ans = {Integer.MIN_VALUE};
        int m = grid.length;
        int n = grid[0].length;
        helper(0, 0, 0, k, 0, grid, m, n, ans);
        return (ans[0] == Integer.MIN_VALUE)? -1:ans[0];
    }
	public static void main(String[] args) {
		System.out.println(new MaximumPathScoreInAGrid().maxPathScoreSol(new int[][]{{0, 1},{2,0}}, 1));
	}
}
