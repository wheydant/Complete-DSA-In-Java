//https://www.geeksforgeeks.org/find-rotation-count-rotated-sorted-array/
public class RotationCountInARotatedSortedArray {
    public static int rotationCount(int[] arr){
        int start = 0;
        int end = arr.length - 1;
        int pivotElement = -1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(mid < end && arr[mid] > arr[mid + 1]){
                pivotElement = mid;
                break;
            }else if(start < mid && arr[mid] < arr[mid - 1]){
                pivotElement = mid - 1;
                break;
            }else if(arr[start] < arr[mid]){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        
        return pivotElement + 1;
    }
    public static void main(String[] args) {
        int[] arr = {2, 3, 6, 12};

        System.out.println(rotationCount(arr));
    }
}
