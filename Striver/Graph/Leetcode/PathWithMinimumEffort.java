package Striver.Graph.Leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;


public class PathWithMinimumEffort {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        int[][] dist = new int[n][m];

        for(int i = 0; i < n; i++){
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        pq.offer(new int[]{0, 0, 0});
        dist[0][0] = 0;

        int[] del = {0, -1, 0, 1, 0};

        while(!pq.isEmpty()){
            int[] node = pq.poll();
            int diff = node[0];
            int row = node[1];
            int col = node[2];

            //If in priority queue the min is the destination then all other paths have atleast the value of current diff so it's the ans
            if(row == n - 1 && col == m - 1) return diff;

            for(int i = 0; i < 4; i++){
                int nRow = row + del[i];
                int nCol = col + del[i + 1];

                if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m){
                    int newEffort = Math.max(
                        Math.abs(heights[row][col] - heights[nRow][nCol]),
                        diff
                    );
                    //Don't break here even if nRow and nCol are n - 1 coz we might find more minimum.
                    if(newEffort < dist[nRow][nCol]){
                        dist[nRow][nCol] = newEffort;
                        pq.offer(new int[]{newEffort, nRow, nCol});
                    }
                }
            }
        }

        return 0;
    }
}
