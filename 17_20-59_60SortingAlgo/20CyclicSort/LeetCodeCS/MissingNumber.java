package LeetCode;

/*
 * https://leetcode.com/problems/missing-number/description/
 */
public class MissingNumber {
    public static int sumMethod(int[] nums){
        int idealSum = (nums.length + 1)*(nums.length)/2;

        int actualSum = 0;

        for(int i = 0; i < nums.length; i++){
            actualSum += nums[i];
        }

        return idealSum - actualSum;
    }
    public static void swap(int[] nums,int firstPos,int secondPos){
        int temp = nums[firstPos];
        nums[firstPos] = nums[secondPos];
        nums[secondPos] = temp;
    }
    public static int missingNumber(int[] nums) {
        // return sumMethod(nums);
        int start = 0;
        int end = nums.length;
        while(start < end){
            if(nums[start] == nums.length || start == nums[start]){
                start++;
            }
            else{
                swap(nums, start, nums[start]);
            }
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != i){
                return i;
            }
        }

        return nums.length;
    }

    public static void main(String[] args) {
        int[] arr = {0, 2, 3, 1, 5, 4};
        System.out.println(missingNumber(arr));
    }
}
