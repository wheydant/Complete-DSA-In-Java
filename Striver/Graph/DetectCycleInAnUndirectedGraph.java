package Striver.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class DetectCycleInAnUndirectedGraph {
    //Taking 2 different parts where if next node is visited by another node of same level means cycle is present
    static boolean checkForCyclicBFS(int src, int V, ArrayList<ArrayList<Integer>> adj, boolean[] vis){
        vis[src] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{src, -1});

        while(!queue.isEmpty()){
            int[] nodeData = queue.poll();
            int node = nodeData[0];
            int parent = nodeData[1];

            for(int adjacentNode : adj.get(node)){
                if(!vis[adjacentNode]){
                    vis[adjacentNode] = true;
                    queue.add(new int[]{adjacentNode, node});
                    //In acyclic only parents are connected to the node so if the adj node is parent its true only. 
                }else if(parent != adjacentNode){
                    return true;
                }
            }
        }
        return false;
    }

    //Reaching any node which is already visited it's cyclic
    static boolean checkForCyclicDFS(int node, int parent, ArrayList<ArrayList<Integer>> adj, boolean[] vis){
        vis[node] = true;

        for(int adjacentNode : adj.get(node)){
            if(!vis[adjacentNode]){
                return checkForCyclicDFS(adjacentNode, node, adj, vis);
            }else if(parent != adjacentNode){
                return true;
            }
        }
        return false;
    }
    static boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj){
        boolean[] vis = new boolean[V];
        //For multiple components in a graph
        for(int i = 0; i < V; i++){
            if(vis[i] == false){
                if(checkForCyclicBFS(i, V, adj, vis)) return true;
                if(checkForCyclicDFS(i, -1, adj, vis)) return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Graph g = new Graph(7);
        int[][] edges = {{1, 2}, {1, 3}, {5, 2}, {5, 7},{3, 4}, {3, 6}, {6, 7}};
        g.insert(edges.length, edges);
        System.out.println(isCyclic(8, g.graph));
    }
}
