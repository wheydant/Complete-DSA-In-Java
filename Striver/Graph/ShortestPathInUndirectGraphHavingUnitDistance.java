package Striver.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInUndirectGraphHavingUnitDistance{
    public int[] shortestPath(ArrayList<ArrayList<Integer>> adj, int src) {
        // code here
        int[] dist = new int[adj.size()];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Queue<Integer> q = new LinkedList<>();
        q.offer(src);
        dist[src] = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            for(int it : adj.get(node)){
                if(dist[node] + 1 < dist[it]){
                    dist[it] = dist[node] + 1;
                    q.offer(it);
                }
            }
        }
        for(int i = 0; i < adj.size(); i++){
            if(dist[i] == Integer.MAX_VALUE) dist[i] = -1;        
        }
        return dist;
    }
}