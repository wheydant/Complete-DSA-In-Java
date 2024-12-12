package LeetCode;
/*
 * https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
 */
import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedInAnArray {
    public static void swap(int[] arr, int posOne, int posTwo){
        int temp = arr[posOne];
        arr[posOne] = arr[posTwo];
        arr[posTwo] = temp;
    }
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int i = 0;
        while(i < nums.length){
            int correct = nums[i] - 1; 
            if(nums[i] != nums[correct]){
                swap(nums, i, correct);
            }else{
                i++;
            }
        }
        List<Integer> missingNumbers = new ArrayList<>();
        for(i = 0; i < nums.length; i++){
            if(nums[i] != i + 1){
                missingNumbers.add(i + 1);
            }
        }

        return missingNumbers;
    }
    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 7 ,8, 2, 3, 1};

        System.out.println(findDisappearedNumbers(arr));
    }
}
