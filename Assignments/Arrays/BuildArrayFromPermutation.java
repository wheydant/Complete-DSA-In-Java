
import java.util.Arrays;

public class BuildArrayFromPermutation {
    
    public static int[] buildArray(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            //For every time even after inserting we need to fetch the previous values
            int newVal = nums[nums[i]] % len;
            nums[i] += newVal * len;
        }
        for (int i = 0; i < len; i++) {
            nums[i] /= len;
        }
        return nums;
    }
    public static void main(String[] args) {
        int[] nums = {5, 0, 1, 2, 3, 4};
        System.out.println(Arrays.toString(buildArray(nums)));
    }
}
