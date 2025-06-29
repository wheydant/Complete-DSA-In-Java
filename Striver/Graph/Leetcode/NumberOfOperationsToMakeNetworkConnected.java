package Striver.Graph.Leetcode;

//We can't make imaginary connection we need to remove existing connection and then connect it.
public class NumberOfOperationsToMakeNetworkConnected {
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

        boolean unionBySize(int u, int v){
            int ulp_u = findUlp(u);
            int ulp_v = findUlp(v);

            if(ulp_u == ulp_v) return false; 
            if(size[ulp_v] > size[ulp_u]){
                parent[ulp_u] = ulp_v;
                size[ulp_v] += size[ulp_u];
            }else{
                parent[ulp_v] = ulp_u;
                size[ulp_u] += size[ulp_v];
            }

            return true;
        }
    }
    public int makeConnected(int n, int[][] connections) {
        DisjointSet ds = new DisjointSet(n);
        int extraConnections = 0;
        for(int[] it: connections){
            int u = it[0];
            int v = it[1];

            if(!ds.unionBySize(u, v)){
                extraConnections++;
            }
        }

        System.out.println("Inserted");
        int networks = 0;
        for(int i = 0; i < n; i++){
            if(ds.findUlp(i) == i) networks++;
        }

        if(extraConnections >= networks - 1)
            return networks - 1;
        return -1;
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] connections = {{0,1}, {0,2}, {1,2}};

        NumberOfOperationsToMakeNetworkConnected q = new NumberOfOperationsToMakeNetworkConnected();

        System.out.println(q.makeConnected(n, connections));
    }
}
