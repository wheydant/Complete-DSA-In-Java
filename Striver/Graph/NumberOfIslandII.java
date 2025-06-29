package Striver.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberOfIslandII{
    class DisjointSet{
        int[] parent;
        int[] size;
        DisjointSet(int n){
            parent = new int[n];
            size = new int[n];
            for(int i = 0; i < n; i++){
                parent[i] = i;
                size[i] = 1;
            }
        }
        
        int findUlPar(int n){
            if(parent[n] == n) return n;

            return parent[n] = findUlPar(parent[n]);
        }

        void unionBySize(int u, int v){
            int ulp_u = findUlPar(u);
            int ulp_v = findUlPar(v);

            if(ulp_u == ulp_v) return;

            if(size[ulp_v] > size[ulp_u]){
                parent[ulp_u] = ulp_v;
                size[ulp_v] += size[ulp_u];
            }else{
                parent[ulp_v] = ulp_u;
                size[ulp_u] += size[ulp_v];
            }
        }
    }
    boolean isValid(int row, int col, int n, int m){
        return (row >= 0) && (col >= 0) && (row < n) && (col < m);
    }
    public List<Integer> numOfIslands(int n, int m, int[][] operators){
        DisjointSet ds = new DisjointSet(n * m);
        boolean[][] vis = new boolean[n][m];
        Arrays.fill(vis, false);
        int cnt = 0;
        List<Integer> ans = new ArrayList<>();
        int len = operators.length;
        for(int i = 0; i < len; i++){
            int row = operators[i][0];
            int col = operators[i][1];
            if(vis[row][col]){
                //If Visited just add to ans and skip
                ans.add(cnt);
                continue;
            }
            //If not visited and increase the count assuming it's individual element
            vis[row][col] = true;
            cnt++;

            int[] del = {0, -1, 0, 1, 0};

            for(int d = 0; d < 4; d++){
                int adjR = row + del[d];
                int adjC = col + del[d + 1];

                if(isValid(adjR, adjC, n, m)){
                    if(vis[adjR][adjC]){
                        //Main formula to fetch nodes
                        int nodeNo = row * m + col;
                        int adjNodeNo = adjR * m + adjC;

                        if(ds.findUlPar(nodeNo) != ds.findUlPar(adjNodeNo)){
                            //If parent is not same and adj island is found reduce the count and union them
                            cnt--;
                            ds.unionBySize(nodeNo, adjNodeNo);
                        }
                    }
                }
            }
            ans.add(cnt);
        }

        return ans;
    }
}