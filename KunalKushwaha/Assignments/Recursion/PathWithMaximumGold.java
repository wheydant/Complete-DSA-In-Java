package KunalKushwaha.Assignments.Recursion;

public class PathWithMaximumGold {
    int helper(int i, int j, int[][] grid){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0){
            return 0;
        }

        int curr = grid[i][j];
        grid[i][j] = 0;

        int[] del = {-1, 0, 1, 0, -1};
        int max = 0;

        for(int d = 0; d < 4; d++){
            int x = i + del[d];
            int y = j + del[d + 1];

            max = Math.max(max, helper(x, y, grid));
        }

        grid[i][j] = curr;
        return curr + max;
    }
    public int getMaximumGold(int[][] grid) {
        int maxGold = 0;

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] != 0){
                    maxGold = Math.max(maxGold, helper(i, j, grid));
                }
            }
        }

        return maxGold;
    }
}