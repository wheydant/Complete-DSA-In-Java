//https://www.geeksforgeeks.org/find-position-element-sorted-array-infinite-numbers/

//To mimic infinite array we wont use arr.length
//We would follow reverse of binary search window we kept on dividing the window to half now we will increase the window by doubling it everytime we do it
public class PositionOfElementInInfiniteSortedArray {
    public static int binarySearch(int[] arr,int start, int end, int target){
        while(start <= end){
            int mid = end - (end-start)/2;
            if(arr[mid] > target){
                end = mid - 1;
            }else if(arr[mid] < target){
                start = mid + 1;
            }else{
                return mid;
            }
        }
        return -1;
    }
    public static int targetIndex(int[] arr,int target){
        int start = 0;
        int end = 1;
        while(arr[end] < target){
            int temp = end + 1;
            end = end + (end - start + 1)*2;
            start = temp;
        }
        return binarySearch(arr, start, end, target);
    }
    public static void main(String[] args) {
        int[] arr = {11, 44, 67, 68, 69, 70, 77 , 79, 80, 84, 89, 91, 122, 546, 6564};
        int target = 6;

        System.out.println(targetIndex(arr, target));
    }
}
