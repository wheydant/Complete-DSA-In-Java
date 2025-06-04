package Striver.TwoPointerAndSlidingWindow.LeetCode;
public class BinarySubarraysWithSum{
    //Direct approach creates a confusion when to move left and when to move right.
    //FInd all the subArray <= goal
    //O(N + N)
    public static int numSubarraysWithSum(int[] nums, int goal) {
        return helper(nums, goal) - helper(nums, goal - 1);
    }
    static int helper(int[] nums, int goal){
        if(goal < 0)return 0;
        int l = 0, r = 0, sum = 0, count = 0;

        while(r < nums.length){
            sum += nums[r];
            while(sum > goal){
                sum -= nums[l];
                l++;
            }
            //Counting length resulting in finding all the subarray which have sum <= goal
            count += r - l + 1;
            r++;
        }

        return count;
    }
    public static void main(String[] args) {
        
    }
}