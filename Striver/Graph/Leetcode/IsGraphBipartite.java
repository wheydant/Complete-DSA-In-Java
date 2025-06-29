package Striver.Graph.Leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class IsGraphBipartite {
    public boolean isBipartiteBFS(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1); // -1 means unvisited

        //To cover all disconnected parts in a graph too
        for (int start = 0; start < n; start++) {
            if (color[start] == -1) {
                Queue<Integer> queue = new ArrayDeque<>();
                queue.offer(start);
                color[start] = 0;

                while (!queue.isEmpty()) {
                    int node = queue.poll();
                    for (int neighbor : graph[node]) {
                        if (color[neighbor] == -1) {
                            color[neighbor] = 1 - color[node]; // Assign opposite color
                            queue.offer(neighbor);
                        } else if (color[neighbor] == color[node]) {
                            return false; // Same color on both sides = not bipartite
                        }
                    }
                }
            }
        }

        return true;
    }
    //DFS gives better solution
    public boolean isBipartiteDFS(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1); // -1 means unvisited

        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                if (!dfs(i, 0, color, graph)) return false;
            }
        }

        return true;
    }

    private boolean dfs(int node, int col, int[] color, int[][] graph) {
        color[node] = col;

        for (int neighbor : graph[node]) {
            if (color[neighbor] == -1) {
                // Color the neighbor with opposite color
                if (!dfs(neighbor, 1 - col, color, graph)) return false;
            } else if (color[neighbor] == col) {
                // Found a neighbor with the same color => Not bipartite
                return false;
            }
        }

        return true;
    } 
}
