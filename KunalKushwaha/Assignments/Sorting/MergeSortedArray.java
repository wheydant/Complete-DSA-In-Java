package KunalKushwaha.Assignments.Sorting;

public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = m - 1;
        int index2 = n - 1;
        int index = m + n - 1;

        while(index1 >= 0 && index2 >= 0){
            if(nums2[index2] > nums1[index1]){
                nums1[index--] = nums2[index2--];
            } else {
                nums1[index--] = nums1[index1--];
            }
        }

        while(index2 >= 0){
            nums1[index--] = nums2[index2--];
        }
    }

    public void mergeExtraSpace(int[] nums1, int m, int[] nums2, int n) {
        int[] ans = new int[m + n];
        int i = 0;
        int j = 0;
        int k = 0;
        while(i < m && j < n){
            if(nums1[i] <= nums2[j]){
                ans[k++] = nums1[i++];
            }else{
                ans[k++] = nums2[j++];
            }
        }
        while(i < m){
            ans[k++] = nums1[i++];
            
        }
        while(j < n){
            ans[k++] = nums2[j++];
        }

        for (i = 0; i < ans.length; i++) {
            nums1[i] = ans[i];
        }
    }
}
