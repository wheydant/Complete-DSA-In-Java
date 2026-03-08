package KunalKushwaha.Assignments.StackAndQueue;

import java.util.Stack;

public class DeleteMiddleElemetOfAStack {
	public void deleteMid(Stack<Integer> s) {
		if (s.isEmpty())
			return;

		Stack<Integer> temp = new Stack<>();
		int mid = s.size() / 2;

		// Move elements until middle
		for (int i = 0; i < mid; i++) {
			temp.push(s.pop());
		}

		// Remove middle element
		s.pop();

		// Restore elements
		while (!temp.isEmpty()) {
			s.push(temp.pop());
		}
	}

	public void deleteMidRec(Stack<Integer> s) {
		delete(s, s.size() / 2);
	}

	private void delete(Stack<Integer> s, int k) {
		if (k == 0) {
			s.pop();
			return;
		}
		int top = s.pop();
		delete(s, k - 1);
		s.push(top);
	}
}
