package LeetCode;
//https://leetcode.com/problems/find-in-mountain-array/description/
public class FindInMountainArray {
    public static class MountainArray{
        int[] arr = {1,2,3,5,3};
        public int get(int index){
            return arr[index];
        }
        public int length(){
            return arr.length;
        }
    }
    public static int findInMountainArray(int target, MountainArray mountainArr) {
        // int returnVal = -1;
        int peakIndex = findPeak(mountainArr);

        int targetAscending = agnosticBinarySearch(mountainArr, target, 0, peakIndex);
        if(targetAscending != -1){
            return targetAscending;
        }

        return agnosticBinarySearch(mountainArr, target, peakIndex, mountainArr.length() - 1);

    }
    public static int findPeak(MountainArray mountainArr){
        int start = 0;
        int end = mountainArr.length() - 1;
        while(start < end){
            int middle = start + (end - start)/2;
            if(middle < (mountainArr.length() - 1) && mountainArr.get(middle) > mountainArr.get(middle+1)){
                end = middle;
            }else{
                start = middle + 1;
            }
        }
        return start;
    }
    public static int agnosticBinarySearch(MountainArray mountainArr, int target, int start, int end){
        boolean isAscending = false;
        if(mountainArr.get(end) > mountainArr.get(start)){
            isAscending = true;
        }
        while(start <= end){
            int middle = start + (end - start)/2;
            if(mountainArr.get(middle) < target){
                start = isAscending?middle+1:start;
                end = isAscending?end:middle-1;
            }else if(mountainArr.get(middle) > target){
                start = isAscending?start:middle+1;
                end = isAscending?middle-1:end;
            }else{
                return middle;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        MountainArray mountainArray = new MountainArray();
        System.out.println(findInMountainArray(3, mountainArray));

    }
    
}
