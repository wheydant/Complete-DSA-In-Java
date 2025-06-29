package Striver.Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class ShortestPathInWeightedUndirectedGraph {
    //We will use memorization from DP and backtrack
    public List<Integer> shortestPath(int n, int m, int edges[][]) {
        //  Code Here.
        ArrayList<ArrayList<int []>> adj = new ArrayList<>();
        //As it is 1 indexed
        for(int i =0; i <= n; i++){
            adj.add(new ArrayList<>());
        }

        //Edges stores U, V and Wt
        for(int i = 0; i < m; i++){
            adj.get(edges[i][0]).add(new int[]{edges[i][1], edges[i][2]});
            adj.get(edges[i][1]).add(new int[]{edges[i][0], edges[i][2]});
        }

        PriorityQueue<int []> pq = new PriorityQueue<>((x, y) -> x[0] - y[0]);

        int[] dist = new int[n + 1];
        //Memorization/Cache array
        int[] parent = new int[n + 1];

        for(int i = 0; i <= n; i++){
            dist[i] = Integer.MAX_VALUE;
            parent[i] = i;
        }

        dist[1] = 0;
        pq.add(new int[]{dist[1], 1});

        while(!pq.isEmpty()){
            int[] nodeWtPair = pq.poll();

            int node = nodeWtPair[1];
            int dis = nodeWtPair[0];

            for(int[] it : adj.get(node)){
                int adjNode = it[0];
                int adjWt = it[1];

                if(dis + adjWt < dist[adjNode]){
                    dist[adjNode] = dis + adjWt;
                    pq.add(new int[]{dist[adjNode], adjNode});
                    parent[adjNode] = node;
                }
            }
        }

        List<Integer> path = new ArrayList<>();

        //Couldn't reach
        if(dist[n] == Integer.MAX_VALUE){
            path.add(-1);
            return path;
        }

        int node = n;

        //Reverse backtrack
        while(parent[node] != node){
            path.add(node);
            node = parent[node];
        }

        //Need to add source
        path.add(1);
        Collections.reverse(path);

        return path;
    }
}
