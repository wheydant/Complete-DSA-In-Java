package KunalKushwaha.Assignments.Recursion;

import java.util.Arrays;

public class InsertionSort {
    static void insertionSort(int[] arr, int n){
        if(n <= 1) return;
        
        //Sort for lowest
        insertionSort(arr, n - 1);

        int last = arr[n - 1];
        // System.out.println(ele);
        int i = n - 2;
        while (i >= 0 && arr[i] > last){
            arr[i+1] = arr[i];
            i--;
        }
        arr[i + 1] = last;
        System.out.println(Arrays.toString(arr));
    }
    public static void main(String[] args)
    {
        int arr[] = {12, 11, 13, 5, 6};
     
        insertionSort(arr, arr.length);
        
        System.out.println(Arrays.toString(arr));
    }
}
