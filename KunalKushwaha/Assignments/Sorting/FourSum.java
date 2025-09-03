package KunalKushwaha.Assignments.Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum{
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        // System.out.println(Arrays.toString(nums));
        for(int i = 0; i < n - 3; i++){
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            for(int j = i + 1; j < n - 2; j++){
                if(j > i + 1 && nums[j] == nums[j - 1])continue;

                int k = j + 1;
                int l = n - 1;

                while(k < l){
                    int currSum = nums[i] + nums[j] + nums[k] + nums[l];
                    if(currSum > target) l--;
                    else if(currSum < target) k++;
                    else{
                        ans.add(Arrays.asList(nums[i] ,nums[j] ,nums[k] ,nums[l]));
                        k++;
                        while(k < l && nums[k] == nums[k - 1])k++;
                    }
                }
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        System.out.println(fourSum(new int[]{1, 0 , -1, 0, -2, 2}, 0));
    }
}