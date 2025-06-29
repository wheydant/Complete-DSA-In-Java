package Striver.Graph.Leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInBinaryMatrix {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        // If start or end is blocked, return -1
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) return -1;

        int[][] dist = new int[n][n];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);

        dist[0][0] = 1; //starting position has distance 1

        // {dist, x, y}
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{1, 0, 0});
        
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int x = curr[1], y = curr[2], dis = curr[0];

            // If we've reached the end
            if (x == n - 1 && y == n - 1) return dis;

            for(int delX = -1; delX <= 1; delX++){
                for(int delY = -1; delY <= 1; delY++){
                    int newX = x + delX;
                    int newY = y + delY;

                    if(newX >= 0 && newX < n && newY >= 0 && newY < n && grid[newX][newY] == 0){
                        if(dis + 1 < dist[newX][newY]){
                            dist[newX][newY] = 1 + dis;
                            q.offer(new int[]{dis + 1, newX, newY});
                        }
                    }
                }
            }
        }

        return -1;
    }
}
