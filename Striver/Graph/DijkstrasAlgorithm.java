package Striver.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstrasAlgorithm {
    static int[] dijkstra(int V,int[][][] graph, int src){
        //Creation of adj list
        List<List<int []>> adj = adjList(V, graph);


        //Min heap - Storing distance than node
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> x[0] - y[0]);

        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        dist[src] = 0;
        pq.add(new int[]{0, src});

        while(!pq.isEmpty()){
            int[] nodeDistPair = pq.poll();
            int dis = nodeDistPair[0];
            int node = nodeDistPair[1];

            for(int i = 0; i < adj.get(node).size(); i++){
                int edgeWeight = adj.get(node).get(i)[1];
                int adjNode = adj.get(node).get(i)[0];

                if(dis + edgeWeight < dist[adjNode]){
                    dist[adjNode] = dis + edgeWeight;
                    pq.add(new int[]{dist[adjNode], adjNode});
                }
            }
        }

        return dist;
    }
    static List<List<int []>> adjList(int V,int[][][] graph){
        List<List<int []>> adj = new ArrayList<>();

        for(int i = 0; i < V; i++){
            List<int []> neighbors = new ArrayList<>();
            for(int[] edges : graph[i]){
                neighbors.add(new int[]{edges[0], edges[1]});
            }
            adj.add(neighbors);
        }

        return adj;
    }
    public static void main(String[] args) {
        int[][][] graph = {
            {{1, 4}, {2, 4}},
            {{0, 4}, {2, 2}},
            {{0, 4}, {1, 2}, {3, 3}, {4, 1}, {5, 6}},
            {{2, 3}, {5, 2}},
            {{2, 1}, {5, 3}},
            {{2, 6}, {3, 2}, {4, 3}}
        };

        System.out.println(Arrays.toString(dijkstra(graph.length, graph, 0)));
    }
}
