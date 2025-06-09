package Striver.GreedyAlgorithm;

//Shortest Job first is the scheduling algo which performs jobs which is the shortest

import java.util.Arrays;

public class ShortestJobFirst {
    //Return average waiting time
    static int avgTime(int[] process){
        int time = 0;
        int waitingTime = 0;
        Arrays.sort(process);
        for(int p : process){
            waitingTime += time;
            time += p;
        }

        return (int)Math.floor(waitingTime/process.length);
    }
    public static void main(String[] args) {
        int[] process = {4, 3, 7, 1, 2};
        System.out.println(avgTime(process));
    }
}
