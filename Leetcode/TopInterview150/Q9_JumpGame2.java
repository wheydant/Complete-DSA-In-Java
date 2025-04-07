


public class Q9_JumpGame2 {
    public static void main(String[] args) {
        int[] nums = {2,3,0,1,4};

        System.out.println(jump(nums));
    }
    public static int jump(int[] nums) {
        int near = 0;
        int far = 0;
        int jump = 0;

        while(far < nums.length - 1){
            int farthest = 0;
            for(int i = near; i <= far; i++){
                farthest = Math.max(farthest, nums[i] + i);
            }
            near = far + 1;
            far = farthest;
            jump += 1;
        }

        return jump;
        
        //return helperJump(nums, 0);
    }
    //Gives TLE
    public static int helperJump(int[] nums, int steps){
        if(steps >= nums.length - 1){
            return 0;
        }
        //Specified in question max jumps
        int minJumps = 10001;
        for(int i = 1; i <= nums[steps]; i++){
            minJumps = Math.min(minJumps, 1 + helperJump(nums, steps + i));
        }

        return minJumps;

    }


}
