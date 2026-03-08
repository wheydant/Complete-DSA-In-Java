package KunalKushwaha.Assignments.StackAndQueue;

import java.util.Arrays;
import java.util.Stack;

public class FindTheMostCompetitiveSubsequence {
	public int[] mostCompetitive(int[] nums, int k) {
		// Track number of elements to remove
		int toRemove = nums.length - k;
		Stack<Integer> st = new Stack<>();
		for (int i = 0; i < nums.length; i++) {
			int num = nums[i];
			if (toRemove == 0) {
				st.push(num);
				continue;
			}
			while (!st.isEmpty() && st.peek() > num && toRemove > 0) {
				st.pop();
				toRemove--;
			}
			st.push(num);
		}
		while (toRemove != 0) {
			st.pop();
			toRemove--;
		}
		int[] mostComp = new int[k--];
		while (!st.isEmpty()) {
			mostComp[k--] = st.pop();
		}

		return mostComp;
	}
	public static void main(String[] args) {
		System.out.println(Arrays.toString(new FindTheMostCompetitiveSubsequence().mostCompetitive(new int[]{2,4,3,3,5,4,9,6}, 4)));
	}
}
