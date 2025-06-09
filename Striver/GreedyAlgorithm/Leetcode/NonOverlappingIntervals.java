package Striver.GreedyAlgorithm.Leetcode;

import java.util.Arrays;

public class NonOverlappingIntervals {
    //Remove maximum overlapping intervals
    public static int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length <= 0)return 0;
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        //Trying to solve using fir N meeting in a room.
        int count = 1, lastIndex = intervals[0][1];
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] >= lastIndex){
                count++;
                lastIndex = intervals[i][1];
            }
        }

        return intervals.length - count;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,2},{2,3},{3,4},{1,3}};

        System.out.println(eraseOverlapIntervals(intervals));
    }
}
