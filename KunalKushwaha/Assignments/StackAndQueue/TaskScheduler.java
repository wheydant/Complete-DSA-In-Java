package KunalKushwaha.Assignments.StackAndQueue;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class TaskScheduler {
	public int leastInterval(char[] tasks, int n) {
		// Queue to store the wait and pop time - As time remains constant
		// Priority queue to pop the most frequent one
		Queue<int[]> queue = new LinkedList<>();
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

		Arrays.sort(tasks);

		int count = 1;

		for (int i = 1; i < tasks.length; i++) {
			if (tasks[i] != tasks[i - 1]) {
				pq.add(count);
				count = 0;
			}
			count++;
		}
		pq.add(count);

		int time = 1;
		while (!pq.isEmpty() || !queue.isEmpty()) {
			if (!queue.isEmpty()) {
				int[] temp = queue.peek();
				if (temp[1] == time) {
					queue.poll();
					pq.add(temp[0]);
				}
			}
			if (!pq.isEmpty()) {
				int currTask = pq.poll();
				if(!(currTask == 1))
					queue.add(new int[] { currTask - 1, time + n + 1});
			}
			time++;
		}

		return time;
	}

	public static void main(String[] args) {
		System.out.println(new TaskScheduler().leastInterval(new char[] { 'A', 'A', 'A', 'B', 'B'}, 2));
	}
}
