package KunalKushwaha.Assignments.Sorting;

import java.util.Arrays;

public class ThirdMaximumNumber{
    //Solution works but some Dumbfuck added Integer.MIN_Value as test case
    public int thirdMax(int[] nums) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > max1){
                max3 = max2;
                max2 = max1;
                max1 = nums[i];
            }
            else if(nums[i] > max2 && nums[i] < max1){
                max3 = max2;
                max2 = nums[i];
            }else if(nums[i] > max3 && nums[i] < max2){
                max3 = nums[i];
            }
        }

        return (max3 != Integer.MIN_VALUE)? max3 : max1;
    }
    //Not optimum but working solution
    public int thirdMaxWorking(int[] nums) {
        Arrays.sort(nums);
        int count = 1, prev = nums[nums.length - 1], res = 0;
        for(int i = nums.length - 2;i >= 0; i--) {
            if(prev != nums[i]) count++;
            prev = nums[i];
            if(count == 3) {
                res = nums[i];
                break;
            }
        }
        if(count != 3) return nums[nums.length - 1];
        return res;
    }
    public static void main(String[] args) {
        ThirdMaximumNumber q = new ThirdMaximumNumber();
        int[] nums = {1,2};
        System.out.println(q.thirdMax(nums));
    }
}