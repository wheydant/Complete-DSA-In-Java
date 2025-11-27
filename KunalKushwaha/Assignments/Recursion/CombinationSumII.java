package KunalKushwaha.Assignments.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class CombinationSumII{
    void helper(int i, List<List<Integer>> combinationSum, List<Integer> currCombination, int sum, int[] candidates, int target){
		// System.out.println(currCombination);
		// System.out.println(combinationSum);
        if(i == candidates.length){
            if(sum == target){
                combinationSum.add(new ArrayList<>(currCombination));
            }
            return;
        }
		// System.out.println("here");
        //notTake
		helper(i + 1, combinationSum, currCombination, sum, candidates, target);
		
		//Take
		currCombination.add(candidates[i]);
		helper(i + 1, combinationSum, currCombination, sum + candidates[i], candidates, target);
		currCombination.remove(currCombination.size() - 1);
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> combinationSum = new ArrayList<>();
        List<Integer> currCombination = new ArrayList<>();
        helper(0, combinationSum, currCombination, 0, candidates, target);
		Collections.sort(combinationSum, new Comparator<List<Integer>>(){

			@Override
			public int compare(List<Integer> o1, List<Integer> o2) {
				// TODO Auto-generated method stub
				if(o1.size() == o2.size()){
					int i = 0;
					while(i < o1.size()){
						if(Objects.equals(o1.get(i), o2.get(i))){
							i++;
							continue;
						}
						return o1.get(i) - o2.get(i);
					}
				}
				return o1.size() - o2.size();
			}

		});

		System.out.println(combinationSum);
		for(int i = 1; i < combinationSum.size(); i++){
			List<Integer> first = combinationSum.get(i - 1);
			List<Integer> second = combinationSum.get(i);
			// System.out.println(first);
			// System.out.println(second);
			if(first.equals(second)){
				// System.out.println("Here for i -> " + i);
				combinationSum.remove(i);
				i--;
			}
		}

		Collections.sort(combinationSum, new Comparator<List<Integer>>(){

			@Override
			public int compare(List<Integer> o1, List<Integer> o2) {
				// TODO Auto-generated method stub
				// if(o1.size() == o2.size()){
				return o1.get(0) - o2.get(0);
				// }
				// return o1.size() - o2.size();
			}

		});
		return combinationSum;
    }
	
	public List<List<Integer>> combinationSum2Optimum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();

        dfs(candidates, target, 0, new ArrayList<Integer>(), res);
        return res;
    }

    private void dfs(int[] candidates, int target, int start, List<Integer> comb, List<List<Integer>> res) {
        if (target < 0) {
            return;
        }

        if (target == 0) {
            res.add(new ArrayList<Integer>(comb));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i-1]) {
                continue;
            }

            if (candidates[i] > target) {
				//Greater numbers ahead
                break;
            }

			comb.add(candidates[i]);
			dfs(candidates, target - candidates[i], i + 1, comb, res);
			comb.remove(comb.size() - 1);
		}
	}
	
	public static void main(String[] args) {
		System.out.println(new CombinationSumII().combinationSum2(new int[]{5,3,2,4,2,5,2,4,3}, 8));
	}
}