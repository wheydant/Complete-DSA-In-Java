package LeetCode;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/n-queens/
public class NQueens {
    static List<List<String>> ans=new ArrayList<>();
    public static void main(String[] args) {
        ans = solveNQueens(1);
        System.out.println(ans); 
    }
    public static List<List<String>> solveNQueens(int n) {
        List<String>board=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            StringBuilder row=new StringBuilder();
            for(int j=0;j<n ;j++)
            {
                row.append(".");
            }
            board.add(row.toString());//convert it into row
        }
        solveNQueensHelper(board,0,n);
        return ans;
    }
    static void solveNQueensHelper(List<String>board, int row,int n){
        if(row == n){
            ans.add(new ArrayList<>(board));
            return;
        }

        for(int col = 0; col < n; col++){
            if(isSafe(board, row, col)){
                StringBuilder nrow=new StringBuilder(board.get(row));
                nrow.setCharAt(col,'Q');
                board.set(row,nrow.toString());
                solveNQueensHelper(board,row+1,n);
                nrow.setCharAt(col,'.');
                board.set(row,nrow.toString());
            }
        }
    }
    static boolean isSafe(List<String>board, int row, int col){

        // vertical row
        for(int i = 0; i < row; i++){
            if(board.get(i).charAt(col) == 'Q'){
                return false;
            }
        }
        //diag left
        int maxLeft = Math.min(row, col);

        for(int i = 1; i <= maxLeft; i++){
            if(board.get(row-i).charAt(col-i) == 'Q'){
                return false;
            }
        }
        //diag right
        int maxRight = Math.min(row, board.size() - col - 1);

        for(int i = 1; i <= maxRight; i++){
            if(board.get(row - i).charAt(col + i) == 'Q'){
                return false;
            }
        }
        return true;

    }
}
