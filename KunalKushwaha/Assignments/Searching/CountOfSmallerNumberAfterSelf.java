package KunalKushwaha.Assignments.Searching;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CountOfSmallerNumberAfterSelf{
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> ans = new ArrayList<>(nums.length);
        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            int lessThanNum = 0;
            for(int j = i + 1; j < nums.length; j++){
                if(nums[j] < num) lessThanNum++;
            }
            ans.add(lessThanNum);
        }
        return ans;
    }
    //TC - O(n Log n)
    public List<Integer> countSmallerBS(int[] nums) {
        
        int n = nums.length;

        List<Integer> clone = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        
        for(int num: nums) clone.add(num);
        
        Collections.sort(clone);
        
        for(int i = 0; i < n; i++){
            int pos = binarySearch(clone, nums[i]);
            ans.add(pos);
            clone.remove(pos);
        }
        
        return ans;
        
    }
    
    public int binarySearch(List<Integer> clone, int target){
        int l = 0;
        int h = clone.size();
        
        while(l < h){
            int m =  l + (h-l)/2;
            if(clone.get(m) < target){
                l = m + 1;
            }else{
                h = m;
            }
        }
        
        return l;
    }
}