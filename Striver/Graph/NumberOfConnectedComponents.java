package Striver.Graph;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfConnectedComponents {
    //Chat GPT approach
    private static void dfs(int row, int col, boolean[][] vis, int[][] islands, int m, int n) {
        vis[row][col] = true;

        // Directions: 8 neighbors (N, NE, E, SE, S, SW, W, NW)
        int[] dRow = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] dCol = {0, 1, 1, 1, 0, -1, -1, -1};

        for (int i = 0; i < 8; i++) {
            int newRow = row + dRow[i];
            int newCol = col + dCol[i];

            if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n
                    && islands[newRow][newCol] == 1 && !vis[newRow][newCol]) {
                dfs(newRow, newCol, vis, islands, m, n);
            }
        }
    }
    //Striver
    private static void bfs(int row, int col, boolean[][] vis, int[][] islands) {
        int n = islands.length;
        int m = islands[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row, col});
        vis[row][col] = true;

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int currRow = cell[0];
            int currCol = cell[1];

            //Crazy 
            for(int delRow = -1; delRow <= 1; delRow++){
                for(int delCol = -1; delCol <= 1; delCol++){
                    int nRow = currRow + delRow;
                    int nCol = currCol + delCol;
                    if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m){
                        if(islands[nRow][nCol] == 1 && !vis[nRow][nCol]){
                            vis[nRow][nCol] = true;
                            queue.add(new int[]{nRow, nCol});
                        }
                    }
                }
            }
        }
    }
    //SC -> O(n^2) TC -> O(n^2 + 9*n^2)
    static int numberOfIslands(int[][] islands){
        int n = islands.length;
        int m = islands[0].length;
        int cntIslands = 0;
        boolean[][] vis = new boolean[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(islands[i][j] == 1 && !vis[i][j]){
                    bfs(i, j, vis, islands);
                    cntIslands++;
                }
            }
        }
        return cntIslands;
    }
    public static void main(String[] args) {
        //0 -> water and 1 -> islands
        int[][] islands = {
            {0, 1, 1, 0},
            {0, 1, 1, 0},
            {0, 0, 1, 0},
            {0, 0, 0, 0},
            {1, 1, 0, 1}
        };

        System.out.println(numberOfIslands(islands));
    }
}
