package Interview.Amazon.SDE1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Three03122025 {
	public List<Integer> generateNewArray(List<Integer> arr, String state, int m) {
		//Recursive
		List<Integer> ans = new ArrayList<>();
		StringBuilder stateBuilder = new StringBuilder(state);
		// generateNewArrayHelper(arr, stateBuilder, m, ans, new ArrayList<>());

		// Greedy
		int n = state.length();
		boolean[] states = new boolean[n];

		for(int i = 0; i < n; i++){
			states[i] = state.charAt(i) == '1';
		}
		while(m > 0){
			int max = Integer.MIN_VALUE;
			for(int i = 0; i < arr.size(); i++){
				if(states[i] && arr.get(i) > max) max = arr.get(i);
			}

			ans.add(max);

			for(int i = states.length - 2; i >= 0; i--){
				if(states[i]){
					states[i + 1] = true;
				}
			}
			m--;
		}

		return ans;
	}

	//Will give TLE because of recursion
	void generateNewArrayHelper(List<Integer> arr, StringBuilder state, int m, List<Integer> ans, List<Integer> curr){
		if(m == 0){
			// System.out.println(curr);
			// System.out.println(ans);
			int n = Math.min(ans.size(), curr.size());

			for(int i = 0; i < n; i++){
				if(!Objects.equals(ans.get(i), curr.get(i))){
					if(curr.get(i) > ans.get(i)){
						ans.clear();
						ans.addAll(curr);
						return;
					}
				}
			}

			if(curr.size() > ans.size()){
				ans.clear();
				ans.addAll(curr);
			}
			return;
		}

		for(int i = 0; i < arr.size(); i++){
			if(state.charAt(i) == '1'){
				StringBuilder newState = new StringBuilder(state);

				for(int j = 0; j < state.length() - 1; j++){
					if(state.charAt(j) == '1'){
						newState.setCharAt(j + 1, '1');
					}
				}
				curr.add(arr.get(i));
				generateNewArrayHelper(arr, newState, m - 1, ans, curr);
				curr.remove(curr.size() - 1);
			}
		}
	}

	public static void main(String[] args) {
		System.out.println(new Three03122025().generateNewArray(List.of(10, 5, 7,6), "0101", 2));
	}
}
