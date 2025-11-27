package KunalKushwaha.Assignments.Recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    List<List<Integer>> combination = new ArrayList<>();
    void helper(List<Integer> currCombination, int[] candidates, int target, int i){
        if(target < 0) return;
        if(target == 0) {
            combination.add(new ArrayList<>(currCombination));
            return;
        }
        if(i == candidates.length) return;

        //Take
        int number = candidates[i];
        currCombination.add(number);
        helper(currCombination, candidates, target - number, i);

        //Not take
        currCombination.remove(currCombination.size() - 1);
        helper(currCombination, candidates, target, i + 1);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> currCombination = new ArrayList<>();
        int i = 0;
        helper(currCombination, candidates, target, i);
        return combination;
    }
    public static void main(String[] args) {
        System.out.println(new CombinationSum().combinationSum(new int[]{2,3,6,7}, 7));
    }
}
