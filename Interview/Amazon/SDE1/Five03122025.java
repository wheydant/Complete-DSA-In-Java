package Interview.Amazon.SDE1;

import java.util.Arrays;

public class Five03122025 {
	boolean isPretty(boolean[][] canvas, int k) {

		for (int i = 1; i <= canvas.length - k; i++) {
			for (int j = 1; j <= canvas[i].length - k; j++) {
				boolean allTrue = true;
				for (int r = i; r < i + k; r++) {
					for (int c = j; c < j + k; c++) {
						if (!canvas[r][c]) {
							System.out.println(Arrays.deepToString(canvas));
							System.out.println("Failed for " + r + " " + c);
							allTrue = false;
							break;
						}
					}
					if (!allTrue)
						break;
				}
				if (allTrue)
					return true;
			}
		}

		return false;
	}

	int minTimeForPrettyCanvas(int n, int m, int k, int[][] paint) {
		boolean[][] canvas = new boolean[n + 1][m + 1];

		for (int i = 0; i < paint.length; i++) {
			int x = paint[i][0];
			int y = paint[i][1];

			canvas[x][y] = true;

			if (isPretty(canvas, k)) {
				return i + 1;
			}
		}

		return -1;
	}

	int minTimeForPrettyCanvasOptimized(int n, int m, int k, int[][] paint) {

		int[][] canvas = new int[n + 1][m + 1];
		int[][] pref = new int[n + 1][m + 1];

		for (int t = 0; t < paint.length; t++) {
			int x = paint[t][0];
			int y = paint[t][1];

			// Mark painted
			canvas[x][y] = 1;

			// Update prefix sum for row x only (fast incremental update)
			for (int j = 1; j <= m; j++) {
				pref[x][j] = canvas[x][j] + pref[x - 1][j] + pref[x][j - 1] - pref[x - 1][j - 1];
			}

			// Check all possible k×k squares in O(n*m)
			for (int i = 1; i + k - 1 <= n; i++) {
				for (int j = 1; j + k - 1 <= m; j++) {

					// Fetch the corners of Square
					int x2 = i + k - 1;
					int y2 = j + k - 1;

					// Important
					int sum = pref[x2][y2]
							- pref[i - 1][y2]
							- pref[x2][j - 1]
							+ pref[i - 1][j - 1];

					if (sum == k * k) {
						return t + 1;
					}
				}
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		System.out.println(new Five03122025().minTimeForPrettyCanvas(2, 3, 2,
				new int[][] { { 1, 2 }, { 2, 3 }, { 2, 1 }, { 1, 3 }, { 2, 2 }, { 1, 1 } }));
	}
}
