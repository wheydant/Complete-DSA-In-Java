package Striver.GreedyAlgorithm.Leetcode;

public class JumpGame {
    public static boolean canJump(int[] nums){
        int maxIndex = 0;
        for(int i = 0; i < nums.length; i++){
            if(i > maxIndex)return false;
            maxIndex = Math.max(maxIndex, i + nums[i]);
            if(maxIndex >= nums.length)return true;
        }

        return true;
    }
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(canJump(nums));
    }
}
