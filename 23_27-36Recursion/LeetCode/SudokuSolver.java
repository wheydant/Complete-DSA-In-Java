package LeetCode;
// https://leetcode.com/problems/sudoku-solver/description/

/*
 * Complexity is fucked up
 * Time complexity = (board.length)^(n^2)
 */
public class SudokuSolver {
    public static void main(String[] args) {
        int[][] board = new int[][]{
            {1, 0, 0},
            {0, 2, 0},
            {0, 0, 3}
        };

        if (solveSudoku(board)) {
            display(board);
        } else {
            System.out.println("Cannot solve");
        }
    }
    public static boolean solveSudoku(int[][] board){
        int n = board.length;
        int row = -1;
        int col = -1;

        boolean emptyLeft = true;

        //Fetches first empty row and col replaces passing row and col in arg.
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 0){
                    row = i;
                    col = j;
                    emptyLeft = false;
                    break;
                }
            }

            if(emptyLeft == false){
                break;
            }
        }

        //If no empty then suduko solved
        if(emptyLeft == true){
            //Suduko solved
            return true;
        }

        //recursion call with backtrack
        for(int number = 1; number <= board.length; number++){
            if(isSafe(board, row, col, number)){
                //Insert every possible ans
                board[row][col] = number;
                if(solveSudoku(board)){
                    //Suduko done
                    return true;
                }else{
                    //backtracks and try for next element.
                    board[row][col] = 0;
                }
            }
        }

        return false;
    }
    static boolean isSafe(int[][] board, int row, int col, int num){
        //row
        for(int checkCol = 0; checkCol < board.length; checkCol++){
            if(board[row][checkCol] == num){
                return false;
            }
        }

        //col
        for(int[] nums : board){
            if(nums[col] == num){
                return false;
            }
        }

        //Box
        //Start box => row = row - row%3; col = col - col%3

        int sqrt = (int)(Math.sqrt(board.length));

        int boxRow = row - row%sqrt;
        int boxCol = col - col%sqrt;

        for(int i = boxRow; i <= boxRow + sqrt; i++){
            for(int j = boxCol; j <= boxCol + sqrt; boxCol++){
                if(board[i][j] == num){
                    return false;
                }
            }
        }

        return true;
    }
    private static void display(int[][] board) {
        for(int[] row : board) {
            for(int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
