package Leetcode.Contest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MinimumDistanceBetweenThreeElement {
    public int minimumDistance(int[] nums) {
		HashMap<Integer, List<Integer>> map = new HashMap<>();
		for(int i = 0; i < nums.length; i++){
			List<Integer> currList;
			if(!map.containsKey(nums[i])){
				// index, distance.
				currList = new ArrayList<>();
			}else{
				currList = map.get(nums[i]);
			}
			currList.add(i);
			map.put(nums[i], currList);
		}
		int minDistance = Integer.MAX_VALUE;
		for(var el:map.keySet()){
			List<Integer> currList = map.get(el);
			System.out.println(currList);
            int n = currList.size();
			if(n >= 3){
				// System.out.println("Entered");
                for(int i = 0; i + 3 <= n; i++){
					// System.out.println("Entered");
    				minDistance = Math.min(minDistance, Math.abs(currList.get(i + 0) - currList.get(i + 1)) + Math.abs(currList.get(i + 1) - currList.get(i + 2)) + Math.abs(currList.get(i + 0) - currList.get(i + 2)));
				}
			}
		}
        return (minDistance == Integer.MAX_VALUE)? -1:minDistance;
    }
	public static void main(String[] args) {
		System.out.println(new MinimumDistanceBetweenThreeElement().minimumDistance(new int[]{1,2,1,1,3}));
	}
}
