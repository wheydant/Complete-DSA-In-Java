package KunalKushwaha.Assignments.Bitwise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SubsetsII {

	public List<List<Integer>> subsetsWithDup(int[] nums) {
		Arrays.sort(nums);
		List<Integer> currSubset = new ArrayList<>();
		List<List<Integer>> allSubsets = new ArrayList<>();
		helper(0, nums, currSubset, allSubsets);
		return allSubsets;
	}

	void helper(int i, int[] nums, List<Integer> currSubset, List<List<Integer>> allSubsets) {
		if (i == nums.length) {
			allSubsets.add(new ArrayList<>(currSubset));
			return;
		}
		// take
		currSubset.add(nums[i]);
		helper(i + 1, nums, currSubset, allSubsets);
		currSubset.remove(currSubset.size() - 1);

		//If we skip 1,2 we must skip 1,2,2 and go to 3
		int j = i + 1;
		while (j < nums.length) {
			if (nums[i] == nums[j])
				j++;
			else
				break;
		}
		// notTake
		helper(j, nums, currSubset, allSubsets);
	}

	class poorSolution {
		public List<List<Integer>> subsetsWithDup(int[] nums) {
			Arrays.sort(nums);
			List<Integer> currSubset = new ArrayList<>();
			List<List<Integer>> allSubsets = new ArrayList<>();
			helper(0, nums, currSubset, allSubsets);
			// System.out.println(allSubsets);
			Collections.sort(allSubsets, (a, b) -> {
				// 1. Empty lists come first
				if (a.isEmpty() && b.isEmpty())
					return 0;
				if (a.isEmpty())
					return -1;
				if (b.isEmpty())
					return 1;

				// 2. Compare first element
				int cmp = Integer.compare(a.get(0), b.get(0));
				if (cmp != 0)
					return cmp;

				// 3. If first is equal, compare second, third, ...
				int n = Math.min(a.size(), b.size());
				for (int i = 1; i < n; i++) {
					cmp = Integer.compare(a.get(i), b.get(i));
					if (cmp != 0)
						return cmp;
				}

				// 4. If all equal so far, shorter list comes first
				return Integer.compare(a.size(), b.size());
			});

			for (int i = 1; i < allSubsets.size(); i++) {
				List<Integer> first = allSubsets.get(i - 1);
				List<Integer> second = allSubsets.get(i);
				// System.out.println(first);
				// System.out.println(second);
				if (first.equals(second)) {
					// System.out.println("Here for i -> " + i);
					allSubsets.remove(i);
					i--;
				}
			}

			return allSubsets;
		}

		void helper(int i, int[] nums, List<Integer> currSubset, List<List<Integer>> allSubsets) {
			if (i == nums.length) {
				allSubsets.add(new ArrayList<>(currSubset));
				// System.out.println(allSubsets);
				return;
			}
			// not take
			helper(i + 1, nums, currSubset, allSubsets);
			// Take
			currSubset.add(nums[i]);
			// System.out.println(currSubset);
			helper(i + 1, nums, currSubset, allSubsets);
			currSubset.remove(currSubset.size() - 1);
		}
	}

	public static void main(String[] args) {
		System.out.println(new SubsetsII().subsetsWithDup(new int[] { 1, 2, 2, 3 }));// [[],[1],[1,2],[1,2,2],[2],[2,2]]
	}
}
