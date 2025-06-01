
import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        char[][] board = new char[3][3];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = ' ';
            }
        }

        char player = 'X';
        boolean gameOver = false;
        Scanner scanner = new Scanner(System.in);

        while(!gameOver){
            printBoard(board);
            System.out.println("Player " + player + " enter - ");
            int row = scanner.nextInt();
            row = (row > 2)? 2 : row;
            int col = scanner.nextInt();
            col = (col > 2)? 2 : col;
            System.out.println();

            if(board[row][col] == ' '){
                board[row][col] = player;
                gameOver = haveWon(board, player);
                if(gameOver){
                    System.out.println("Player " + player + " has won !");
                }else{
                    player = (player == 'X')? 'O':'X';
                }
            }else{
                System.out.println("Invalid move. Try again!");
            }
        }
        printBoard(board);
    }

    private static void printBoard(char[][] board){
        for(char[] row : board){
            System.out.print("| ");
            for(char box : row){
                System.out.print(box + " | ");
            }
            System.out.println();
        }
    }

    private static boolean haveWon(char[][] board, char player){
        for(char[] row : board){
            for(char box : row){
                if(box == ' ')break;
            }
        }
        for(int i = 0; i < board.length; i++){
            if(board[i][0] == player && board[i][1] == player && board[i][2] == player){
                return true;
            }else if(board[0][i] == player && board[1][i] == player && board[2][i] == player){
                return true;
            }
        }
        if(board[0][0] == player && board[1][1] == player && board[2][2] == player){
            return true;
        }
        if(board[0][2] == player && board[1][1] == player && board[2][0] == player){
            return true;
        }
        return false;
    }
}
