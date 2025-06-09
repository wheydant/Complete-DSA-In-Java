package Striver.GreedyAlgorithm.Leetcode;

import java.util.Arrays;
/*
 * Sometimes might work correct for - https://youtu.be/QbwltemZbRg?si=TX7yZmbkntVEaL09
 * But Leetcode needs DP
*/
public class MaximumProfitInJobScheduling {
    static class Job{
        int startTime;
        int endTime;
        int profit;

        public Job(int startTime, int endTime, int profit) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.profit = profit;
        }

        @Override
        public String toString() {
            return "Jobs [startTime=" + startTime + ", endTime=" + endTime + ", profit=" + profit + "]";
        }

        
    }
    public static int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int maxProfit = 0;
        int maxTime = 0;
        Job[] jobs = new Job[startTime.length];
        for(int i = 0; i < startTime.length; i++){
            Job job = new Job(startTime[i], endTime[i], profit[i]);
            jobs[i] = job;
            maxTime = Math.max(maxTime, endTime[i]);
        }

        int[] time = new int[maxTime];
        Arrays.fill(time, -1);

        Arrays.sort(jobs, (j1, j2) -> -(j1.profit - j2.profit));

        for(int i = 0; i < jobs.length; i++){
            Job job = jobs[i];
            boolean canPerform = true;
            for(int j = job.startTime; j < job.endTime - 1; j++){
                if(time[j] != -1){
                    canPerform = false;
                    break;
                }
            }
            
            if(canPerform){
                maxProfit += job.profit;
                for(int j = job.startTime; j < job.endTime - 1; j++){
                    time[j] = i;
                }
            }
        }

        System.out.println(Arrays.toString(jobs));
        System.out.println(Arrays.toString(time));

        return maxProfit;
    }
    public static void main(String[] args) {
        int[] startTime = {1,2,3,3};
        int[] endTime = {3,4,5,6};
        int[] profit = {50,10,40,70};

        System.out.println(jobScheduling(startTime, endTime, profit));

        startTime = new int[]{1,2,3,4,6};
        endTime = new int[]{3,5,10,6,9};
        profit = new int[]{20,20,100,70,60};

        System.out.println(jobScheduling(startTime, endTime, profit));
    }
}
