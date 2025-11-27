package Leetcode.Contest;

import java.util.PriorityQueue;

public class MaximumTotalSubarrayValueII {
    public long maxTotalValue(int[] nums, int k) {
        PriorityQueue<Long> maxValue = new PriorityQueue<>();

        for(int i = 0; i < nums.length; i++){
            long max = 0;
            long min = (long)1e9;
            for(int j = i; j < nums.length; j++){
                max  = Math.max(max, nums[j]);
                min = Math.min(min, nums[j]);
                
                long value = max - min;
                maxValue.add(value);
                if(maxValue.size() > k){
                    maxValue.poll();
                }
                System.out.println(maxValue);
            }
        }

        long maxVals = 0;
        for(Long maxVal : maxValue) maxVals += maxVal;
        return maxVals;
    }
    public static void main(String[] args) {
        System.out.println(new MaximumTotalSubarrayValueII().maxTotalValue(new int[]{4,2,5,1}, 3));
    }
}
