package KunalKushwaha.Assignments.Bitwise;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    void helper(int i, int[] nums, List<Integer> currSubset, List<List<Integer>> allSubsets){
        if(i == nums.length){
            allSubsets.add(new ArrayList<>(currSubset));
			// System.out.println(allSubsets);
            return;
        }
		//not take
        helper(i + 1, nums, currSubset, allSubsets);
        //Take
        currSubset.add(nums[i]);
		// System.out.println(currSubset);
        helper(i + 1, nums, currSubset, allSubsets);
        currSubset.remove(currSubset.size() - 1);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> currSubset = new ArrayList<>();
        List<List<Integer>> allSubsets = new ArrayList<>();
        helper(0, nums, currSubset, allSubsets);
        return allSubsets;
    }
	public List<List<Integer>> subsetsUsingBits(int[] nums) {
        int n = nums.length;
        List<List<Integer>> allSubsets = new ArrayList<>();
        int allSubsetCount = (int)Math.pow(2, n);

        for(int i = 0; i < allSubsetCount; i++){
            List<Integer> currSubset = new ArrayList<>();
            int bits = i;
            int index = 0;
            while(bits != 0){
                int bit = bits&1;
                if(bit == 1){
                    currSubset.add(nums[index]);
                }
                bits = bits>>1;
                index++;
            }
            allSubsets.add(currSubset);
        }

        return allSubsets;
    }
	public static void main(String[] args) {
		System.out.println(new Subsets().subsets(new int[]{1,2,3}));
	}
}
