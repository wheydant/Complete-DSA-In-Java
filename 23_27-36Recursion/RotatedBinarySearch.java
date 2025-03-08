public class RotatedBinarySearch {
    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 1, 2};
        int target = 1;
        System.out.println(binarySearch(arr, target, 0, arr.length - 1));
    }
    static int binarySearch(int[] arr, int target, int start, int end){
        if(end < start){
            return -1;
        }
        int middle = end - (end - start)/2;
        if(arr[middle] == target){
            return middle;
        }
        if(arr[start] <= arr[middle]){
            if(target >= arr[start] && target <= arr[middle]){
                return binarySearch(arr, target, start, middle - 1);
            }else{
                return binarySearch(arr, target, middle  + 1, end);
            }
        }

        if(target >= arr[middle] && target <= arr[end]){
            return binarySearch(arr, target, middle + 1, end);
        }
        return binarySearch(arr, target, start, middle - 1);
    }
}
