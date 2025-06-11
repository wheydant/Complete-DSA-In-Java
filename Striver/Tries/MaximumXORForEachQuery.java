package Striver.Tries;

public class MaximumXORForEachQuery {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int n = nums.length;
        int[] ans = new int[n];
        int prefixXor = 0;
        
        for (int num : nums) {
            prefixXor ^= num;
        }
        //maximumBit = 3 -> 1<<3 => 1000 - 1 => 0111
        int mask = (1 << maximumBit) - 1;

        for (int i = 0; i < n; i++) {
            /*
             * Let's say:
                prefixXor = 5  // binary: 101
                mask       = 7  // binary: 111 (since maximumBit = 3)
                Then:

                prefixXor ^ mask = 101 ^ 111 = 010 = 2
                This 2 is the value of k that maximizes prefixXor ^ k because:

                prefixXor ^ 2 = 5 ^ 2 = 7 → which is the maximum possible value under 3 bits.
             */
            ans[i] = prefixXor ^ mask;   // Maximize XOR with mask
            prefixXor ^= nums[n - 1 - i]; // Remove the last element from XOR
        }

        return ans;
    }
}
