package Striver.Graph;

import java.util.ArrayDeque;
import java.util.Queue;

//This is topological Sort Algorithm
//As topo sort is applicable for only acyclic thus we can detect cycles in the graph using topo
public class KahnsAlgorithm {
    /*
    1. Insert all nodes with indegree 0
    2. Take out one by one inserted nodes and reduce the indegee of nodes they go into.
    3. Repeat.
    */
    static int[] topologicalSort(int V, int[][] edges)
    {
        int[] ans = new int[V];
        Queue<Integer> q = new ArrayDeque<>();

        int[] inDegree = new int[V];

        for (int i = 0; i < V; i++) {
            for (int node : edges[i]) {
                inDegree[node]++;
            }
        }

        for(int i = 0; i < inDegree.length; i++){
            if(inDegree[i] == 0) q.offer(i);
        }

        int index = 0;

        while(!q.isEmpty()){
            int node = q.poll();
            ans[index++] = node;

            for(int it : edges[node]){
                inDegree[it]--;
                if(inDegree[it] == 0) q.offer(it);
            }
        }

        // Optional: Check for cycle
        if (index != V) {
            System.out.println("Cycle detected, topological sort not possible.");
            return new int[0];
        }
        return ans;
    }    
    public static void main(String[] args) {
        int v = 6;
        int[][] edges = {
            {},     // 0
            {},     // 1
            {3},    // 2
            {1},    // 3
            {0, 1}, // 4
            {0, 2}  // 5
        };

        int[] ans = topologicalSort(v, edges);

        for (int node : ans) {
            System.out.print(node + " ");
        }
        System.out.println();
    }
}
