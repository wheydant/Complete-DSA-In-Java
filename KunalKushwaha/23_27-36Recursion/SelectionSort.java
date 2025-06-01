
import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {2, 5, 3, 4, 7, 0, 1};
        selectionSort(arr, arr.length - 1, 0, 0);
        System.out.println(Arrays.toString(arr));
    }
    static void selectionSort(int[] arr, int r, int c, int max){
        if(r == 0){
            return;
        }
        if(c < r){
            if(arr[c] > arr[max]){
                selectionSort(arr, r, c + 1, c);
            }else{
                selectionSort(arr, r, c + 1, max);
            }
        }else{
            swap(arr, max, r);
            selectionSort(arr, r - 1, 0, 0);
        }
    }
    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
