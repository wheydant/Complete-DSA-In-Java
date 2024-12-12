import java.util.Arrays;
/*
 * Worst Case = O(n^2)
 * Best Case = O(n^2)
*/
public class SelectionSort {
    public static int[] selectionSort(int[] arr){
        for(int i = 0; i < arr.length; i++){
            int max = 0;
            for(int j = 1; j < arr.length - i; j ++){
                if(arr[max] < arr[j]){
                    max = j;
                }
            }
            int temp = arr[max];
            arr[max] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 3, 0};
        System.out.println(Arrays.toString(selectionSort(arr)));
    }    
}
