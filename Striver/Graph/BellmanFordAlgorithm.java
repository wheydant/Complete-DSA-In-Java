package Striver.Graph;

import java.util.Arrays;

public class BellmanFordAlgorithm {
    static int[] bellmanFord(int V, int[][] edges, int src){
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        //TC - V * E
        for(int i = 0; i < V - 1; i++){
            for(int[] it : edges){
                int u = it[0];
                int v = it[1];
                int wt = it[2];

                if(dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]){
                    dist[v] = dist[u] + wt;
                }
            }
        }

        //Nth Relaxation to check negative cycle
        for(int[] it : edges){
            int u = it[0];
            int v = it[1];
            int wt = it[2];

            if(dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]){
                return new int[]{-1};
            }
        }

        return dist;
    }
    public static void main(String[] args) {
        
        // Number of vertices in the graph
        int V = 5;

        // Edge list representation: {source, destination, weight}
        int[][] edges = new int[][] {
            {1, 3, 2},    
            {4, 3, -1},   
            {2, 4, 1},    
            {1, 2, 1},    
            {0, 1, 5}     
        };

        // Source vertex for Bellman-Ford algorithm
        int src = 0;

        // Run Bellman-Ford algorithm from the source vertex
        int[] ans = bellmanFord(V, edges, src);

        // Print shortest distances from the source to all vertices
        for (int dist : ans) 
            System.out.print(dist + " ");
    }
}
