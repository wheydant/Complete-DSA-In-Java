package Striver.Graph;

import java.util.*;

public class DetectCycleInADirectedGraph {

    static boolean dfsCheck(int node, ArrayList<ArrayList<Integer>> adj, boolean[] vis, boolean[] pathVis){
        vis[node] = true;
        pathVis[node] = true;

        for(int it: adj.get(node)){
            if(!vis[it]) {
                if(dfsCheck(it, adj, vis, pathVis)) return true;
            } else if(pathVis[it]) {
                return true;
            }
        }

        pathVis[node] = false;
        return false;
    }
    //Kahns Algo
    static boolean bfsCheck(ArrayList<ArrayList<Integer>> adj){
        Queue<Integer> q = new ArrayDeque<>();

        int[] inDegree = new int[adj.size()];
        int count = 0;

        for (ArrayList<Integer> list : adj){
            for(Integer listNode : list)inDegree[listNode]++;
        }

        for(int i = 0; i < inDegree.length; i++){
            if(inDegree[i] == 0) q.offer(i);
        }

        while(!q.isEmpty()){
            int node = q.poll();
            count++;
            for(Integer it : adj.get(node)){
                inDegree[it]--;
                if(inDegree[it] == 0) q.offer(it);
            }
        }

        // Optional: Check for cycle
        return count != adj.size();
    }
    static boolean isCyclic(int V, int[][] edges){
        // Convert edge list to adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++) adj.add(new ArrayList<>());

        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]); // Directed edge
        }

        boolean[] vis = new boolean[V];
        boolean[] pathVis = new boolean[V];

        for(int i = 0; i < V; i++){
            if(!vis[i]){
                if(dfsCheck(i, adj, vis, pathVis)) return true;
            }
        }

        return bfsCheck(adj);
    }

    public static void main(String[] args)
    {
        int V = 4; // Number of vertices

        // Directed edges of the graph
        int[][] edges = {
            {0, 1},
            {0, 2},
            {1, 2},
            {2, 3},
            {3, 3}
        };

        System.out.println(isCyclic(V, edges) ? "true" : "false");
    }
}
