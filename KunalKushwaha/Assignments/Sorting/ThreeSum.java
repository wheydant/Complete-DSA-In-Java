package KunalKushwaha.Assignments.Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum{
    public List<List<Integer>> threeSumOptimum(int[] nums) {
        List<List<Integer>> threeSums = new ArrayList<>();
        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 2; i++){
            //Skip this it means we have already calculated for this value
            if(i > 0 && (nums[i] == nums[i - 1])) continue;

            int j = i + 1;
            int k = nums.length - 1;

            while(j < k){
                int currSum = nums[i] + nums[j] + nums[k];

                if(currSum > 0) k--;
                else if(currSum < 0) j++;
                else{
                    threeSums.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    //We have taken this j's value so push ahead
                    while(nums[j] == nums[j - 1] && j < k) j++;
                }
            }
        }
        return threeSums;
    }
}