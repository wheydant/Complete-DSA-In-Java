package Striver.DynamicProgramming.LeetCode;

import java.util.Arrays;

//Very smart solution
public class HouseRobberII {
    public int robSO(int[] nums){
        int n = nums.length;

        int prev = nums[0];
        int prev2 = 0;

        for (int i = 1; i < n; i++) {
            int pick = nums[i];
            if(i > 1) pick += prev2;

            int notPick = 0 + prev;
            int curr = Math.max(pick, notPick);
            prev2 = prev;
            prev = curr;
        }

        return prev;
    }
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 0)return nums[0];
        int ans0 = robSO(Arrays.copyOfRange(nums, 0, n - 1));

        int ansLast = robSO(Arrays.copyOfRange(nums, 1, n));

        return Math.max(ans0, ansLast);
    }
}
