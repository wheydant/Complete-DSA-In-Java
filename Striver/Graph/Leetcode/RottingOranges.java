package Striver.Graph.Leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    //Remove Comments before submitting helps with TC
    public static int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        int time = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 2){
                    queue.offer(new int[]{i, j, 0});
                    vis[i][j] = true;
                }
            }
        }
        // UDLR
        int[] delX = {-1, 1, 0, 0};
        int[] delY = {0, 0, -1, 1};

        while(!queue.isEmpty()){
            int[] rottenMango = queue.poll();
            for(int i = 0; i < 4; i++){
                int x = rottenMango[0] + delX[i];
                int y = rottenMango[1] + delY[i];
                int t = rottenMango[2];
                if(x >= 0 && x < n && y >= 0 && y < m){
                    if(!vis[x][y] && grid[x][y] == 1){
                        grid[x][y] = 2;
                        vis[x][y] = true;
                        queue.offer(new int[]{x, y, t + 1});
                        time = Math.max(t + 1, time);

                        System.out.println("Entered for " + x + " " + y + " from " + rottenMango[0] + " "+ rottenMango[1]);
                        System.out.println(Arrays.deepToString(grid));
                    }
                }
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    return -1;
                }
            }
        }

        return time;
    }
    public static void main(String[] args) {
        int[][] grid = {{2,1,1}, {0,1,1}, {1,0,1}};
        System.out.println(orangesRotting(grid));
    }
}
