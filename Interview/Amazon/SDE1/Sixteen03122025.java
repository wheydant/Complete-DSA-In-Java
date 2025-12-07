package Interview.Amazon.SDE1;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Sixteen03122025 {
	// Q1
	int noOfSeeds(String s, int k) {
		int n = s.length();

		int count = 0;
		for (int i = 0; i + k <= n; i++) {
			StringBuilder curr = new StringBuilder(s.substring(i, i + k));
			curr = curr.reverse();

			if (isLexicographicallySmall(curr, s)) {
				count++;
			}
		}

		return count;
	}

	boolean isLexicographicallySmall(StringBuilder subString, String s) {
		int n = Math.min(subString.length(), s.length());

		for (int i = 0; i < n; i++) {
			if (subString.charAt(i) != s.charAt(i)) {
				return subString.charAt(i) < s.charAt(i);
			}
		}

		return subString.length() < s.length();
	}

	// Q2
	int minimumCost(int[] a, int[] b, int m) {
		int minCost = 0;
		int n = a.length;
		if (m <= n) {
			// Only additional factor matters for m < length
			Arrays.sort(a);
			for (int i = 0; i < m; i++) {
				minCost += a[i];
			}
		} else {
			int[][] cumulative = new int[n][3];
			for (int i = 0; i < n; i++) {
				cumulative[i][0] = a[i] + b[i];
				cumulative[i][1] = a[i];
				cumulative[i][2] = b[i];
			}

			Arrays.sort(cumulative, (x, y) -> {
				// After first round multiplier should be as small as possible
				if (x[0] == y[0])
					return x[2] - y[2];
				return x[0] - y[0];
			});

			int purchase = 0;
			int j = 0;
			while (purchase != m) {
				for (int i = 0; i < cumulative.length; i++) {
					int currCost = cumulative[i][1] + j * cumulative[i][2];
					minCost += currCost;
					purchase++;
					if (purchase == m)
						return minCost;
				}
				j++;
			}
		}

		return minCost;
	}

	public long minimumCostOptimized(int[] a, int[] b, int m) {
		int n = a.length;
		PriorityQueue<Node> pq = new PriorityQueue<>((x, y) -> Long.compare(x.cost, y.cost));

		// STEP 1 — Insert the first-cost of each type
		for (int i = 0; i < n; i++) {
			pq.add(new Node(a[i], i, 0)); // first purchase cost = a[i] + 0*b[i]
		}

		long total = 0;

		// STEP 2 — Extract the m cheapest items, globally
		while (m-- > 0) {
			Node curr = pq.poll(); // cheapest item available
			total += curr.cost;

			int i = curr.i;
			int nextCount = curr.count + 1;

			// compute next cost for this type
			long nextCost = a[i] + (long) nextCount * b[i];

			pq.add(new Node(nextCost, i, nextCount));
		}

		return total;
	}

	// Node represents the next purchase option for a given type i
	static class Node {
		long cost; // next purchase cost
		int i; // item type
		int count; // how many of this type have been purchased so far (j)

		Node(long cost, int i, int count) {
			this.cost = cost;
			this.i = i;
			this.count = count;
		}
	}

	public static void main(String[] args) {
		// System.out.println(new Sixteen03122025().noOfSeeds("amazon", 3));

		System.out.println(new Sixteen03122025().minimumCost(new int[] { 2, 1, 1 }, new int[] { 1, 2, 3 }, 4));

		System.out.println(new Sixteen03122025().minimumCost(new int[] { 3, 4 }, new int[] { 1, 100 }, 3));

		System.out.println(new Sixteen03122025().minimumCost(new int[] { 2, 50, 50 }, new int[] { 1, 1, 1 }, 3));
	}
}
