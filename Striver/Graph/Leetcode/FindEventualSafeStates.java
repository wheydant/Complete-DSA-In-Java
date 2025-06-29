package Striver.Graph.Leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class FindEventualSafeStates {
    //Everyone part of cycle or connected to cycle cannot be a safe node
    boolean dfsCheckCycle(int node, int[][] graph, boolean[] vis , boolean[] pathVis, boolean[] check){
        vis[node] = true;
        pathVis[node] = true;
        check[node] = false;

        for(int i : graph[node]){
            if(!vis[i]){
                if(dfsCheckCycle(i, graph, vis, pathVis, check)) return true;
            }else if(pathVis[i]) return true;
        }
        check[node] = true;
        pathVis[node] = false;
        return false;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        boolean[] vis = new boolean[n];
        boolean[] pathVis = new boolean[n];
        boolean[] check = new boolean[n];
        for(int i = 0; i < n; i++){
            if(!vis[i]){
                dfsCheckCycle(i, graph, vis, pathVis, check);
            }
        }

        List<Integer> safeNodes = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(check[i]) safeNodes.add(i);
        }

        return safeNodes;
    }
    //Higher SC
    /*
     * 1. Toposort deals with indegree but a safe node is a node which has 0 outdegree. Thus reverse the nodes.
     * 2. Apply normal Topo sort.
     * 3. The safeNode which we encounter once are our only answer no other nodes are safe as they are with indegree greater than 0 hence visited by someone else.
    */
    public List<Integer> eventualSafeNodesTopoSort(int[][] graph) {
        List<List<Integer>> adjRev = new ArrayList<>();
        int n = graph.length;

        for(int i = 0; i < n; i++){
            adjRev.add(new ArrayList<>());
        }
        int[] indegree = new int[n];
        // Build reverse graph and indegree
        for (int i = 0; i < n; i++) {
            for (int neighbor : graph[i]) {
                adjRev.get(neighbor).add(i);
                indegree[i]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        List<Integer> safeNodes = new ArrayList<>();

        for(int i = 0; i < n; i++){
            if(indegree[i] == 0) q.offer(i);
        }

        while(!q.isEmpty()){
            int node = q.poll();
            safeNodes.add(node);
            for(int it : adjRev.get(node)){
                indegree[it]--;
                if(indegree[it] == 0)q.offer(it);
            }
        }

        Collections.sort(safeNodes);

        return safeNodes;
    }
}
