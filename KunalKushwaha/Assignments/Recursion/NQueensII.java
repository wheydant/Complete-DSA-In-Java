package KunalKushwaha.Assignments.Recursion;

public class NQueensII {
	boolean isPossible(int i, int j, boolean[][] chessBoard){
		//Column
		for(int idx = 0; idx < chessBoard.length; idx++){
			if(chessBoard[idx][j]) return false;
		}
		//Upper left diagonal
		int idx = i, idy = j;
		while(idx >= 0 && idy >= 0){
			if(chessBoard[idx--][idy--]) return false;
		}
		//lower right diagonal
		idx = i; idy = j;
		while(idx < chessBoard.length && idy < chessBoard.length){
			if(chessBoard[idx++][idy++]) return false;
		}
		//Upper right diagonal
		idx = i; idy = j;
		while(idx >= 0 && idy < chessBoard.length){
			if(chessBoard[idx--][idy++]) return false;
		}
		//Lower left diagonal
		idx = i; idy = j;
		while(idx < chessBoard.length && idy >= 0){
			if(chessBoard[idx++][idy--]) return false;
		}
		return true;
	}
	int helper(int i, boolean[][] chessBoard){
		if(i == chessBoard.length) return 1;
		int count = 0;
		for(int col = 0; col < chessBoard.length; col++){
			if(isPossible(i, col, chessBoard)){
				chessBoard[i][col] = true;
				count += helper(i + 1, chessBoard);
				chessBoard[i][col] = false;
			}
		}
		return count;
	}
	public int totalNQueens(int n) {
		boolean[][] chessBoard = new boolean[n][n];

		return helper(0, chessBoard);
	}
	public static void main(String[] args) {
		System.out.println(new NQueensII().totalNQueens(4));
	}
}
