package Interview.Amazon.SDE1;

import java.util.Arrays;

public class Four03122025 {
	int[] findOptimalPermutation(int[] data){
		int n = data.length;
		int[][] sortedDate = new int[n][2];

		for(int i = 0; i < n; i++){
			sortedDate[i][0] = data[i];
			sortedDate[i][1] = i;
		}

		Arrays.sort(sortedDate, (a,b) -> {
			if(a[0] == b[0]) return a[1] - b[1];

			return (a[0] - b[0]);
		});

		System.out.println(Arrays.deepToString(sortedDate));

		int[] ans = new int[n];

		for(int i = 0; i < n; i++){
			ans[i] = sortedDate[i][1] + 1;
		}

		return ans;
	}
	public static void main(String[] args) {
		System.out.println(Arrays.toString(new Four03122025().findOptimalPermutation(new int[]{2,1,2})));
	}
}
