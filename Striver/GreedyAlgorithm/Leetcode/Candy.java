package Striver.GreedyAlgorithm.Leetcode;

import java.util.Arrays;
//Crazy left and right approach Yaarrrrr
public class Candy {
    //TC - O(3n)
    //SC - O(2n)
    public static  int candy(int[] ratings) {
        int n = ratings.length;
        int[] left = new int[n];
        int[] right = new int[n];

        // Initialize everyone with 1 candy
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);

        left[0] = 1;
        right[n - 1] = 1;

        for(int i = 1; i < n; i++){
            if(ratings[i] > ratings[i - 1]){
                left[i] = left[i - 1] + 1;
            }
        }

        for(int i = n - 2; i >= 0; i--){
            if(ratings[i] > ratings[i + 1]){
                right[i] = right[i + 1] + 1;
            }
        }
        
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += Math.max(left[i], right[i]);
        }

        return sum;
    }
    public static  int candySingleArr(int[] ratings) {
        int n = ratings.length;
        int[] left = new int[n];

        // Initialize everyone with 1 candy
        Arrays.fill(left, 1);

        left[0] = 1;

        for(int i = 1; i < n; i++){
            if(ratings[i] > ratings[i - 1]){
                left[i] = left[i - 1] + 1;
            }
        }

        int right = 1, sum = left[n-1];
        for(int i = n - 2; i >= 0; i--){
            if (ratings[i] > ratings[i + 1]) {
                right++;
            } else {
                right = 1;
            }

            sum += Math.max(left[i], right);
        }

        return sum;
    }
    //Learn approach - Slop tracking https://www.youtube.com/watch?v=IIqVFvKE6RY&list=PLgUwDviBIf0rF1w2Koyh78zafB0cz7tea&index=12&t=936s&ab_channel=takeUforward

    public static  int candyOptimized(int[] ratings) {
        int sum = 1, i = 1;
        while(i < ratings.length){
            if(ratings[i] == ratings[i - 1]){
                sum++;
                i++;
                continue;
            }
            int peak = 1;
            while(i < ratings.length && ratings[i] > ratings[i - 1]){
                peak += 1;
                sum += peak;
                i++;
            }
            int down = 1;
            while(i < ratings.length && ratings[i] < ratings[i - 1]){
                sum += down;
                i++;
                down++;
            }
            if(down > peak){
                sum += down - peak;
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        int[] ratings = {1,0,2};
        System.out.println(candy(ratings));
    }
}
