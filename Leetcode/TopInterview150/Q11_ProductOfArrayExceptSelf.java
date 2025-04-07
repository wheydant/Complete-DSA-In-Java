
import java.util.Arrays;

public class Q11_ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }
    //Optimized
    public static int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        ans[0] = 1;
        for(int i = 1; i < nums.length; i++){
            ans[i] = ans[i - 1] * nums[i - 1];
        }
        System.out.println("Left: "+ Arrays.toString(ans));

        int multiplier = nums[nums.length - 1];
        for(int i = nums.length - 2; i >=0 ; i--){
            ans[i] = ans[i]*multiplier;
            multiplier *= nums[i];
        }
        return ans;
    }
    //TLE
    public static int[] productExceptSelf2(int[] nums) {
        int[] ans = new int[nums.length];
        Arrays.fill(ans, 1);
        
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < nums.length; j++){
                if(i == j){
                    continue;
                }
                ans[i] *= nums[j];
            }
        }
        return ans;
    }

    public static int[] productExceptSelf1(int[] nums) {
        int[] left = new int[nums.length];
        Arrays.fill(left, 1);

        int[] right = new int[nums.length];
        Arrays.fill(right, 1);

        int[] ans = new int[nums.length];
        
        for(int i = 1; i < nums.length; i++){
            left[i] = left[i - 1] * nums[i - 1];
        }
        System.out.println("Left: "+ Arrays.toString(left));

        for(int i = nums.length - 2; i >= 0 ; i--){
            right[i] = right[i + 1] * nums[i + 1];
        }
        System.out.println("RIght: "+ Arrays.toString(right));

        for(int i = 0; i < ans.length; i++){
            ans[i] = left[i]*right[i];
        }
        return ans;
    }

    class Solution {
        public int[] productExceptSelf(int[] nums) {
            int[] output = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                output[i] = 1;
            }
    
            int left = 1;
            for (int i = 0; i < nums.length; i++) {
                output[i] *= left;
                left *= nums[i];
            }
    
            int right = 1;
            for (int i = nums.length - 1; i >= 0; i--) {
                output[i] *= right;
                right *= nums[i];
            }
    
            return output;        
        }
    }
}
