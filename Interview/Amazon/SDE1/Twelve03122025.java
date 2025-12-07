package Interview.Amazon.SDE1;

import java.util.Arrays;

public class Twelve03122025 {
	int getMinTime(int total_servers, int[] servers) {
		Arrays.sort(servers);
		int n = servers.length;

		int maxGap = 0;

		for (int i = 1; i < n; i++) {
			maxGap = Math.max(maxGap, servers[i] - servers[i - 1]);
		}

		// circular wrap gap
		maxGap = Math.max(maxGap, total_servers - servers[n - 1] + servers[0]);

		// minimal hops = full circle - largest empty segment
		return total_servers - maxGap;
	}

	public static void main(String[] args) {
		System.out.println(new Twelve03122025().getMinTime(8, new int[] { 2, 6, 8 }));
	}
}
