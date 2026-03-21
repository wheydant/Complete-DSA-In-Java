package Striver.DSASheet.Heap;

import java.util.ArrayList;
import java.util.PriorityQueue;

class ImplementMinHeap {
	class minHeap {

		ArrayList<Integer> minHeap;

		// Constructor
		public minHeap() {
			// Initialize your data members
			minHeap = new ArrayList<>();
		}

		public int getParent(int i) {
			return (i - 1) / 2;
		}

		public int getLeftChild(int i) {
			return 2 * i + 1;
		}

		public int getRightChild(int i) {
			return 2 * i + 2;
		}

		public void swap(int i, int j) {
			int temp = minHeap.get(i);
			minHeap.set(i, minHeap.get(j));
			minHeap.set(j, temp);
		}

		public void push(int x) {
			// Insert x into the heap
			minHeap.add(x);
			int positionX = minHeap.size() - 1;
			while (positionX > 0 && getParent(positionX) >= 0
					&& minHeap.get(positionX) < minHeap.get(getParent(positionX))) {
				swap(positionX, getParent(positionX));
				positionX = getParent(positionX);
			}
		}

		public void heapify(int i) {
			int smallest = i;
			if (getLeftChild(i) < minHeap.size() && minHeap.get(getLeftChild(i)) < minHeap.get(smallest)) {
				smallest = getLeftChild(i);
			}
			if (getRightChild(i) < minHeap.size() && minHeap.get(getRightChild(i)) < minHeap.get(smallest)) {
				smallest = getRightChild(i);
			}
			if (smallest != i) {
				swap(smallest, i);
				heapify(smallest);
			}
		}

		public void pop() {
			// Remove the top (minimum) element
			int lastIndex = minHeap.size() - 1;
			minHeap.set(0, minHeap.get(lastIndex));
			minHeap.remove(lastIndex);
			if (minHeap.size() > 0)
				heapify(0);
		}

		public int peek() {
			if (minHeap.size() > 0)
				return minHeap.get(0);
			return -1;
		}

		public int size() {
			return minHeap.size();
		}
	}

	class Lame {
		PriorityQueue<Integer> mh;

		// Constructor
		public Lame() {
			// Initialize your data members
			mh = new PriorityQueue<>();
		}

		public void push(int x) {
			// Insert x into the heap
			mh.offer(x);
		}

		public void pop() {
			// Remove the top (minimum) element
			mh.poll();
		}

		public int peek() {
			// Return the top element or -1 if empty
			if (mh.isEmpty())
				return -1;
			return mh.peek();
		}

		public int size() {
			// Return the number of elements in the heap
			return mh.size();
		}
	}
}