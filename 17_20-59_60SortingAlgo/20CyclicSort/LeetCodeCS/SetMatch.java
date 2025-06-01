package LeetCode;

import java.util.Arrays;

/*https://leetcode.com/problems/set-mismatch/description/ 
*/
public class SetMatch {
    public static void swap(int[] arr, int posOne, int posTwo){
        int temp = arr[posOne];
        arr[posOne] = arr[posTwo];
        arr[posTwo] = temp;
    }
    public static int[] findErrorNums(int[] nums) {
        int i = 0;
        while(i < nums.length){
            int correct = nums[i] - 1; 
            if(nums[i] != nums[correct]){
                swap(nums, i, correct);
            }else{
                i++;
            }
        }
        int[] missingNumbers = {0, 0};
        for(i = 0; i < nums.length; i++){
            if(nums[i] != i + 1){
                missingNumbers[0] = nums[i];
                missingNumbers[1] = i + 1;
                break;
            }
        }

        return missingNumbers;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 4};
        System.out.println(Arrays.toString(findErrorNums(nums)));
    }
}
