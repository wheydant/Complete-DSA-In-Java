package Striver.GreedyAlgorithm.Leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SingleTreadedCPU {
    public static int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        int[] ans = new int[n];
        int[][] tasksWithIndex = new int[n][3];
        for(int i = 0; i < n; i++){
            tasksWithIndex[i][0] = i;
            tasksWithIndex[i][1] = tasks[i][0];
            tasksWithIndex[i][2] = tasks[i][1];
        }

        Arrays.sort(tasksWithIndex, (a, b) -> a[1] - b[1]);

        //Imp we can specify the way priority queue will follow the logic
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[2] == b[2]? a[0] - b[0]: a[2] - b[2]);

        int time = 0;
        int ansIndex = 0;
        int taskIndex = 0;

        while(ansIndex < n){
            while(taskIndex < n && tasksWithIndex[taskIndex][1] <= time){
                pq.offer(tasksWithIndex[taskIndex++]);
            }
            //When queue is empty i.e. no process starts at 0 then jump to the lowest time
            if(pq.isEmpty()){
                time = tasksWithIndex[taskIndex][1];
                continue;
            }
            int[] bestFit = pq.poll();
            ans[ansIndex++] = bestFit[0];
            time += bestFit[2];
        }

        return ans;
    }
    public static void main(String[] args) {
        int[][] tasks = {{1,2},{2,4},{3,2},{4,1}};
        System.out.println(Arrays.toString(getOrder(tasks)));
    }
}
