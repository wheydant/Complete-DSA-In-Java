package LeetCode;

import java.util.Arrays;

// https://leetcode.com/problems/flipping-an-image/description/
public class FlippingAnImage {
    public static int[][] flipAndInvertImage(int[][] image) {
        for(int i = 0; i < image.length; i++){
            for(int j = 0; j < (image[i].length + 1)/2 ; j++){
                int swapPos = image[i].length - j - 1;
                int temp = image[i][j] ^ 1;
                image[i][j] = image[i][swapPos] ^ 1;
                image[i][swapPos] = temp;
            }
        }
        // for(int i = 0; i < image.length; i++){
        //     for(int j = 0; j < image[i].length/2 ; j++){
        //         int swapPos = image[i].length - j - 1;
        //         int temp = image[i][j];
        //         image[i][j] = image[i][swapPos];
        //         image[i][swapPos] = temp;
        //     }
        // }
        // for(int i = 0; i < image.length; i++){
        //     for(int j = 0; j < image[0].length; j++){
        //         if(image[i][j] == 1){
        //             image[i][j] = 0;
        //         }else{
        //             image[i][j] = 1;
        //         }
        //     }
        // }
        return image;
    }
    public static void main(String[] args) {
        int[][] image = {
            {1, 1, 0},
            {1, 0, 1},
            {0, 0, 0}
        };

        image = flipAndInvertImage(image);

        for (int[] row : image)

            // converting each row as string
            // and then printing in a separate line
            System.out.println(Arrays.toString(row));
    }
}
