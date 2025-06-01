package LeetCodeBS;
// https://leetcode.com/problems/split-array-largest-summation/description/
public class SplitArrayLargestsummation {
    public static int splitArray(int[] arr, int k){
        int min = 0;
        int max = 0;
        int start = 0;
        int end = 0;
        int[] nums = arr;
        for (int i = 0; i < nums.length; i++) {
            start = Math.max(start, nums[i]); // in the end of the loop this will contain the max item of the array
            end += nums[i];
            min = Math.max(start, nums[i]);
            max += nums[i];
        }

        while(min < max && start < end){
            int middle = min + (max - min)/2;
            int mid = start + (end - start) / 2;
            int partition = 1;
            int summation = 0;
            int sum = 0;
            int pieces = 1;
            for(int i = 0; i < arr.length; i++){
                summation += arr[i];
                if(summation > middle){
                    summation = arr[i];
                    partition++;
                }
                if (sum + arr[i] > mid) {
                    // you cannot add this in this subarray, make new one
                    // say you add this num in new subarray, then sum = num
                    sum = arr[i];
                    pieces++;
                } else {
                    sum += arr[i];
                }
            }
            if (pieces > k) {
                start = mid + 1;
            } else {
                end = mid;
            }
            if(partition <= k){
                max = middle;
            }else{
                min = middle + 1;
            }
        }
        return max;
    }
    public static int getMin(int[] arr){
        int min = Integer.MAX_VALUE;
        for(int element : arr){
            if(element < min){
                min = element;
            }
        }
        return min;
    }
    public static int getMax(int[] arr){
        int summation = 0;
        for(int element : arr){
            summation += element;
        }
        return summation;
    }
    public static void main(String[] args) {
        int[] arr = {1, 4, 4};
        int k = 3;
        System.out.println(splitArray(arr, k));
    }
}
