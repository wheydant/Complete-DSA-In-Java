package KunalKushwaha.Assignments.Sorting;

import java.util.Arrays;

public class MajorityElement {
    public int majorityElementExtraTime(int[] nums) {
        Arrays.sort(nums);
        int maxCount = 1;
        int currCount = 0;
        int result = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == nums[i - 1]){
                currCount++;
            }else{
                currCount = 0;
            }

            if(currCount >= maxCount){
                maxCount = currCount;
                result = nums[i - 1];
            }
        }

        return result;
    }
    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = -1;

        for(int num : nums){
            if(count == 0){
                candidate = num;
            }

            //This works because more than half numbers are candidate thus they won't cancel each other.
            count += (candidate == num)? 1: -1;
        }

        return candidate;
    }
}
