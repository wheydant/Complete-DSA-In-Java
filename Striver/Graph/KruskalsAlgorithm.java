package Striver.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class KruskalsAlgorithm {
    static public class DisjointSet {
        List<Integer> rank = new ArrayList<>();
        List<Integer> parent = new ArrayList<>();
        List<Integer> size =  new ArrayList<>();

        public DisjointSet(int n) {
            // <= n works for both 0 based and 1 based indexing
            for(int i = 0; i <= n; i++){
                rank.add(0);
                parent.add(i);
                size.add(1);
            }
        }

        int findUPar(int node){
            if(node == parent.get(node)) return node;

            int ulp = findUPar(parent.get(node));
            parent.set(node, ulp);
            return parent.get(node);
        }
        void unionByRank(int u, int v){
            int ulp_u = findUPar(u);
            int ulp_v = findUPar(v);

            //If they belong to same path no need to do anything
            if(ulp_u == ulp_v) return;

            if(rank.get(ulp_u) < rank.get(ulp_v)){
                parent.set(ulp_u, ulp_v);
            }else if(rank.get(ulp_u) < rank.get(ulp_v)){
                parent.set(ulp_v, ulp_u);
            }else{
                parent.set(ulp_v, ulp_u);
                int rankU = rank.get(ulp_u);
                rank.set(ulp_u, rankU + 1);
            }
        }

        void unionBySize(int u, int v){
            int ulp_u = findUPar(u);
            int ulp_v = findUPar(v);

            //If they belong to same path no need to do anything
            if(ulp_u == ulp_v) return;

            if(size.get(ulp_u) < size.get(ulp_v)){
                parent.set(ulp_u, ulp_v);
                size.set(ulp_v, size.get(ulp_u) + size.get(ulp_v));
            }else{
                parent.set(ulp_v, ulp_u);
                size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
            }
        }

    }
    static class Edge implements Comparable<Edge>{
        int src, dest, weight;
        
        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj){

        List<Edge> edges = new ArrayList<>();

        //O(N + E)
        for(int i = 0; i < V; i++){
            for(int j = 0; j < adj.get(i).size(); j++){
                int adjNode = adj.get(i).get(j).get(0);
                int wt = adj.get(i).get(j).get(1);
                int node = i;
                Edge temp = new Edge(i, adjNode, wt);
                edges.add(temp);
            }
        }

        DisjointSet ds = new DisjointSet(V);

        //M Log M This will fetch comparable of Edge
        Collections.sort(edges);
        List<ArrayList<Integer>> mst = new ArrayList<>();

        int mstWt = 0;

        // M * 4 * aplha * 2 Twice coz u and for v findUPar is called
        for(int i = 0; i < edges.size(); i++){
            int wt = edges.get(i).weight;
            int u = edges.get(i).src;
            int v = edges.get(i).dest;

            if(ds.findUPar(u) != ds.findUPar(v)){
                mst.add(new ArrayList<>(Arrays.asList(u, v)));
                mstWt += wt;
                ds.unionBySize(u, v);
            }
        }

        System.out.println(mst);
        return mstWt;
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
