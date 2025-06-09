package Striver.GreedyAlgorithm;

import java.util.Arrays;

public class FractionalKnapsack {
    //Arrays.deepToString(arr) -> to display 2 d array.
    public static void main(String[] args) {
        int[][] arr = {{100, 20} , {60, 10} ,{100, 50} ,{200, 50}};
        int w = 90;


        Arrays.sort(arr, (a, b) -> - (int)((a[0]/a[1] != b[0]/b[1]) ?a[0]/a[1] - b[0]/b[1] : a[0] - b[0]));
        System.out.println(Arrays.deepToString(arr));

        int totalVal = 0;
        int i = 0;
        while(w > 0 && i < arr.length){
            if(w - arr[i][1] < 0){
                totalVal += arr[i][0]/arr[i][1] * w;
                w = 0;
                break;
            }
            totalVal += arr[i][0];
            w -= arr[i][1];
            i++;
        }

        System.out.println(totalVal);
    }
}
