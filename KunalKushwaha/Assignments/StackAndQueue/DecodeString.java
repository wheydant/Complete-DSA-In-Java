package KunalKushwaha.Assignments.StackAndQueue;

import java.util.Stack;

public class DecodeString {
	public String decodeString(String s) {
		// It act like a reference variable
		int[] index = { 0 };
		// return decodeHelper(s, index).toString();

		// Simple advise! We adding each char to stack till we get ], in this case, we
		// can start decoding by taking last values from stack, process them (crate
		// string, and multiply to integer) and push back into stack, hope it will help
		// you to find right direction.
		Stack<Character> stack = new Stack<>();

		StringBuilder ans = new StringBuilder();

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch == ']') {
				// 1️. Extract substring inside [...]
				StringBuilder temp = new StringBuilder();
				while (!stack.isEmpty() && stack.peek() != '[') {
					temp.insert(0, stack.pop());
				}

				// Remove '['
				if (!stack.isEmpty() && stack.peek() == '[') {
					stack.pop();
				}

				// 2 Extract FULL number (handles 100, 23, 4567...)
				StringBuilder number = new StringBuilder();
				while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
					number.insert(0, stack.pop());
				}

				int num = Integer.parseInt(number.toString());

				// 3 Multiply substring
				String multiplied = temp.toString().repeat(num);

				// 4 Push multiplied chars back to stack
				for (char c : multiplied.toCharArray())
					stack.push(c);
			} else {
				stack.push(ch);
			}
		}

		// Final collection
		while (!stack.isEmpty())
			ans.insert(0, stack.pop());
		
		return ans.toString();
	}

	public static void main(String[] args) {
		System.out.println(new DecodeString().decodeString("3[a]2[bc]"));
		System.out.println(new DecodeString().decodeString("3[a2[bc]]"));
		System.out.println(new DecodeString().decodeString("3[a2[bc]]d"));
	}
}
