package KunalKushwaha.Assignments.Recursion;

import java.util.ArrayList;
import java.util.List;

public class DivisibleSubset {
	void getSubsets(List<List<Integer>> allSubsets, List<Integer> currSubset, int[] arr, int i, int sum){
		if(i >= arr.length){
			if(sum % arr.length == 0) allSubsets.add(new ArrayList<>(currSubset));
			return;
		}
		//Not Take
		getSubsets(allSubsets, currSubset, arr ,i + 1, sum);
		//Take
		currSubset.add(arr[i]);
		getSubsets(allSubsets, currSubset, arr ,i + 1, sum + arr[i]);
		currSubset.remove(currSubset.size() - 1);
	}
	List<List<Integer>> allDivisibleSubsets(int[] arr){
		List<List<Integer>> allSubsets = new ArrayList<>();
		List<Integer> currSubset = new ArrayList<>();
		getSubsets(allSubsets, currSubset, arr, 0, 0);
		allSubsets.remove(0);
		return allSubsets;
	}
	public static void main(String[] args) {
		System.out.println(new DivisibleSubset().allDivisibleSubsets(new int[]{3,6,10}));
	}
}
