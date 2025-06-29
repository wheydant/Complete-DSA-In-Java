package Striver.Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MinimumMultiplicationsToReachEnd {
    //As we mod our solution with 10e5 thus range of number will be from 1 to 9999 this will be our dist array. Steps will increase by 1 thus we can use normal queue.
    int minimumMultiplications(int[] arr, int start, int end) {
        // Your code here
        Queue<int[]> q = new LinkedList<>();

        int[] dist = new int[100000];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[start] = 0;
        q.add(new int[]{start, 0});

        int mod = 100000;
        int n = arr.length;
        //O(100000*N)
        while(!q.isEmpty()){
            int[] nodePair = q.poll();
            int node = nodePair[0];
            int steps = nodePair[1];

            for(int i = 0; i < n; i++){
                int num = (arr[i]*node)%mod;
                if(steps + 1 < dist[num]){
                    dist[num] = steps + 1;
                    if(num == end)return steps + 1;
                    q.offer(new int[]{num, dist[num]});
                }
            }
        }

        return -1;
    }
}
