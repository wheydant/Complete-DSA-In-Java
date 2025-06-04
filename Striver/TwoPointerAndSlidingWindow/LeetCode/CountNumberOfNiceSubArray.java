package Striver.TwoPointerAndSlidingWindow.LeetCode;

public class CountNumberOfNiceSubArray {
    //Convert Odd to 1's and even to 0's same like count the sum in 1 and 0
    public int numberOfSubarrays(int[] nums, int k){
        return helper(nums, k) - helper(nums, k - 1);
    }
    static int helper(int[] nums, int goal){
        if(goal < 0)return 0;
        int l = 0, r = 0, sum = 0, count = 0;

        while(r < nums.length){
            sum += nums[r]%2;
            while(sum > goal){
                sum -= nums[l]%2;
                l++;
            }
            //Counting length resulting in finding all the subarray which have sum <= goal
            count += r - l + 1;
            r++;
        }

        return count;
    }
}
