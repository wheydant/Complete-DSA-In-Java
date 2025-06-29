package KunalKushwaha.Assignments.Searching;

import java.util.Arrays;

public class SpecialArrayWithXElementsGreaterThanorEqualX{
    int lessThanEqualTo(int val, int[] nums){
        int cnt = 0;
        for(int num : nums){
            if(num >= val)cnt++;
        }
        return cnt;
    }
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int specialNo = -1;
        int start = 0;
        int end = nums[nums.length -1];
        while(start <= end){
            int mid = (end - start)/2 + start;
            if(lessThanEqualTo(mid, nums) == mid){
                specialNo = mid;
                break;
            }else if(lessThanEqualTo(mid, nums) > mid){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return specialNo;
    }
}