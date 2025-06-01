
import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {8, 3, 4, 12, 5, 6};
        mergeSortInPlace(arr, 0, arr.length);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(mergeSort(arr)));
    }
    //Time complexity - O(N*log(N))
    //Space complexity - 
    static int[] mergeSort(int[] arr){
        //Base condition
        if(arr.length == 1){
            return arr;
        }
        int mid = arr.length/2;

        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));

        //mid is exclusive 
        int[] right = mergeSort(Arrays.copyOfRange(arr,mid, arr.length));

        return merge(left, right);
    }
    static int[] merge(int[] first, int[] second){
        int[] mix = new int[first.length + second.length];

        int i = 0;
        int j = 0;
        int k = 0;

        while(i < first.length && j < second.length){
            if(first[i] < second[j]){
                mix[k] = first[i];
                i++;
            }else{
                mix[k] = second[j];
                j++;
            }
            k++;
        }
        while(i < first.length){
            mix[k] = first[i];
            k++;
            i++;
        }
        while(j < second.length){
            mix[k] = second[j];
            k++;
            j++;
        }
        return mix;
    }

    static void mergeSortInPlace(int[] arr, int start, int end){
        if(end - start == 1){
            return;
        }
        int mid = (start + end)/2;

        mergeSortInPlace(arr, start, mid);

        mergeSortInPlace(arr, mid, end);

        mergeInPlace(arr, start, mid, end);
    }

    static void mergeInPlace(int[] arr, int start, int mid, int end){
        int[] mix = new int[end - start];
        int i = start;
        int j = mid;
        int k = 0;
        
        while(i < mid && j < end){
            if(arr[i] < arr[j]){
                mix[k] = arr[i];
                k++;
                i++;
            }else{
                mix[k] = arr[j];
                k++;
                j++;
            }
        }

        while(i < mid){
            mix[k] = arr[i];
            k++;
            i++;
        }
        while(j < end){
            mix[k] = arr[j];
            k++;
            j++;
        }
        // for(int l = 0; l < mix.length; l++){
        //     arr[start + l] = mix[l];
        // }
        System.arraycopy(mix, 0, arr, start, mix.length);
    }
}
