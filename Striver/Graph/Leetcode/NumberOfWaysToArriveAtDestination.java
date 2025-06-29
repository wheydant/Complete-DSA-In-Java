package Striver.Graph.Leetcode;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class NumberOfWaysToArriveAtDestination{
    //Number of shortest path. Counting Number of paths reaching in shortest path is wrong intuition
    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int[] road : roads) {
            adj.get(road[0]).add(new int[]{road[1], road[2]});
            adj.get(road[1]).add(new int[]{road[0], road[2]});
        }
        
        // Dist can be more according to problem
        // int[] dist = new int[n];
        long[] dist = new long[n];
        int[] ways = new int[n];

        for(int i = 0; i < n; i++){
            dist[i] =  Long.MAX_VALUE;
            ways[i] = 0;
        }

        dist[0] = 0;
        ways[0] = 1;

        int mod = 1_000_000_007;

        //{dist, node}
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));

        pq.offer(new long[]{0, 0});

        while(!pq.isEmpty()){
            long[] curr = pq.poll();
            long dis = curr[0];
            int node = (int)curr[1];

            if (dis > dist[node]) continue;

            for(int[] it : adj.get(node)){
                int adjNode = it[0];
                int adjDis = it[1];

                if(adjDis + dis == dist[adjNode]){
                    ways[adjNode] = (ways[adjNode] + ways[node])%mod;
                }else if(adjDis + dis < dist[adjNode]){
                    dist[adjNode] = adjDis + dis;
                    ways[adjNode] = ways[node];
                    pq.offer(new long[]{dist[adjNode], adjNode});
                }
            }
        }

        return ways[n - 1] % mod;
    }
}