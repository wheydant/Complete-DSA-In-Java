package KunalKushwaha.Assignments.Recursion;

import java.util.Arrays;

public class BubbleSort {
    static void swap(int i, int j, int[] arr){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    static void bubbleSort(int[] arr, int n){
        if(n == 1) return;
        for(int i = 0; i < n - 1; i++){
            if(arr[i] > arr[i + 1]) swap(i, i + 1, arr);
        }
        bubbleSort(arr, n - 1);
    }
    public static void main(String[] args) {
        int[] arr = new int[]{64, 34, 25, 12, 22, 11, 90}; 
        bubbleSort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }
}
