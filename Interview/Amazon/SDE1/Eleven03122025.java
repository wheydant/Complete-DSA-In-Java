package Interview.Amazon.SDE1;

import java.util.Arrays;

public class Eleven03122025 {
	int[] dp;

	int findMaximumBalancedShipments(int[] w) {
		// int ans = findMaximumBalancedShipmentsHelper(0, w);
		int n = w.length;
		dp = new int[n + 1];
		// initialize dp with impossible values
		Arrays.fill(dp, Integer.MIN_VALUE);
		// int ans = findMaximumBalancedShipmentsHelperDP(0, w);
		// Zero because Descending order parcel
		// return Math.max(ans, 0);

		dp[n] = 0; // base case

		for (int i = n - 1; i >= 0; i--) {
			int max = w[i];
			int best = Integer.MIN_VALUE;

			for (int j = i + 1; j < n; j++) {
				max = Math.max(max, w[j]);
				int last = w[j];

				if (max > last) {
					best = Math.max(best, 1 + dp[j + 1]);
				}
			}

			dp[i] = best;
		}

		return Math.max(dp[0], 0);
	}

	int findMaximumBalancedShipmentsHelperDP(int i, int[] w) {
		int n = w.length;
		if (i >= n)
			return 0;

		if (dp[i] != Integer.MIN_VALUE)
			return dp[i];

		int best = Integer.MIN_VALUE;
		int max = w[i];

		for (int j = i + 1; j < n; j++) {
			max = Math.max(max, w[j]);
			int last = w[j];

			if (max > last) {
				int next = findMaximumBalancedShipmentsHelperDP(j + 1, w);
				if (next != Integer.MIN_VALUE)
					best = Math.max(best, 1 + next);
			}
		}

		dp[i] = best;
		return best;
	}

	// returns maximum shipments from index i onward
	int findMaximumBalancedShipmentsHelper(int i, int[] w) {
		int n = w.length;
		if (i >= n)
			return 0;

		int best = Integer.MIN_VALUE; // means impossible so far
		int max = w[i]; // track max in segment [i..j]

		// j starts from i+1 because segment size must be >=2
		for (int j = i + 1; j < n; j++) {
			max = Math.max(max, w[j]);
			int last = w[j];

			if (max > last) {
				int next = findMaximumBalancedShipmentsHelper(j + 1, w);
				if (next != Integer.MIN_VALUE) {
					best = Math.max(best, 1 + next);
				}
			}
		}

		return best;
	}

	public static void main(String[] args) {
		System.out.println(new Eleven03122025().findMaximumBalancedShipments(new int[] { 1, 2, 3, 2, 6, 3 }));

		System.out.println(new Eleven03122025().findMaximumBalancedShipments(new int[] { 8, 5, 4, 7, 2 }));

		System.out.println(new Eleven03122025().findMaximumBalancedShipments(new int[] { 4, 3, 6, 5, 3, 4, 7, 1 }));
	}
}
