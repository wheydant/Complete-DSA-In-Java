package Striver.Graph.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CheapestFlightWithinKStops {
    //Keeping dist as judging criteria in priority queue prevent us from reaching the dest with better stops to dist ratio so here key criteria to consider is stops. For stops there is unit incrimination thus no need of priority queue, queue is sufficient
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        //Create Graph
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        int m = flights.length;
        for(int i = 0; i < m; i++){
            adj.get(flights[i][0]).add(new int[]{flights[i][1], flights[i][2]});
        }

        Queue<int[]> q = new LinkedList<>();

        //{stop, node, dist}
        q.add(new int[]{0, src, 0});

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int currStops = curr[0];
            int currNode = curr[1];
            int currDist = curr[2];

            //No need to go to further cities
            if(currStops > k){
                continue;
            }
            for(int[] it : adj.get(currNode)){
                int adjNode = it[0];
                int nodeW = it[1];

                //Can take till k and +1 coz dst is not considered as stop
                if(currDist + nodeW < dist[adjNode] && currStops <= k){
                    dist[adjNode] = currDist + nodeW;
                    q.offer(new int[]{currStops + 1, adjNode, dist[adjNode]}); 
                }
            }
        }

        if(dist[dst] == Integer.MAX_VALUE) return -1;

        return dist[dst];
    }
}
