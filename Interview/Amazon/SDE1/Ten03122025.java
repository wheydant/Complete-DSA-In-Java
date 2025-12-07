package Interview.Amazon.SDE1;

public class Ten03122025 {
	int findTotalPower(int[] power){
		int totalPower = 0;
		for(int i = 0; i < power.length; i++){
			for(int j = i; j < power.length; j++){
				int min = Integer.MAX_VALUE;
				int sum = 0;
				for(int k = i; k <= j; k++){
					if(power[k] < min) min = power[k];
					sum += power[k];
				}
				totalPower += min*sum;
			}
		}

		return totalPower;
	}

	
    static final long MOD = 1_000_000_007;

    public int findTotalPowerOptimized(int[] power) {
        int n = power.length;

        long[] prefix = new long[n + 1];
        long[] pp = new long[n + 2];

        // prefix sum
        for (int i = 0; i < n; i++)
            prefix[i + 1] = (prefix[i] + power[i]) % MOD;

        // prefix of prefix
        for (int i = 1; i <= n; i++)
            pp[i + 1] = (pp[i] + prefix[i]) % MOD;

        // monotonic stack
        int[] left = new int[n];
        int[] right = new int[n];
        java.util.Arrays.fill(right, n);

        java.util.Stack<Integer> st = new java.util.Stack<>();

        // nearest smaller on the left
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && power[st.peek()] > power[i])
                st.pop();
            left[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        st.clear();

        // nearest smaller or equal on the right
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && power[st.peek()] >= power[i])
                st.pop();
            right[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        long ans = 0;

        // compute contribution for each i
        for (int i = 0; i < n; i++) {
            long p = power[i];

            int L = left[i];
            int R = right[i];

            long leftCount = i - L;
            long rightCount = R - i;

            // sum of subarray sums for ranges where i is minimum
            long sumLeft = (pp[i + 1] - pp[L + 1] + MOD) % MOD;
            long sumRight = (pp[R + 1] - pp[i + 1] + MOD) % MOD;

            long total = ((sumRight * leftCount % MOD) - (sumLeft * rightCount % MOD) + MOD) % MOD;

            ans = (ans + p * total) % MOD;
        }

        return (int) ans;
    }
	public static void main(String[] args) {
		System.out.println(new Ten03122025().findTotalPower(new int[]{2, 3, 2, 1}));
	}
}
