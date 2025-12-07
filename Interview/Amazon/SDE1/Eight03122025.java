package Interview.Amazon.SDE1;

import java.util.Arrays;

public class Eight03122025 {
	int[][][] dp;
	int getMinimumCost(int[] cost, int pairCost, int k){
		int n = cost.length;
		// return getMinimumCostHelper(0 , n - 1,cost, pairCost, k);

		dp = new int[n][n][k + 1];

		for(int[][] arr2 : dp){
			for(int[] arr1 : arr2)
				Arrays.fill(arr1, -1);
		}

		return getMinimumCostHelperDp(0, n - 1, cost, pairCost, k, dp);
	}

	private int getMinimumCostHelperDp(int left, int right, int[] cost, int pairCost, int k, int[][][] dp) {
		if(left > right) return 0;
		if(left == right) return cost[left];

		if(dp[left][right][k] != -1)return dp[left][right][k];

		//Take left
		int takeLeft = cost[left] + getMinimumCostHelperDp(left + 1, right, cost, pairCost, k, dp);
		//Take right
		int takeRight = cost[right] + getMinimumCostHelperDp(left, right - 1, cost, pairCost, k, dp);
		//Take pair
		int pair = Integer.MAX_VALUE;
		if(k > 0)
			pair = pairCost + getMinimumCostHelperDp(left + 1, right - 1, cost, pairCost, k - 1, dp);

		return dp[left][right][k] = Math.min(takeLeft, Math.min(takeRight, pair));
	}

	int getMinimumCostHelper(int left, int right, int[] cost, int pairCost, int k) {
		if(left > right) return 0;
		if(left == right) return cost[left];

		//Take left
		int takeLeft = cost[left] + getMinimumCostHelper(left + 1, right, cost, pairCost, k);
		//Take right
		int takeRight = cost[right] + getMinimumCostHelper(left, right - 1, cost, pairCost, k);
		//Take pair
		int pair = Integer.MAX_VALUE;
		if(k > 0)
			pair = pairCost + getMinimumCostHelper(left + 1, right - 1, cost, pairCost, k - 1);

		return Math.min(takeLeft, Math.min(takeRight, pair));

	}

	public static void main(String[] args) {
		System.out.println(new Eight03122025().getMinimumCost(new int[]{3, 8, 2, 6, 5,9}, 5, 2));
	}
}
