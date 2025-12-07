package Interview.Amazon.SDE1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Two03122025 {
	// Q1
	int[] findRequestTarget(int servers, int[] requests) {
		int n = requests.length;
		int[] target = new int[n];

		// Capacity, Index
		int[][] loadBalancer = new int[servers][2];

		for (int i = 0; i < servers; i++) {
			loadBalancer[i][0] = 0;
			loadBalancer[i][1] = i;
		}

		for (int i = 0; i < n; i++) {
			int ipHashed = requests[i];
			Arrays.sort(loadBalancer, (a, b) -> {
				if (a[0] == b[0])
					return a[1] - b[1];
				else
					return a[0] - b[0];
			});

			int index = 0;
			while (loadBalancer[index][1] > ipHashed && index < servers)
				index++;

			target[i] = loadBalancer[index][1];
			loadBalancer[index][0]++;
		}

		return target;
	}

	int[] findRequestTargetChatGpt(int numServers, int[] requests) {
		int m = requests.length;
		int[] result = new int[m];
		int[] load = new int[numServers]; // all init to 0

		for (int i = 0; i < m; i++) {
			int h = requests[i];
			if (h >= numServers)
				h = numServers - 1; // safe-guard if hash may exceed

			int bestServer = -1;
			int bestLoad = Integer.MAX_VALUE;

			// search servers from 0..h inclusive
			for (int s = 0; s <= h; s++) {
				if (load[s] < bestLoad) {
					bestLoad = load[s];
					bestServer = s;
				}
				// tie-breaker by smallest id auto-handled because we only update when strictly
				// less
			}

			// assign
			result[i] = bestServer;
			load[bestServer]++;
		}

		return result;
	}

	// Q2
	int countSecuredStrings(String s, String t) {
		Map<String, Integer> map = new HashMap<>();
		int ansQ = countSecuredStringsHelper(0, "", s, t);
		int n = s.length(), m = t.length();
		Long[][][] memo = new Long[n + 1][m + 1][2];
		ansQ = (int) (dfs(0, 0, 0, s, t, memo));

		long[][][] dp = new long[n + 1][m + 1][2];

		//Tabulation
		// Base Case:
		for (int j = 0; j <= m; j++) {
			dp[n][j][1] = 1; // already greater → valid
			dp[n][j][0] = 0; // equal but no chars left → cannot be greater
		}

		for (int i = n - 1; i >= 0; i--) {
			for (int j = 0; j <= m; j++) {
				for (int state = 0; state <= 1; state++) {

					long ans = 0;

					// OPTION 1: Do NOT take s[i]
					ans += dp[i + 1][j][state];

					// OPTION 2: TAKE s[i]
					char ch = s.charAt(i);

					if (state == 1) {
						ans += dp[i + 1][j][1]; // stays greater
					} else {
						if (j < m) {
							if (ch < t.charAt(j)) {
								// invalid path
							} else if (ch > t.charAt(j)) {
								ans += dp[i + 1][j + 1][1]; // becomes greater
							} else {
								ans += dp[i + 1][j + 1][0]; // remains equal
							}
						} else {
							// j == m → curr already same prefix as t but shorter
							// adding char makes curr longer → greater
							ans += dp[i + 1][j][1];
						}
					}

					dp[i][j][state] = ans;
				}
			}
		}

		return (int) dp[0][0][0]; // start with equal state
	}

	long dfs(int i, int j, int state, String s, String t, Long[][][] memo) {
		int n = s.length(), m = t.length();

		// Base case: no chars left in s
		if (i == n) {
			return state == 1 ? 1 : 0;
		}

		if (memo[i][j][state] != null)
			return memo[i][j][state];

		long ans = 0;

		// OPTION 1: Do NOT take s[i]
		ans += dfs(i + 1, j, state, s, t, memo);

		// OPTION 2: TAKE s[i]
		char ch = s.charAt(i);

		if (state == 1) {
			// already greater stays greater
			ans += dfs(i + 1, j, 1, s, t, memo);
		} else {
			// state = 0 (equal so far)
			if (j < m) {
				if (ch < t.charAt(j)) {
					// becomes smaller → invalid
				} else if (ch > t.charAt(j)) {
					ans += dfs(i + 1, j + 1, 1, s, t, memo); // now greater
				} else {
					ans += dfs(i + 1, j + 1, 0, s, t, memo); // still equal
				}
			} else {
				// t fully matched, adding more chars makes curr longer → greater
				ans += dfs(i + 1, j, 1, s, t, memo);
			}
		}

		memo[i][j][state] = ans;
		return ans;
	}

	int countSecuredStringsHelper(int i, String curr, String s, String t) {
		if (i == s.length()) {
			int currLen = curr.length();
			int tLen = t.length();
			int minLen = Math.min(currLen, tLen);

			for (int k = 0; k < minLen; k++) {
				if (curr.charAt(k) != t.charAt(k)) {
					return curr.charAt(k) > t.charAt(k) ? 1 : 0;
				}
			}

			return currLen > tLen ? 1 : 0;
		}

		// take
		int take = countSecuredStringsHelper(i + 1, curr + s.charAt(i), s, t);
		// notTake
		int notTake = countSecuredStringsHelper(i + 1, curr, s, t);

		return take + notTake;
	}

	public static void main(String[] args) {
		// System.out.println(Arrays.toString(new Two03122025().findRequestTarget(5, new
		// int[] { 3, 2, 3, 2, 4 })));

		System.out.println(new Two03122025().countSecuredStrings("aba", "ab"));
	}
}
