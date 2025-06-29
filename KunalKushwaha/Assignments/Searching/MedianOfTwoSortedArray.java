package KunalKushwaha.Assignments.Searching;

public class MedianOfTwoSortedArray {
    //TC And SC - n + m
    public double findMedianSortedArraysNPlusM(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        int[] nums = new int[n + m];

        int n0 = 0;
        int n1 = 0;
        int n2 = 0;

        while(n1 < n && n2 < m){
            if(nums1[n1] < nums2[n2]) nums[n0++] = nums1[n1++];
            else nums[n0++] = nums2[n2++];
        }
        while(n1 < n) nums[n0++] = nums1[n1++];
        while(n2 < m) nums[n0++] = nums2[n2++];

        if(nums.length % 2 != 0){
            return (double)nums[nums.length/2];
        }else if(nums.length/2 - 1 < 0){
            return (double)(nums[nums.length/2] + 0)/2;
        }
        else{
            return (double)(nums[nums.length/2] + nums[nums.length/2 - 1])/2;
        }
    }

    //Two Pointer - TC O(n + m) SC - O(1)
    public double findMedianSortedArraysTP(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int i = 0, j = 0, m1 = 0, m2 = 0;

        // Find median.
        for (int count = 0; count <= (n + m) / 2; count++) {
            //m2 stores previous value
            m2 = m1;
            if (i != n && j != m) {
                if (nums1[i] > nums2[j]) {
                    m1 = nums2[j++];
                } else {
                    m1 = nums1[i++];
                }
            } else if (i < n) {
                m1 = nums1[i++];
            } else {
                m1 = nums2[j++];
            }
        }

        // Check if the sum of n and m is odd.
        if ((n + m) % 2 == 1) {
            return (double) m1;
        } else {
            double ans = (double) m1 + (double) m2;
            return ans / 2.0;
        }
    }
    //Log(n + m)
    public double findMedianSortedArraysBS(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        //Fetch possible numbers from smallest array length only makes our code more efficient
        if(n > m) return findMedianSortedArraysBS(nums2, nums1);

        int low = 0;
        int high = n;

        //How many numbers we want on the left
        int left = (n + m + 1)/2;
        int totalLen = n + m;

        while(low <= high){
            //Fancy way of writing divide by 2, take mid from nums1
            int mid1 = (low + high) >> 1;
            //take rest from mid2
            int mid2 = left - mid1;

            //If there are no l1/l2/r1/r2
            int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE;
            int r1 = Integer.MIN_VALUE, r2 = Integer.MIN_VALUE;

            if(mid1 < n) r1 = nums1[mid1];
            if(mid2 < m) r2 = nums2[mid2];

            if(mid1 - 1 >= 0) l1 = nums1[mid1 - 1];
            if(mid2 - 1 >= 0) l2 = nums2[mid2 - 1];

            //Pushing window
            //Cross check coz l1 and r1 are already sorted
            if(l1 <= r2 && l2 <= r1){
                //If odd
                if(totalLen % 2 == 1){
                    return Math.max(l1, l2);
                }else{
                    return (double)(Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                }
            } else if(l1 > r2) high = mid1 - 1;
            else low = mid1 + 1;
        }

        return 0;
    }
}
