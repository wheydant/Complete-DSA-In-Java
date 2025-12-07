package Interview.Amazon.SDE1;

import java.util.Arrays;

public class Fifteen03122025 {
	int[][] minDP, maxDP;
	int[] cost;
	int n;
	int[] ans;
	int[] findPartitonCost(int[] cost, int k){
		ans = new int[2];
		ans[0] = Integer.MAX_VALUE;
		ans[1] = Integer.MIN_VALUE;
		// findPartitonCostHelper(0, k, 0, cost);

		this.cost = cost;
		this.n = cost.length;

		minDP = new int[n + 1][k + 1];
		maxDP = new int[n + 1][k + 1];

		for(int[] row: minDP) Arrays.fill(row, -1);
		for(int[] row: maxDP) Arrays.fill(row, -1);

		int minAns = dfsMin(0, k);
		int maxAns = dfsMax(0, k);

		return new int[]{minAns, maxAns};
		// return ans;
	}
	//To apply DP we need to return int.
	void findPartitonCostHelper(int i,int k, int currCost, int[] cost){
		if(i == cost.length){
			if(k == 0){
				ans[0] = Math.min(ans[0], currCost);
				ans[1] = Math.max(ans[1], currCost);
			}
			return;
		}
		if(k <= 0){
			return;
		}

		for(int j = i; j < cost.length; j++){
			int tempCost = cost[i] + cost[j];
			findPartitonCostHelper(j + 1, k - 1,currCost + tempCost, cost);
		}
	}
	int dfsMin(int i, int k){
		if(k == 0 && i == n) return 0;
		if(k == 0 || i == n) return Integer.MAX_VALUE/2;

		if(minDP[i][k] != -1) return minDP[i][k];

		int best = Integer.MAX_VALUE/2;

		for(int j = i; j < n; j++){
			int segCost = cost[i] + cost[j];
			int next = dfsMin(j + 1, k - 1);
			best = Math.min(best ,segCost+ next);
		}

		return best;
	}
	int dfsMax(int i, int k){
		if(k == 0 && i == n) return 0;
		if(k == 0 || i == n) return Integer.MIN_VALUE/2;

		if(maxDP[i][k] != -1) return maxDP[i][k];

		int best = Integer.MIN_VALUE/2;

		for(int j = i; j < n; j++){
			int segCost = cost[i] + cost[j];
			int next = dfsMax(j + 1, k - 1);
			best = Math.max(best ,segCost + next);
		}

		return best;
	}
	public static void main(String[] args) {
		System.out.println(Arrays.toString(new Fifteen03122025().findPartitonCost(new int[]{1, 2, 3, 2, 5}, 3)));
	}
}
