package LeetCode;
// https://leetcode.com/problems/first-missing-positive/description/
public class FirstMissingPositive {
    public static void swap(int[] arr, int posOne, int posTwo){
        int temp = arr[posOne];
        arr[posOne] = arr[posTwo];
        arr[posTwo] = temp;
    }

    public static int firstMissingPositive(int[] nums) {
        int i = 0;
        while(i < nums.length){
            int correctPos = nums[i] - 1;
            if(nums[i] > 0 && nums[i] <= nums.length && nums[correctPos] != nums[i]){
                swap(nums, correctPos, i);
            }else{
                i++;
            }
        }
        //System.out.println(Arrays.toString(nums));
        for(i = 0; i < nums.length; i++){
            if(nums[i] != i + 1){
                return i + 1;
            }
        }
        return nums.length + 1;
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(firstMissingPositive(nums));
    }
}
