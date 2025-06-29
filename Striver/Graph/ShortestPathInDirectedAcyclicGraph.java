package Striver.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class ShortestPathInDirectedAcyclicGraph {
    /*
    Using Topo Sort.
     * 1. It is weighted graph
     * 2. Steps -
     *      1. Do a Topo sort.
     *      2. Take the node out of stack and relax the edges.
     */
    public int[] shortestPath(int V, int E, int[][] edges) {
        // Code here
        ArrayList<ArrayList<int []>> adj = new ArrayList<>();

        //Create adjacency list
        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<int []>());
        }

        for(int i = 0; i < E; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            adj.get(u).add(new int[]{v, wt});
        }

        boolean vis[] = new boolean[V];
        Stack<Integer> st = new Stack<>();

        //Toposort
        for(int i = 0; i < V; i++){
            if(!vis[i]) topoSort(i, adj, vis, st);
        }

        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);

        //Dist array 
        dist[0] = 0;
        
        while(!st.isEmpty()){
            //St will always have the 1st node which is parent and no node is before it.
            int node = st.pop();
            for(int i = 0; i < adj.get(node).size(); i++){
                int v = adj.get(node).get(i)[0];
                int wt = adj.get(node).get(i)[1];

                if(dist[node] + wt < dist[v]){
                    dist[v] = dist[node] + wt;
                }
            }
        }

        return dist;
    }

    void topoSort(int node, ArrayList<ArrayList<int []>> adj, boolean vis[] ,Stack<Integer> st){
        vis[node] = true;
        for(int i = 0; i < adj.get(node).size(); i++){
            int v = adj.get(node).get(i)[0];
            if(!vis[v]) topoSort(v, adj, vis, st);
        }
        st.add(node);
    }

    public static void main(String[] args) {
        int V = 6;
        int E = 7;
        int[][] edges = {
            {0, 1, 2},
            {0, 4, 1},
            {1, 2, 3},
            {2, 3, 6},
            {4, 2, 2},
            {4, 5, 4},
            {5, 3, 1}
        };

        ShortestPathInDirectedAcyclicGraph q = new ShortestPathInDirectedAcyclicGraph();
        System.out.println(Arrays.toString(q.shortestPath(V, E, edges)));
    }
}
