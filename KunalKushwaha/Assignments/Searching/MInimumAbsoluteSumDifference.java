package KunalKushwaha.Assignments.Searching;

import java.util.Arrays;
import java.util.TreeSet;

public class MInimumAbsoluteSumDifference {
    public static int minAbsoluteSumDiffTLE(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] sortedNums1 = Arrays.copyOf(nums1, n);
        Arrays.sort(sortedNums1);

        long totalDiff = 0;
        int maxGain = 0;
        int mod = 1_000_000_7;
        for (int i = 0; i < n; i++) {
            int originalDiff = Math.abs(nums1[i] - nums2[i]);
            totalDiff += originalDiff;

            // Try to find a better replacement in sortedNums1
            int closest = findClosest(sortedNums1, nums2[i]);
            int improvedDiff = Math.abs(closest - nums2[i]);
            int gain = originalDiff - improvedDiff;
            maxGain = Math.max(maxGain, gain);
        }
        //Adding mod and then dividing by it gives original answer only but incase of sum exceed it returns correct ans
        totalDiff = (totalDiff - maxGain + mod) % mod;
        return (int) totalDiff;
    }
    static int findClosest(int[] arr, int target){
        int left = 0, right = arr.length - 1;
        int closest = arr[0];

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (Math.abs(arr[mid] - target) < Math.abs(closest - target)) {
                closest = arr[mid];
            } else if (Math.abs(arr[mid] - target) == Math.abs(closest - target)) {
                closest = Math.min(closest, arr[mid]); // take smaller if tie
            }

            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return closest;
    }
    //This solution works
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int maxDecrease = 0;
        int len = nums1.length;
        long sum = 0;
        int mod = (int)Math.pow(10,9) + 7;
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int num : nums1)
            treeSet.add(num);
        for (int i = 0; i < len; i++) {
            sum = sum + Math.abs(nums1[i] - nums2[i]);
            if (nums1[i] != nums2[i]) {
			    // use binary search to find the replacement value to minimize the abs diff for current nums2[i]
                Integer ceil = treeSet.ceiling(nums2[i]);
                Integer floor = treeSet.floor(nums2[i]);
                int diff = Math.abs(nums1[i] - nums2[i]);
                int max = 0;
                if (ceil != null) {
                    int val1 = Math.abs(ceil - nums2[i]);
                    max = Math.max(max, diff - val1);
                }
                if (floor != null) {
                    int val2 = Math.abs(floor - nums2[i]);
                    max = Math.max(max, diff - val2);
                }
				//find the biggest delta across the entire array
				//the delta is diff = orginal diff - diff after replacement
                maxDecrease = Math.max(max, maxDecrease);
            }
        }
        return (int)((sum - maxDecrease) % mod);
    }
    public static void main(String[] args) {
        int[] nums1 = {1,7,5};
        int[] nums2 = {2,3,5};

        System.out.println(minAbsoluteSumDiffTLE(nums1, nums2));
    }
}
