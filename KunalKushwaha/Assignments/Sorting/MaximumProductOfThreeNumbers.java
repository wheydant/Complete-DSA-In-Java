package KunalKushwaha.Assignments.Sorting;

import java.util.Arrays;

public class MaximumProductOfThreeNumbers{
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        // Option 1: Last three elements
        int prod1 = nums[n - 1] * nums[n - 2] * nums[n - 3];

        // Option 2: Two smallest and the largest
        int prod2 = nums[0] * nums[1] * nums[n - 1];

        return Math.max(prod1, prod2);
    }
}