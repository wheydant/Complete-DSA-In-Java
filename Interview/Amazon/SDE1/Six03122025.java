package Interview.Amazon.SDE1;

import java.util.Arrays;

public class Six03122025 {

	// Q1
	int typeStrictMachine(String s) {
		int n = s.length();
		char first = s.charAt(0);
		char last = s.charAt(n - 1);

		int minLen = Integer.MAX_VALUE;

		// Find all possible start and end positions
		for (int i = 0; i < n; i++) {
			if (s.charAt(i) == first) {
				for (int j = i; j < n; j++) {
					if (s.charAt(j) == last) {
						minLen = Math.min(minLen, j - i + 1);
					}
				}
			}
		}

		return n - minLen;
	}

	int typeStrictMachineOptimized(String s) {
		int n = s.length();
		char first = s.charAt(0);
		char last = s.charAt(n - 1);

		int minWindow = Integer.MAX_VALUE;

		// Scan all possible l positions where s[l] == first
		for (int l = 0; l < n; l++) {
			if (s.charAt(l) != first)
				continue;

			// Scan forward to find smallest r >= l where s[r] == last
			for (int r = l; r < n; r++) {
				if (s.charAt(r) == last) {
					minWindow = Math.min(minWindow, r - l + 1);
					break; // break because choosing the earliest r minimizes window
				}
			}
		}

		return n - minWindow;
	}

	// Q2
	public int maximumPackageWithEqualCost(int[] itemCost) {
		int n = itemCost.length;
		int total = 0;
		for (int x : itemCost)
			total += x;

		// try maximum number of packages first
		for (int k = n; k >= 1; k--) {
			if (total % k != 0)
				continue;

			int target = total / k;
			if (canForm(itemCost, target, k)) {
				return k;
			}
		}
		return 1; // fallback
	}

	private boolean canForm(int[] arr, int target, int k) {
		int[] nums = arr.clone();
		Arrays.sort(nums);

		int left = 0, right = nums.length - 1;
		int formed = 0;

		while (left <= right) {
			//If target is greater than last value ans can never be found
			if (nums[right] > target)
				return false;

			//Single greatest element can be a target
			if (nums[right] == target) {
				formed++;
				right--;
			} 
			// Try to make pair from first and last
			else if (nums[left] + nums[right] == target) {
				formed++;
				left++;
				right--;
			} 
			//If pair can reach target increase left 
			else if (nums[left] + nums[right] < target) {
				left++;
			} 
			// If pair surpassed target reduce right
			else {
				right--;
			}
		}
		return formed == k;
	}

	public static void main(String[] args) {
		// System.out.println(new Six03122025().typeStrictMachine("abade"));

		// System.out.println(new Six03122025().typeStrictMachine("abaceae"));

		// System.out.println(new
		// Six03122025().typeStrictMachineOptimized("addccabcaghc"));

		System.out.println(new Six03122025().maximumPackageWithEqualCost(new int[] { 1, 2, 3, 4, 5 })); // 3 package of
																										// 5

		System.out.println(new Six03122025().maximumPackageWithEqualCost(new int[] { 9, 1, 8, 2, 7, 3 })); // 3 package
																											// of 10

		System.out.println(new Six03122025().maximumPackageWithEqualCost(new int[] { 1, 1, 1, 1 })); // 4 package of 1
	}
}
