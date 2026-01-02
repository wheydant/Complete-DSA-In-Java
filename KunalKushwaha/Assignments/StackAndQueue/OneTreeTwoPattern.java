package KunalKushwaha.Assignments.StackAndQueue;

import java.util.Stack;

public class OneTreeTwoPattern {
	public boolean find132pattern(int[] nums) {
		Stack<Integer> stack = new Stack<>();
		int max = Integer.MIN_VALUE; // this will act as "2" in the 132 pattern

		for (int i = nums.length - 1; i >= 0; i--) {

			// this means nums[i] is the "1" of the 132 pattern
			if (nums[i] < max)
				return true;

			// find a number smaller than stack top to act as "2"
			while (!stack.isEmpty() && nums[i] > stack.peek()) {
				max = stack.pop();
			}

			stack.push(nums[i]);

			System.out.println(max);
			System.out.println(stack);
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(new OneTreeTwoPattern().find132pattern(new int[] {1, 2, 5 , 6, 4}));
		System.out.println(new OneTreeTwoPattern().find132pattern(new int[] {3,5,0,3,4}));
		// 132
		System.out.println(new OneTreeTwoPattern().find132pattern(new int[] { 1, 2, 3, 4, -4, -3, -5, -1 }));
	}
}
