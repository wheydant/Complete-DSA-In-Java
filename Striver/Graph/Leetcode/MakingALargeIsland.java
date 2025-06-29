package Striver.Graph.Leetcode;

//Hard
import java.util.HashSet;

public class MakingALargeIsland {
    //Whenever we see a island kind of problem we know its graph and adding islands is actually making it a dynamic graph thus disjoint set.
    class DisjointSet{
        int[] parent;
        int[] size;
        public DisjointSet(int n) {
            this.parent = new int[n];
            this.size = new int[n];
            for(int i = 0; i < n; i++){
                parent[i] = i;
                size[i] = 1;
            }
        }
    
        int ulpPar(int n){
            if(parent[n] == n) return n;
            return parent[n] = ulpPar(parent[n]);
        }
    
        void unionBySize(int u, int v){
            int ulp_u = ulpPar(u);
            int ulp_v = ulpPar(v);
            if(ulp_u == ulp_v){
                return;
            }
            if(size[ulp_v] > size[ulp_u]){
                parent[ulp_u] = ulp_v;
                size[ulp_v] += size[ulp_u];
            }else{
                parent[ulp_v] = ulp_u;
                size[ulp_u] += size[ulp_v];
            }
        }

    }
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        DisjointSet ds = new DisjointSet(n*n);
        int[] del = {0, -1, 0, 1, 0};
        //Make a disjoint set
        for(int row = 0; row < n; row++){
            for(int col = 0; col < n; col++){
                if(grid[row][col] == 0) continue;

                for(int i = 0; i < 4; i++){
                    int newR = row + del[i];
                    int newC = col + del[i + 1];
                    if(isValid(newR, newC, n)){
                        if(grid[newR][newC] == 1){
                            int nodeNo = row*n + col;
                            int adjNodeNo = newR*n + newC;
                            ds.unionBySize(nodeNo, adjNodeNo);
                        }
                    }
                }
            }
        }

        //Switch 0 -> 1 one by one
        int mx = 0;
        for(int row = 0; row < n; row++){
            for(int col = 0; col < n; col++){
                if(grid[row][col] == 1) continue;
                //Hashset is necessary as it can happen of a 0 is covered by 1 form single Island but our logic would calculate it for multiple times
                HashSet<Integer> adjIslands = new HashSet<>();
                for(int i = 0; i < 4; i++){
                    int newR = row + del[i];
                    int newC = col + del[i + 1];

                    if(isValid(newR, newC, n)){
                        if(grid[newR][newC] == 1){
                            // Add ultimate parent for adjacent island
                            adjIslands.add(ds.ulpPar(newR * n + newC));
                        }
                    }
                }

                int sizeTotal = 0;
                for(Integer parents: adjIslands){
                    sizeTotal += ds.size[parents];
                }
                mx = Math.max(mx, sizeTotal + 1);
            }
        }

        //It can happen even after addition of island one of the island is the largest one without addition i.e. all 1
        for(int cellNo = 0; cellNo < n*n; cellNo++){
            mx = Math.max(mx, ds.size[ds.ulpPar(cellNo)]);
        }
        return mx;
    }
    boolean isValid(int row, int col,int n){
        return row >= 0 && col >= 0 && row < n && col < n;
    }
}
