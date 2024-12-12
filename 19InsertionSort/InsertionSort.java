import java.util.Arrays;
/*
 * Worst Case = O(n^2)
 * Best Case = O(n)
*/
public class InsertionSort {
    public static int[] insertionSort(int[] arr){
        for(int i = 0; i < arr.length - 1; i++){
           for(int j = i + 1; j > 0; j--){
            if(arr[j] < arr[j - 1]){
                int temp = arr[j - 1];
                arr[j - 1] = arr[j];
                arr[j] = temp;
            }else{
                break;
            }
           }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 3, 0};
        System.out.println(Arrays.toString(insertionSort(arr)));
    }
}
