
import java.util.Arrays;

public class Q6_RotateArray {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
        rotate2(nums, k);
        
        System.out.println(Arrays.toString(nums));
    }
    public static void rotate(int[] nums, int k) {
        int[] ans = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            int index = (k + i)%(nums.length);
            System.out.println(index); 
            ans[index] = nums[i];
        }

        System.arraycopy(ans, 0, nums, 0, nums.length);
    }


    //Gives TLE for large solution
    public static void rotate2(int[] nums, int k) {
        if(k == 0){
            return;
        }
        int temp = nums[nums.length - 1];
        for(int i = nums.length - 2; i  >= 0; i--){
            nums[i + 1] = nums[i];
        }
        nums[0] = temp;
        System.out.println(Arrays.toString(nums));

        rotate2(nums, k - 1);
    }
    
    public static void rotateLC(int[] nums, int k) {
        k %= nums.length;

        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private static void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}
