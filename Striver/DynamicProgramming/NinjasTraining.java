package Striver.DynamicProgramming;

import java.util.Arrays;

public class NinjasTraining {
    /*
    Ninja is planing this ‘N’ days-long training schedule. Each day, he can perform any one of these three activities. (Running, Fighting Practice or Learning New Moves). Each activity has some merit points on each day. As Ninja has to improve all his skills, he can’t do the same activity in two consecutive days. Can you help Ninja find out the maximum merit points Ninja can earn?
    */

    //1. Approach can be greedy do most constructive for that day. But it fails {10, 50, 1},{1, 100, 11} => 50 + 11 = 61 which is wrong.

    /*
    Try all possible thus recursion -
    1. Index - days, also we need to keep track of task(0, 1, 2, 3 -> no tasks performs initial stage)of previous index.
    2. Do stuff - Following top down from n - 1 to 0.
    3. Find max - 
    */
    public static int ninjaTraining(int n, int points[][]) {
        // return helperRec(n - 1, points, 3);

        int[][] dp = new int[n][4];
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i], -1);
        }
        System.out.println(Arrays.deepToString(dp));
        // return helperMem(n - 1, points, 3, dp);

        // return helperTab(n, points);

        return helperSO(n, points);

    }
    static int helperRec(int day, int points[][], int task){
        
        //Base case if its the last day just fetch the max points that can be earned while not considering past task
        if(day == 0){
            int max = Integer.MIN_VALUE;
            for(int i = 0; i < 3; i++){
                int curr = Integer.MIN_VALUE;
                if(i != task){
                    curr = points[day][i];
                }
                max = Math.max(max, curr);
            }
            return max;
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < 3; i++){
            int curr = Integer.MIN_VALUE;
            if(i != task){
                curr = points[day][i] + helper(day - 1, points, i);
            }
            max = Math.max(curr, max);
        }

        return max;
    }

    static int helperMem(int day, int points[][], int last, int[][] dp){

        if(dp[day][last] != -1) return dp[day][last];

        if (day == 0) {
            int maxi = 0;
            for (int i = 0; i <= 2; i++) {
                if (i != last)
                    maxi = Math.max(maxi, points[0][i]);
            }
            return dp[day][last] = maxi; // Store and return the result
        }


        int maxi = 0;
        // Loop through the three activities on the current day
        for (int i = 0; i <= 2; i++) {
            if (i != last) {
                // Calculate the points for the current activity and recursively
                // calculate the maximum points for the previous day
                int activity = points[day][i] + helperMem(day - 1, points, i, dp);
                maxi = Math.max(maxi, activity); // Update the maximum points
            }
        }

        return dp[day][last] = maxi;
    }
    
    static int helperTab(int n, int points[][]){
        int[][] dp = new int[n][4];
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i], -1);
        }

        //On 0th day - task 0 => 1 & 2; task 1 => 0 & 2; task 2 => 0 & 1;
        dp[0][0] = Math.max(points[0][1], points[0][2]);
        dp[0][1] = Math.max(points[0][0], points[0][2]);
        dp[0][2] = Math.max(points[0][0], points[0][1]);
        dp[0][3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        // Loop through the three activities on the current day
        for (int day = 1; day < n; day++) {
            //This was little complex
            for(int last = 0; last < 4; last++){
                dp[day][last] = 0;

                for(int task = 0; task < 3; task++){
                    if(task != last){
                        //As we are just dependant on day - 1 thus we can optimize
                        int point = points[day][task] + dp[day - 1][task];
                        dp[day][last] = Math.max(dp[day][last], point);
                    }
                }
            }
        }

        //Initial recursion call
        return dp[n - 1][3];
    }

    static int helperSO(int n, int points[][]){
        int[] prev = new int[4];

        //On 0th day - task 0 => 1 & 2; task 1 => 0 & 2; task 2 => 0 & 1;
        prev[0] = Math.max(points[0][1], points[0][2]);
        prev[1] = Math.max(points[0][0], points[0][2]);
        prev[2] = Math.max(points[0][0], points[0][1]);
        prev[3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        // Loop through the three activities on the current day
        for (int day = 1; day < n; day++) {
            //This was little complex
            int[] temp = new int[4];
            for(int last = 0; last < 4; last++){
                temp[last] = 0;

                for(int task = 0; task < 3; task++){
                    if(task != last){
                        //As we are just dependant on day - 1 thus we can optimize
                        temp[last] = Math.max(temp[last], points[day][task] + prev[task]);
                    }
                }
            }
            prev = temp;
        }

        //Initial recursion call
        return prev[3];
    }
    public static void main(String[] args) {
        int[][] points = {
            {10 ,40 ,70},
            {20 ,50 ,80},
            {30 ,60 ,90}
        };
        int n = points.length;
        System.out.println(ninjaTraining(n, points));
    }
}
