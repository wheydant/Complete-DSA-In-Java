package Striver.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    public ArrayList<ArrayList<Integer>> graph;
    public int[][] matrixGraph;
    public Graph(int n) {
        graph = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
    }

    public Graph(int[][] mat){
        matrixGraph = mat;
    }
    public Graph(){

    }

    public void matrixToList(int[][] matrix){
        graph = new ArrayList<>();
        for(int i = 0; i < matrix.length; i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                if(matrix[i][j] == 1 && i != j){
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }
    }

    public void insert(int m, int[][] edges){
        for(int i = 0; i < m; i++){
            ArrayList<Integer> linkA = graph.get(edges[i][0]);
            ArrayList<Integer> linkB = graph.get(edges[i][1]);
            linkA.add(edges[i][1]);
            linkB.add(edges[i][0]);
        }
        System.out.println(graph);
    }

    //SC -> O(3n) TC -> O(N + 2E) for all nodes and their edges.
    public ArrayList<Integer> bfs(int startNode){ 
        ArrayList<Integer> bfs = new ArrayList<>();
        int n = graph.size();
        // System.out.println(n);
        boolean[] visitedArray = new boolean[n];
        Arrays.fill(visitedArray, false);
        // System.out.println("Here - "+Arrays.toString(visitedArray));
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startNode);
        visitedArray[startNode] = true;
        while(!queue.isEmpty()){
            int node = queue.poll();
            ArrayList<Integer> list = graph.get(node);
            for(int i = 0; i < list.size(); i++){
                if(!visitedArray[list.get(i)]){
                    queue.add(list.get(i));
                    visitedArray[list.get(i)] = true;
                }
            }
            bfs.add(node);
        }
        return bfs;
    }
    private void dfs(int node, int[][] matrixGraph, boolean[] vis, ArrayList<Integer> ans){
        ans.add(node);
        vis[node] = true;

        int[] localConnection = matrixGraph[node];
        for(int i = 0; i < localConnection.length; i++){
            if(matrixGraph[node][i] != 0 && !vis[i]){
                dfs(i, matrixGraph, vis, ans);
            }
        }
    }
    //TC - O(n + 2*E) 
    public ArrayList<Integer> dfs(int startNode){ 
        ArrayList<Integer> dfs = new ArrayList<>();
        int n = graph.size();
        boolean[] visitedArray = new boolean[n];
        Arrays.fill(visitedArray, false);
        helper(startNode, graph, dfs, visitedArray);
        return dfs;
    }

    private void helper(int node, ArrayList<ArrayList<Integer>> graph, ArrayList<Integer> dfs, boolean[] visitedArray){
        visitedArray[node] = true;
        dfs.add(node);
        ArrayList<Integer> list = graph.get(node);
        // System.out.println(list);
        for(Integer it: list){
            // System.out.println();
            if(!visitedArray[it]){
                helper(it, graph, dfs, visitedArray);
            }
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(8);
        int[][] inserts = {{2,1},{1,6},{2,3},{2,4},{6,7},{6,8},{4,5},{7,5}};
        g.insert(inserts.length, inserts);
        System.out.println(g.bfs(1));
        Graph g1 = new Graph(8);
        inserts = new int[][]{{1, 2},{1,3},{2,5},{2,6},{3,7},{3,4},{4,8},{7,8}};
        g1.insert(inserts.length, inserts);
        System.out.println(g1.dfs(1));

        int[][] matrix = {{1, 0, 1}, {0,1,1}, {1, 1, 1}};
        Graph g2 = new Graph(matrix);
        boolean[] vis = {false,false,false};
        ArrayList<Integer> ans = new ArrayList<>();
        g2.dfs(0, g2.matrixGraph, vis, ans);
        System.out.println(ans);
    }
}
