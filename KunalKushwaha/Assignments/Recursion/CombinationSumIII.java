package KunalKushwaha.Assignments.Recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CombinationSumIII{
	public List<List<Integer>> combinationSum3(int k, int n) {
		Map<String, Boolean> combinationMap = new HashMap<>();
		List<List<Integer>> allCombination = new ArrayList<>();
		
		boolean[] vis = new boolean[10];
		vis[0] = true;

		helper(vis, new ArrayList<>(), allCombination, k, n, combinationMap);

		// for(List<Integer> l : allCombination){
		// 	Collections.sort(l);
		// }

		// Collections.sort(allCombination, (List<Integer> o1, List<Integer> o2) -> {
        //             for(int i = 0; i < o1.size(); i++){
        //                 if(Objects.equals(o1.get(i), o2.get(i))) continue;
        //                 return o1.get(i) - o2.get(i);
        //             }
        //             return o1.size() - o2.size();
        //         });

		// for(int i = 1; i < allCombination.size(); i++){
		// 	List<Integer> l1 = allCombination.get(i - 1);
		// 	List<Integer> l2 = allCombination.get(i);

		// 	if(l1.equals(l2)) {
		// 		allCombination.remove(i);
		// 		i--;
		// 	}
		// }

		return allCombination;
	}

	private void helper(boolean[] vis, List<Integer> currCombination, List<List<Integer>> allCombination, int k, int n, Map<String, Boolean> combinationMap) {
		if(k == 0){
			if(n == 0){
				List<Integer> tempCombination = new ArrayList<>(currCombination);
				Collections.sort(tempCombination);
				StringBuilder key = new StringBuilder();
				for(Integer i: tempCombination) key.append(i);
				if(!combinationMap.containsKey(key.toString())){
					allCombination.add(tempCombination);
					combinationMap.put(key.toString(), true);
				}
			}
			return;
		}
		if(n < 0) return;

		for(int i = 1; i < 10; i++){
			if(!vis[i]){
				currCombination.add(i);
				vis[i] = true;
				helper(vis, currCombination, allCombination, k - 1, n - i, combinationMap);
				vis[i] = false;
				currCombination.remove(currCombination.size() - 1);
			}
		}
	}

	public static void generate(int index, int sum, int[] arr, List<Integer> res, List<List<Integer>> list, int n, int k){

        //base condition
        if(sum == n && res.size() == k){
            list.add(new ArrayList<>(res));
            return;
        }

        if(index == arr.length || sum > n){
            return;
        }

        res.add(arr[index]);
        generate(index+1,sum+arr[index],arr,res,list,n,k);

        res.remove(res.size()-1);
        generate(index+1,sum,arr,res,list,n,k);

    }

    public List<List<Integer>> combinationSum3Easy(int k, int n) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        int[] arr = {1,2,3,4,5,6,7,8,9};

        generate(0,0,arr,res,list,n,k);
        return list;
    }

	public static void main(String[] args) {
		System.out.println(new CombinationSumIII().combinationSum3(3, 9));
	}
}