package KunalKushwaha.Assignments.String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
//["00:00","12:34","23:59","03:21","16:45","07:30","20:15","22:22"]

public class MinimumTimeDifference {
    public int findMinDifference(List<String> timePoints) {
        int n = timePoints.size();
        List<Integer> timeStamps = new ArrayList<>();
        for(String timeStamp : timePoints){
            int mins = Integer.parseInt(timeStamp.substring(3, 5));
            int hours = Integer.parseInt(timeStamp.substring(0, 2));

            mins = mins + hours*60;
            timeStamps.add(mins);
            //Less than 12 hours add to check past 24 hour proximity
            if(mins <= 12*60){
                timeStamps.add(mins + 24*60);
            }
        }

        Collections.sort(timeStamps);

        int minMins = Integer.MAX_VALUE;
        for(int i = 1; i < timeStamps.size(); i++){
            minMins = Math.min(minMins, timeStamps.get(i) - timeStamps.get(i - 1));
        }

        return minMins;
    }

    public int findMinDifferenceOptimum(List<String> timePoints) {
        int[] minutes = new int[timePoints.size()];

        // Convert all time strings to minutes since 00:00
        for (int i = 0; i < timePoints.size(); i++) {
            String time = timePoints.get(i);
            int hour = Integer.parseInt(time.substring(0, 2));
            int min = Integer.parseInt(time.substring(3, 5));
            minutes[i] = hour * 60 + min;
        }

        // Sort the array
        Arrays.sort(minutes);

        int minDiff = Integer.MAX_VALUE;

        // Compare each pair of adjacent times
        for (int i = 0; i < minutes.length - 1; i++) {
            int diff = minutes[i + 1] - minutes[i];
            minDiff = Math.min(minDiff, diff);
        }

        // Don't forget the circular difference (last and first)
        int wrapAroundDiff = 1440 - minutes[minutes.length - 1] + minutes[0];
        minDiff = Math.min(minDiff, wrapAroundDiff);

        return minDiff;
    }

    public static void main(String[] args) {

        // System.out.println(12*60);
        System.out.println(
                new MinimumTimeDifference().findMinDifference(
                        Arrays.asList("00:00", "12:34", "23:59", "03:21", "16:45", "07:30", "20:15", "22:22")));
    }
}
