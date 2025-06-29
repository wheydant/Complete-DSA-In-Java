package Striver.Graph.Leetcode;

import java.util.HashMap;
import java.util.Map;

public class MostStonesRemovedWithSameRowOrColumn {
    //In a connection we can remove all the stones except one.
    class DisjointSet{
        int[] parent;
        int[] size;
        public DisjointSet(int n) {
            parent = new int[n];
            size = new int[n];

            for(int i = 0; i < n; i++){
                parent[i] = i;
                size[i] = 1;
            }
        }

        int findUlp(int n){
            if(parent[n] == n) return n;
            return parent[n] = findUlp(parent[n]);
        }

        void unionBySize(int u, int v){
            int ulpU = findUlp(u);
            int ulpV = findUlp(v);

            if(ulpU == ulpV) return;

            if(size[ulpV] > size[ulpU]){
                parent[ulpU] = ulpV;
                size[ulpV] += size[ulpU];
            }else{
                parent[ulpV] = ulpU;
                size[ulpU] += size[ulpV];
            }
        }
    }
    public int removeStones(int[][] stones) {
        int n = stones.length;
        int maxRow = 0;
        int maxCol = 0;
        for(int i = 0; i < n; i++){
            maxRow = Math.max(maxRow, stones[i][0]);
            maxCol = Math.max(maxCol, stones[i][1]);
        }

        DisjointSet ds = new DisjointSet(maxRow + maxCol + 2);
        HashMap<Integer, Integer> stoneNodes = new HashMap<>();

        for(int i = 0; i < n; i++){
            int nodeRow = stones[i][0];
            int nodeCol = stones[i][1] + maxRow + 1;
            ds.unionBySize(nodeRow, nodeCol);

            stoneNodes.put(nodeRow, 1);
            stoneNodes.put(nodeCol, 1);
        }

        int cnt = 0;
        for(Map.Entry<Integer, Integer> it: stoneNodes.entrySet()){
            if(ds.findUlp(it.getKey()) == it.getKey()) cnt++;
        }

        return n - cnt;
    }
}
