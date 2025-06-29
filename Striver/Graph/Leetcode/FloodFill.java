package Striver.Graph.Leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {
    private static void bfs(int[][] image, int sr, int sc, int color, boolean[][] vis, int originalColor){
        int n = image.length;
        int m = image[0].length;
        vis[sr][sc] = true;
        image[sr][sc] = color;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sr, sc});

        // Only 4 directions: up, right, down, left
        int[] dRow = {-1, 0, 1, 0};
        int[] dCol = {0, 1, 0, -1};

        while (!queue.isEmpty()) {
            int[] pixel = queue.poll();
            int x = pixel[0];
            int y = pixel[1];

            for (int i = 0; i < 4; i++) {
                int tempX = x + dRow[i];
                int tempY = y + dCol[i];

                if (tempX >= 0 && tempX < n && tempY >= 0 && tempY < m) {
                    if (!vis[tempX][tempY] && image[tempX][tempY] == originalColor) {
                        vis[tempX][tempY] = true;
                        image[tempX][tempY] = color;
                        queue.offer(new int[]{tempX, tempY});
                    }
                }
            }
        }
    }
    private static void dfs(int row, int col, int[][] image, int newColor, int originalColor, int[] delRow, int[] delCol, boolean[][] vis){
        image[row][col] = newColor;
        vis[row][col] = true;
        int n = image.length;
        int m = image[0].length;

        for(int i = 0; i < 4; i++){
            int tempX = row + delRow[i];
            int tempY = col + delCol[i];
            if (tempX >= 0 && tempX < n && tempY >= 0 && tempY < m) {
                if (!vis[tempX][tempY] && image[tempX][tempY] == originalColor) {
                    dfs(tempX, tempY, image, newColor, originalColor, delRow, delCol, vis);
                }
            }
        }
    }
    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        boolean[][] vis = new boolean[image.length][image[0].length];
        int originalColor = image[sr][sc];
        int[] dRow = {-1, 0, 1, 0};
        int[] dCol = {0, 1, 0, -1};
        dfs(sr, sc, image, color, originalColor, dRow, dCol, vis);
        // bfs(image, sr, sc, color, vis, originalColor);
        return image;
    }
    public static void main(String[] args) {
        int[][] image= {{1,1,1}, {1,1,0}, {1,0,1}};
        System.out.println(Arrays.deepToString(floodFill(image, 1, 1, 2)));
    }
}
