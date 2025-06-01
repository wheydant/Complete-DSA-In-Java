
import java.util.Arrays;

public class ShuffleTheArray {
    public static int[] shuffle(int[] nums, int n) {
        int[] returnNums = new int[nums.length];
        int j = 0;
        for(int i = 0; i < nums.length && n < nums.length; i++){
            if(i%2 == 0){
                returnNums[i] = nums[j++];
            }else{
                returnNums[i] = nums[n++];
            }
        }
        return returnNums;
    }
    //True in-place solution
    public static int[] shuffleInPlace(int[] nums, int n) {
        for(int i = n; i < nums.length; i++){
            //Populate all the values post n with data choose 1001 as 1000 is max value nums can have
            nums[i] = nums[i]*1001 + nums[i - n];
        }
        int index = 0;
        for(int i = n; i < nums.length; i++, index+=2){
            nums[index] = nums[i]%1001;
            nums[index + 1] = nums[i]/1001;
        }
        return nums;
    }
    //Bitwise Solution
    public static int[] shuffleBitwise(int[] nums, int n) {
        for(int i = n; i < nums.length; i++){
            nums[i] = (nums[i] << 10) | nums[i - n];
        }
        int index = 0;
        for(int i = n ; i < nums.length; i++, index += 2){
            nums[index] = nums[i]&1023;
            nums[index + 1] = nums[i]>>10;
        }
        return nums;
    }    
    public static void main(String[] args) {
        int[] nums = {2,5,1,3,4,7};
        //{2001,5003,1005, 3002}
        System.out.println(Arrays.toString(shuffle(nums, 3)));
        System.out.println(Arrays.toString(shuffleInPlace(nums, 3)));
        int[] nums2 = {2,5,1,3,4,7};
        System.out.println(Arrays.toString(shuffleBitwise(nums2, 3)));
    }
}
