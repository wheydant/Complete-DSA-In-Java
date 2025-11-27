package KunalKushwaha.Assignments.Recursion;

public class UniquePathsIII {
    public int uniquePathsIII(int[][] grid) {
		int startX = 0;
		int startY = 0;
		int endX = 0;
		int endY = 0;
		int blocked = 0;
		int total = grid.length * grid[0].length;
		for(int i = 0; i < grid.length; i++){
			for(int j = 0; j < grid[i].length; j++){
				// total++;
				if(grid[i][j] == -1){
					blocked++;
				}else if(grid[i][j] == 1){
					startX = i;
					startY = j;
				}else if(grid[i][j] == 2){
					endX = i;
					endY = j;
				}
			}
		}
		int walkable = total - blocked;
		return helper(startX, startY, 0, walkable, endX, endY, total, grid);
    }
	private int helper(int i, int j,int steps, int walkable, int endX, int endY, int total, int[][] grid) {
		// System.out.println(blocked);
		if(i == endX && j == endY){
			return steps + 1 == walkable ? 1 : 0;
		}
		if(i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == -1){
			return 0;
		}

		int original = grid[i][j];
		grid[i][j] = -1;

		int[] del = {-1, 0, 1, 0, -1};
		int paths = 0;
		for(int d = 0; d < 4; d++){
			int dx = i + del[d];
			int dy = j + del[d + 1];

			paths += helper(dx, dy, steps+1, walkable, endX, endY, total, grid);
		}

		grid[i][j] = original;

		return paths;
	}
	public static void main(String[] args) {
		System.out.println(new UniquePathsIII().uniquePathsIII(new int[][]{
			{1,0,0,0},
			{0,0,0,0},
			{0,0,2,-1}
		}));
	}
}
