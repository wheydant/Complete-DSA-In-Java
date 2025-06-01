
import java.util.Arrays;

public class HowManyNumbersAreSmallerThanTheCurrentNumber {
    public static int[] smallerNumbersThanCurrent(int[] nums) {
        int[] noOfSmallerNumber = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < nums.length; j++){
                if(nums[i] > nums[j]){
                    noOfSmallerNumber[i]++;
                }
            }
        }
        return noOfSmallerNumber;
    }
    public static int[] smallerNumbersThanCurrentOptimum(int[] nums) {
        int[] count = new int[101];
        int[] res = new int[nums.length];
        
        //Count the occurrence of every number
        for (int i =0; i < nums.length; i++) {
            count[nums[i]]++;
        }
        
        //Keep a track and append to prev count
        for (int i = 1 ; i <= 100; i++) {
            count[i] += count[i-1];    
        }
        
        for (int i = 0; i < nums.length; i++) {
            //Lowest number is 0
            if (nums[i] == 0)
                res[i] = 0;
            else 
                res[i] = count[nums[i] - 1];
        }
        
        return res;      
    }
    public static void main(String[] args) {
        int[] nums = {8,1,2,2,3};
        System.out.println(Arrays.toString(smallerNumbersThanCurrent(nums)));
    }
}
