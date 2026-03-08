package KunalKushwaha.Assignments.StackAndQueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class DesignFrontMiddleBackQueue {
	class FrontMiddleBackQueue {
		// LHS last will be always mid
		Deque<Integer> lhs;
		Deque<Integer> rhs;

		public FrontMiddleBackQueue() {
			lhs = new ArrayDeque<>();
			rhs = new ArrayDeque<>();
		}

		// ---------- helpers ----------
		void rebalance() {
			if (lhs.size() > rhs.size() + 1) {
				rhs.offerFirst(lhs.pollLast());
			} else if (lhs.size() < rhs.size()) {
				lhs.offerLast(rhs.pollFirst());
			}
		}

		public void pushFront(int val) {
			lhs.offerFirst(val);
			rebalance();
		}

		public void pushMiddle(int val) {
			if (lhs.size() > rhs.size()) {
				rhs.offerFirst(lhs.pollLast());
			}
			lhs.offerLast(val);
		}

		public void pushBack(int val) {
			rhs.offerLast(val);
			rebalance();
		}

		public int popFront() {
			if (lhs.isEmpty() && rhs.isEmpty())
				return -1;

			int val;
			if (!lhs.isEmpty()) {
				val = lhs.pollFirst();
			} else {
				val = rhs.pollFirst();
			}
			rebalance();
			return val;
		}

		public int popMiddle() {
			if (lhs.isEmpty() && rhs.isEmpty())
				return -1;

			int val = lhs.pollLast();
			rebalance();
			return val;
		}

		public int popBack() {
			if (lhs.isEmpty() && rhs.isEmpty())
				return -1;

			int val;
			if (!rhs.isEmpty()) {
				val = rhs.pollLast();
			} else {
				val = lhs.pollLast();
			}
			rebalance();
			return val;
		}
	}
}
