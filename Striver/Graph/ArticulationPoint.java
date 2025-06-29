package Striver.Graph;

import java.util.ArrayList;

public class ArticulationPoint {
    int timer = 1;
    void dfs(int node, int parent, int[] vis, int[] tin, int[] low, int[] mark, ArrayList<ArrayList<Integer>> adj){
        vis[node] = 1;
        tin[node] = low[node] = timer;
        timer++;
        int child = 0;
        
        for(Integer it: adj.get(node)){
            if(it == parent) continue;
            if(vis[it] == 0){
                dfs(it, node, vis, tin, low, mark, adj);
                low[node] = Math.min(low[node], low[it]);

                if(low[it] >= tin[node] && parent != -1){
                    mark[node] = 1;
                }
                child++;
            }else{
                // Don't take the low from visited nodes take their tin 
                low[node] = Math.min(low[node], tin[it]);
            }
        }
        if(child > 1 && parent == -1){
            mark[node] = 1;
        }
    }
    public ArrayList<Integer> articulationPoints(int n, ArrayList<ArrayList<Integer>> adj){
        int[] vis = new int[n];
        int[] tin = new int[n];
        int[] low = new int[n];
        int[] mark = new int[n];

        for(int i = 0; i < n; i++){
            if(vis[i] == 0){
                dfs(i, -1, vis, tin, low, mark, adj);
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(mark[i] == 1){
                ans.add(i);
            }
        }
        if(ans.size() == 0){
            ans.add(-1);
        }
        return ans;
    }
}
