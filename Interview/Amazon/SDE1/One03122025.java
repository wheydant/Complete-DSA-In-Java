package Interview.Amazon.SDE1;

import KunalKushwaha.Assignments.LinkedList.ListNode;
import java.util.Arrays;

public class One03122025 {
	// Q1
	void reverse(ListNode head, ListNode ptr) {
		if (ptr.next == null)
			return;

		ListNode temp = ptr.next;
		ptr.next = ptr.next.next;
		temp.next = head.next;
		head.next = temp;

		reverse(head, ptr);
	}

	int maxPair(ListNode head) {
		ListNode tortoise = head;
		ListNode hair = head;
		ListNode tortoiseTail = head;
		while (hair != null && hair.next != null) {
			hair = hair.next.next;
			tortoiseTail = tortoise;
			tortoise = tortoise.next;
		}
		// Even number of Nodes
		ListNode reverseHead;
		if (hair == null) {
			reverseHead = tortoiseTail;
			reverse(reverseHead, tortoise);
		} else {
			reverseHead = tortoise;
			reverse(reverseHead, tortoise.next);
		}

		ListNode.print(head);
		System.out.println(reverseHead.val + " " + reverseHead.next.val);
		ListNode midPoint = reverseHead.next;

		int maxPair = Integer.MIN_VALUE;

		while (midPoint != null) {
			maxPair = Integer.max(maxPair, head.val + midPoint.val);
			head = head.next;
			midPoint = midPoint.next;
		}

		return maxPair;
	}

	// Q2
	int operationToSort(int[] weights, int[] dist) {
		int n = weights.length;

		// Create (weight, index) pairs
		int[][] arr = new int[n][3]; // weight, pos, dist
		for (int i = 0; i < n; i++) {
			arr[i][0] = weights[i];
			arr[i][1] = i;
			arr[i][2] = dist[i];
		}

		Arrays.sort(arr, (a, b) -> a[0] - b[0]);

		int operations = 0;
		for (int i = 1; i < n; i++) {
			// while this point is NOT strictly to the right of previous
			while (arr[i][1] <= arr[i - 1][1]) {
				arr[i][1] += arr[i][2]; // jump
				operations++;
			}
		}

		return operations;
	}

	public static void main(String[] args) {
		// ListNode head = new ListNode(1, new ListNode(2, new ListNode(1, new
		// ListNode(1, new ListNode(8, new ListNode(4))))));

		// System.out.println(new One03122025().maxPair(head));

		// head = new ListNode(1, new ListNode(2, new ListNode(1, new ListNode(1, new
		// ListNode(8)))));

		// System.out.println(new One03122025().maxPair(head));

		System.out.println(new One03122025().operationToSort(new int[] { 3, 6, 5, 2 }, new int[] { 4, 3, 2, 1 }));
	}
}
