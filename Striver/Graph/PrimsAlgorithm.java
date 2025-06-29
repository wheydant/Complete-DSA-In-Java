package Striver.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class PrimsAlgorithm {
    static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj){
        // {weight, node, parent}
        PriorityQueue<int []> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        boolean[] vis = new boolean[V];

        pq.offer(new int[]{0, 0, -1});
        int sum = 0;

        ArrayList<List<Integer>> spanningTree = new ArrayList<>();
        // TC - E Log E
        while(!pq.isEmpty()){
            //Log E
            int[] curr = pq.poll();
            int currWt = curr[0];
            int currNode = curr[1];
            int currParent = curr[2];

            if(vis[currNode]) continue;

            vis[currNode] = true;
            sum += currWt;

            if(currParent != -1){
                List<Integer> edge = Arrays.asList(currParent, currNode);
                spanningTree.add(edge);
            }

            //E
            for(int i = 0; i < adj.get(currNode).size(); i++){
                int edW = adj.get(currNode).get(i).get(1);
                int adjNode = adj.get(currNode).get(i).get(0);

                if(!vis[adjNode]){
                    // Log E
                    pq.offer(new int[]{edW, adjNode, currNode});
                }

            }
        }

        System.out.print("Minimum spanning tree is - ");

        System.out.println(spanningTree);
        return sum;
    }
    public static void main(String[] args)
    {
        int V = 5;
        // edge list: {u, v, weight}
        int[][] edges = {
            {0, 1, 2},
            {0, 3, 6},
            {1, 2, 3},
            {1, 3, 8},
            {1, 4, 5},
            {2, 4, 7},
            {3, 4, 9}
        };

        // build adjacency list
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];

            //THis is how we store Arrays.asList()
            adj.get(u).add(new ArrayList<>(Arrays.asList(v, w)));
            adj.get(v).add(new ArrayList<>(Arrays.asList(u, w)));
        }

        int totalWeight = spanningTree(V, adj);
        System.out.println("Total weight of MST: " + totalWeight);
    }
}
