package Striver.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class KosrajusAlgoStronglyConnectedComponent {
    void dfs(int node, boolean[] vis, List<List<Integer>> adj, Stack<Integer> st) {
        vis[node] = true;
        for (Integer it : adj.get(node)) {
            if (!vis[it]) {
                dfs(it, vis, adj, st);
            }
        }
        st.push(node);
    }

    void dfsSCC(int node, boolean[] vis, List<Integer> ans, List<List<Integer>> adj) {
        vis[node] = true;
        ans.add(node);
        for (Integer it : adj.get(node)) {
            if (!vis[it]) {
                dfsSCC(it, vis, ans, adj);  // ✅ fixed the recursive call
            }
        }
    }

    List<List<Integer>> kosaraju(int V, List<List<Integer>> edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.size(); i++) {
            adj.get(edges.get(i).get(0) - 1).add(edges.get(i).get(1) - 1);  // converting to 0-based indexing
        }

        boolean[] vis = new boolean[V];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs(i, vis, adj, st);
            }
        }

        List<List<Integer>> adjT = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjT.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.size(); i++) {
            int u = edges.get(i).get(0) - 1;
            int v = edges.get(i).get(1) - 1;
            adjT.get(v).add(u);  // reverse the edge
        }

        Arrays.fill(vis, false);
        List<List<Integer>> ans = new ArrayList<>();

        while (!st.isEmpty()) {
            int node = st.pop();
            if (!vis[node]) {
                List<Integer> component = new ArrayList<>();
                dfsSCC(node, vis, component, adjT);
                // convert back to 1-based for output
                for (int i = 0; i < component.size(); i++) {
                    component.set(i, component.get(i) + 1);
                }
                ans.add(component);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        KosrajusAlgoStronglyConnectedComponent obj = new KosrajusAlgoStronglyConnectedComponent();
        int V = 5;
        List<List<Integer>> edges = new ArrayList<>();
        edges.add(List.of(1, 3));
        edges.add(List.of(1, 4));
        edges.add(List.of(2, 1));
        edges.add(List.of(3, 2));
        edges.add(List.of(4, 5));

        List<List<Integer>> ans = obj.kosaraju(V, edges);
        System.out.println("Strongly Connected Components are:");
        for (List<Integer> x : ans) {
            for (int y : x) {
                System.out.print(y + " ");
            }
            System.out.println();
        }
    }
}
