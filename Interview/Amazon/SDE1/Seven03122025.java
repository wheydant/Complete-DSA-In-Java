package Interview.Amazon.SDE1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Seven03122025 {

	// Q1
	int getMinNumMoves(int[] blocks) {
		int count = 0;
		// for(int i = 0; i < blocks.length; i++){
		// // System.out.println("Entered");
		// boolean isSwapped = false;
		// for(int j = 1; j < blocks.length - i; j++){
		// if(blocks[j - 1] > blocks[j]){
		// isSwapped = true;
		// int temp = blocks[j - 1];
		// blocks[j - 1] = blocks[j];
		// blocks[j] = temp;
		// count++;
		// }
		// }
		// if(!isSwapped) break;
		// }

		int iMin = -1;
		int min = Integer.MAX_VALUE;
		int iMax = -1;
		int max = Integer.MAX_VALUE;
		for (int i = 0; i < blocks.length; i++) {
			if (blocks[i] < min) {
				iMin = i;
				min = blocks[i];
			}
			if (blocks[i] > max) {
				iMax = i;
				max = blocks[i];
			}
		}

		// If iMin > iMax we will be calculating single swap twice
		count = iMin + (blocks.length - iMax - 1) - (iMin > iMax ? 1 : 0);
		return count;
	}

	// Q2
	long countDistinctPasswords(String password) {
		Map<String, Boolean> map = new HashMap<>();
		map.put(password, true);
		int n = password.length();
		HashSet<String> set = new HashSet<>();

		//For each index try reversing 2, 3 .. n - 1 times.
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) { // only length ≥ 2
				StringBuilder sb = new StringBuilder(password);
				String reversed = new StringBuilder(password.substring(i, j + 1)).reverse().toString();
				sb.replace(i, j + 1, reversed);
				set.add(sb.toString());
			}
		}

		return set.size() + 1; // +1 for original string
		// return 1 + countDistinctPasswordsHelper(2, password, map);
	}

	int countDistinctPasswordsHelper(int subStringLen, String password, Map<String, Boolean> map) {
		if (subStringLen > password.length()) {
			return 0;
		}
		StringBuilder newPass = new StringBuilder(password);
		int count = 0;
		for (int i = 0; i + subStringLen <= password.length(); i++) {
			StringBuilder revString = new StringBuilder(password.substring(i, i + subStringLen));
			revString.reverse();
			StringBuilder tempPass = new StringBuilder(newPass);
			tempPass.replace(i, i + subStringLen, revString.toString());
			if (!map.containsKey(tempPass.toString())) {
				count++;
				map.put(tempPass.toString(), true);
			}
		}

		return count + countDistinctPasswordsHelper(subStringLen + 1, password, map);
	}

	public static void main(String[] args) {
		// System.out.println(new Seven03122025().getMinNumMoves(new int[]{3, 2, 1, 5,
		// 4}));

		// System.out.println(new Seven03122025().getMinNumMoves(new int[]{2, 4, 3, 1,
		// 6}));

		System.out.println(new Seven03122025().countDistinctPasswords("abc"));

		System.out.println(new Seven03122025().countDistinctPasswords("abaa"));
	}
}
