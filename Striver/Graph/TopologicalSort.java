package Striver.Graph;

import java.util.Stack;

public class TopologicalSort {
    static void dfs(int node, int[][] edges, boolean[] vis, Stack<Integer> st){
        vis[node] = true;
        for(int it : edges[node]){
            if(!vis[it])
                dfs(it, edges, vis, st);
        }
        st.add(node);
    }
    static int[] topologicalSort(int V, int[][] edges)
    {
        int[] result = new int[V];
        Stack<Integer> st = new Stack<>();

        boolean[] vis = new boolean[V];
        for(int i = 0; i < V; i++){
            if(!vis[i]){
                dfs(i, edges, vis, st);
            }
        }
        return st.stream().mapToInt(i -> i).toArray();
    }
    public static void main(String[] args)
    {
        int v = 6;
        int[][] edges = {{2, 3}, {3, 1}, {4, 0},
                          {4, 1}, {5, 0}, {5, 2}};

        int[] ans = topologicalSort(v, edges);

        for (int node : ans) {
            System.out.print(node + " ");
        }
        System.out.println();
    }
}
