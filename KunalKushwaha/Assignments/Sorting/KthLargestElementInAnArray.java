package KunalKushwaha.Assignments.Sorting;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

public class KthLargestElementInAnArray {

    public int findKthLargestTLENoSort(int[] nums, int k) {
        int n = nums.length;
        boolean[] map = new boolean[n];
        int max = nums[0];

        while(k != 0){
            int currMax = -1;
            // find the first unused element to initialize currMax
            for (int i = 0; i < n; i++) {
                if (!map[i]) {
                    currMax = i;
                    break;
                }
            }

            for (int i = 0; i < n; i++) {
                if (map[i]) continue;
                if (nums[currMax] < nums[i]) {
                    currMax = i;
                }
            }

            map[currMax] = true;
            max = nums[currMax];
            k--;
        }

        return max;
    }
    public int findKthLargestSort(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;

        return nums[n - k];
    }
    public int findKthLargestMinHeap(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(k); // min-heap
        for (int x : nums) {
            if (pq.size() < k) {
                pq.offer(x);
            } else if (x > pq.peek()) {
                pq.poll();
                pq.offer(x);
            }
        }
        return pq.peek();
    }

    private final Random rand = new Random();

    public int findKthLargestQuickSelect(int[] nums, int k) {
        int target = nums.length - k;     // k-th largest -> (n-k)-th smallest
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int p = randomizedPartition(nums, l, r);
            if (p == target) return nums[p];
            if (p < target) l = p + 1;
            else r = p - 1;
        }
        throw new IllegalStateException("Unreachable");
    }

    private int randomizedPartition(int[] a, int l, int r) {
        int pivotIdx = l + rand.nextInt(r - l + 1);
        swap(a, pivotIdx, r);        // move pivot to end
        int pivot = a[r];
        int i = l;
        for (int j = l; j < r; j++) {
            if (a[j] <= pivot) swap(a, i++, j);
        }
        swap(a, i, r);
        return i;
    }

    private void swap(int[] a, int i, int j) {
        int t = a[i]; a[i] = a[j]; a[j] = t;
    }
}
