package Striver.Graph.Leetcode;

import java.util.ArrayList;
import java.util.List;

class NumberOfProvinces{
    private void dfs(int node, int[][] isConnected, boolean[] vis){
        vis[node] = true;

        int[] localConnection = isConnected[node];
        for(int i = 0; i < localConnection.length; i++){
            if(isConnected[node][i] != 0 && !vis[i]){
                dfs(i, isConnected, vis);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int count = 0;
        boolean[] vis = new boolean[n];
        for(int i = 0; i < n; i++){
            if(!vis[i]){
                count++;
                dfs(i, isConnected, vis);
            }
        }
        return count;
    }

    //Disjoint set
    class DisjointSet{
        List<Integer> rank = new ArrayList<>();
        List<Integer> parent =  new ArrayList<>();
        List<Integer> size = new ArrayList<>();

        public DisjointSet(int n) {
            for(int i = 0; i <= n; i++){
                parent.add(i);
                rank.add(1);
                size.add(1);
            }
        }

        int findUPar(int node){
            if(parent.get(node) == node)return node;

            int ulp_node = findUPar(parent.get(node));

            parent.set(node, ulp_node);

            return parent.get(node);
        }

        void unionBySize(int u, int v){
            int ulp_u = findUPar(u);
            int ulp_v = findUPar(v);

            if(ulp_u == ulp_v) return;

            if(size.get(ulp_u) < size.get(ulp_v)){
                parent.set(ulp_u, ulp_v);
                size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
            }else{
                parent.set(ulp_v, ulp_u);
                size.set(ulp_u, size.get(ulp_v) + size.get(ulp_u));
            }
        }

        void unionByRank(int u, int v){
            int ulp_u = findUPar(u);
            int ulp_v = findUPar(v);

            if(ulp_u == ulp_v) return;

            if(rank.get(ulp_u) < rank.get(ulp_v)){
                parent.set(ulp_u, ulp_v);
            }else if(rank.get(ulp_u) > rank.get(ulp_v)){
                parent.set(ulp_v, ulp_u);
            }else{
                parent.set(ulp_v, ulp_u);
                rank.set(ulp_u, rank.get(ulp_u) + 1);
            }
        }
    }
    public int findCircleNumDisjointSet(int[][] isConnected) {
        int n = isConnected.length;
        DisjointSet ds = new DisjointSet(n);

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(isConnected[i][j] == 1){
                    ds.unionBySize(i, j);
                }
            }
        }
        int cntProvinces = 0;
        for(int i = 0; i < n; i++){
            //If we want to keep variables private
            // if(ds.parent.get(i) == i){
            //But this will take little extra time
            if(ds.findUPar(i) == i){
                cntProvinces++;
            }
        }

        return cntProvinces;
    }
}