package LeetCode;
//https://leetcode.com/problems/peak-index-in-a-mountain-array/description/

//https://leetcode.com/problems/find-peak-element/description/
public class PeakIndexInAMountainArray {
    public static int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        //Key step to avoid <=
        while(start < end){
            int middle = start + (end - start)/2;
            //Peak can be our middle element as it's greater than next element i.e. descending order
            if(arr[middle] > arr[middle + 1]){
                end = middle;
            }else{
                //Next element is greater than definately it's a potential answer i.e. ascending order
                start = middle + 1;
            }
        }
        //Both start and end will hold the value
        return start;
    }
    public static void main(String[] args) {
        int[] arr = {0, 2,1, 0};
        System.out.println(peakIndexInMountainArray(arr));
    }
}
