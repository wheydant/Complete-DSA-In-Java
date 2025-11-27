package KunalKushwaha.Assignments.Recursion;

public class SudokuSolver {
	boolean solved = false;
	void solver(int i, int j, char[][] board){
		if(i == board.length){
			solved = true;
			return;
		}

		if(board[i][j] != '.'){
			callNext(i, j, board);
			return;
		}
		for(char ip = '1'; ip <= '9'; ip++){
			if(check(i, j, ip, board)){
				//true can be added
				board[i][j] = ip;
				callNext(i, j, board);
				if(solved) return;
				board[i][j] = '.';
			}
		}
	}
	boolean check(int i, int j, char ip,char[][] board){
		//row and col
		for(int idx = 0; idx < board.length; idx++){
			if(board[i][idx] == ip) return false;
			if(board[idx][j] == ip) return false;
		}

		//Box
		int boxX = 3*(i/3);
		int boxY = 3*(j/3);

		for(int x = boxX; x < boxX + 3; x++){
			for(int y = boxY; y < boxY + 3; y++){
				if(board[x][y] == ip) return false;
			}
		}

		return true;
	}
	void callNext(int i, int j, char[][] board){
		if(j < 8)
			solver(i, j + 1, board); // right
		else
			solver(i + 1, 0, board); //next row
	}
    public void solveSudoku(char[][] board) {
        solver(0, 0, board);
    }
	public static void main(String[] args) {
		char[][] board = new char[][]{
			{'5','3','.','.','7','.','.','.','.'},
			{'6','.','.','1','9','5','.','.','.'},
			{'.','9','8','.','.','.','.','6','.'},
			{'8','.','.','.','6','.','.','.','3'},
			{'4','.','.','8','.','3','.','.','1'},
			{'7','.','.','.','2','.','.','.','6'},
			{'.','6','.','.','.','.','2','8','.'},
			{'.','.','.','4','1','9','.','.','5'},
			{'.','.','.','.','8','.','.','7','9'}
		};

		SudokuSolver solver = new SudokuSolver();
		solver.printBoard(board);

		solver.solveSudoku(board);
		System.out.println("------------------------");

		solver.printBoard(board);

	}
	void printBoard(char[][] board){
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[i].length; j++){
				// if(i%3 == 0)
				// 	System.out.print('_');
				if(j%3 == 0)
					System.out.print('|');
				System.out.print(board[i][j]+ " ");
			}
			System.out.println();
		}
	}
}
