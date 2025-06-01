
import java.util.Arrays;

/*
 * When we know elements with range 1 - N only exist we can use cyclic sort which gives time complexity of O(n) 
*/
public class CyclicSort {
    public static int[] cyclicSort(int[] arr){
        int i = 0;
        while(i < arr.length){
            if(arr[i] != i + 1){
                int realPosOfi = arr[i] - 1;
                int temp = arr[i];
                arr[i] = arr[realPosOfi];
                arr[realPosOfi] = temp;
            }else{
                i++;
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        int[] arr = {1, 3, 2};
        System.out.println(Arrays.toString(cyclicSort(arr)));
    }   
}
