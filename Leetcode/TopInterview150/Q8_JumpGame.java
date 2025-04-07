public class Q8_JumpGame {
    public static void main(String[] args) {
        int[] nums = {2,0,0};

        System.out.println(canJump(nums));
    }

    //Easy Solution greater than works as it implies we can easily jump till it.
    public static boolean canJump(int[] nums) {
        int goal = nums.length - 1;

        for(int i = nums.length - 2; i >= 0; i--){
            if(i + nums[i] >= goal){
                goal = i;
            }
        }

        return goal == 0;

        // return canJumHelper(nums, 0);
    }

    //Gives TLE
    public static boolean canJumHelper(int[] nums, int step){
        if(step == nums.length - 1){
            return true;
        }

        if(nums[step] == 0){
            return false;
        }
        int reach = step + nums[step];
        
        for(int jump = step + 1; jump <= reach; jump++){
            if(jump < nums.length && canJumHelper(nums, jump)){
                return true;
            }
        }

        return false;
    }


}
