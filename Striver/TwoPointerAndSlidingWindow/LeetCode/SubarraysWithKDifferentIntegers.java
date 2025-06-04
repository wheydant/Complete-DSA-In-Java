package Striver.TwoPointerAndSlidingWindow.LeetCode;

import java.util.HashMap;

public class SubarraysWithKDifferentIntegers {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int j = i; j < nums.length; j++){
                map.put(nums[j], map.getOrDefault(map.get(nums[j]), 0) + 1);
                if(map.size() == k) count++;
                if(map.size() > k) break;
            }
        }
        return count;
    }
    //Here it becomes dicey whether to shrink or expand the window as doing so losses on the potential subarrays.
    //Change PS to no of subarrays where diferent integers <= k
    //TC - O(2N)
    //SC - O(N) worst case we have to store all the elements
    public int subarraysWithKDistinctSW(int[] nums, int k) {
        return helper(nums, k) - helper(nums, k - 1);
    }
    int helper(int[] nums, int k){
        int count = 0;
        int l = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int r = 0; r < nums.length; r++){
             map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);
            while(map.size() > k){
                map.put(nums[l], map.get(nums[l]) - 1);
                if(map.get(nums[l]) == 0){
                    map.remove(nums[l]);
                }
                l++;
            }
            count += r - l + 1;
        }
        return count;
    }
}
