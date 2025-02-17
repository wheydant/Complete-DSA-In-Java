public class BinarySearch {
    public static int recursionBinarySearch(int[] arr, int start, int end, int target){
        if(start > end){
            return -1;
        }

        int mid = end - (end - start)/2;

        if(arr[mid] == target){
            return mid;
        }else if(arr[mid] < target){
            return recursionBinarySearch(arr, mid + 1, end, target);
        }
        
        return recursionBinarySearch(arr, start, mid - 1, target);


    }

    public static int binarySearch(int[] arr, int target){

        int start = 0;
        int end = arr.length - 1;
        
        int ans = recursionBinarySearch(arr, start, end, target);

        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 8, 10, 15, 19};
        int target = 10;
        System.out.println(binarySearch(arr, target));
    }
}
