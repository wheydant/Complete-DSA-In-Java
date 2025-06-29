package Striver.Graph.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://www.youtube.com/watch?v=qrAub5z8FeA&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=55&ab_channel=takeUforward
//Bridges in Graph
public class CriticalConnectionsInANetwork {
    private int timer = 1;
    void dfs(int node, int parent, int[] vis, ArrayList<ArrayList<Integer>> adj, int[] tin, int[] low, List<List<Integer>> bridges){
        vis[node] = 1;
        tin[node] = low[node] = timer;
        timer++;

        for(Integer it : adj.get(node)){
            if(it == parent) continue;
            if(vis[it] == 0) {
                dfs(it, node, vis, adj, tin, low, bridges);

                //Take low time
                low[node] = Math.min(low[node], low[it]);
                
                //If low of adj is less than current time of insertion it can be visited from other part
                if(low[it] > tin[node]){
                    bridges.add(Arrays.asList(it, node));
                }
            }else{
                low[node] = Math.min(low[node], low[it]);
            }
        }
    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(List<Integer> it : connections){
            int u = it.get(0);
            int v = it.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] vis = new int[n];
        int[] tin = new int[n];
        int[] low = new int[n];

        List<List<Integer>> bridges = new ArrayList<>();

        dfs(0, -1, vis, adj, tin, low, bridges);

        return bridges;
    }
}
