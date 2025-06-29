package Striver.Graph;

public class FloydWarshall {
    static void floydWarshall(int[][] dist){
        int n = dist.length;

        //TC - O(n^3) SC - O(n^2)
        for(int k = 0; k < n; k++){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    if(i == j && dist[i][j] < 0){
                        System.out.println("Negative Cycle exist");
                    }
                }
            }
        }
    }
    public static void main(String[] args)
    {
        int INF = 100000000;
        //INF denotes no edge
        int[][] dist = { { 0, 4, INF, 5, INF },
                         { INF, 0, 1, INF, 6 },
                         { 2, INF, 0, 3, INF },
                         { INF, INF, 1, 0, 2 },
                         { 1, INF, INF, 4, 0 } };

        floydWarshall(dist);
        for (int i = 0; i < dist.length; i++) {
            for (int j = 0; j < dist.length; j++) {
                System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }
    }
}
