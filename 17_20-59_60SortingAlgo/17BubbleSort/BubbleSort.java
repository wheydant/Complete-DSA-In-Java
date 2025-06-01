
import java.util.Arrays;

/*
 * Worst Case = O(n^2)
 * Best Case = O(n)
*/
public class BubbleSort {
    public static int[] bubbleSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            boolean swapped = false;
            for(int j = 0; j < arr.length - 1 - i; j++){
                if(arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if(!swapped){
                break;
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        int[] arr = {5, 1, 2, 3, 4};
        System.out.println(Arrays.toString(bubbleSort(arr)));
    }    
}
