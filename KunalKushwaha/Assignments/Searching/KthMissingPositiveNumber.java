package KunalKushwaha.Assignments.Searching;

public class KthMissingPositiveNumber {
    //Crazyyy
    public int findKthPositiveBrute(int[] arr, int k) {
        for(int i : arr){
			if(i <= k) k++; else break;
		}
        return k;
    }
    //Binary
    public int findKthPositive(int[] arr, int k) {
        int l = 0;
        int h = arr.length - 1;
        while (l <= h) {
            int mid = (l + h) / 2;
            int missingCount = arr[mid] - (mid + 1);
            if (missingCount < k) {
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        return l + k;
    }
}
