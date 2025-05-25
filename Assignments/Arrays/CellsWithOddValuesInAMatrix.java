
import java.util.Arrays;

public class CellsWithOddValuesInAMatrix {
    public static int oddCells(int m, int n, int[][] indices) {
        int[][] matrix = new int[m][n];
        for(int[] rows : matrix){
            Arrays.fill(rows, 0);
        }
        int oddCells = 0;
        for(int[] index : indices){
            int row = index[0];
            int col = index[1];
            for(int i = 0; i < m; i++){
                matrix[i][col]++; 
            }
            for(int i = 0; i < n; i++){
                matrix[row][i]++;
            }
            //System.out.println("For ["+ row+","+col+"]");
            //print(matrix);
        }

        for(int[] rows:matrix){
            for(int element: rows){
                if(element%2 == 1)oddCells++;
            }
        }
        return oddCells;
    }
        public int oddCellsOptimum(int n, int m, int[][] indices) {
        //Freq of rows and columns to be incremented
        int[] r = new int[m];
        int[] c = new int[n];

        for (int i = 0 ; i < indices.length; i++) {
            r[indices[i][0]]++;
            c[indices[i][1]]++;
        }

        //Count odd rows
        int oddRows = 0;
        for(int i =0; i < m; i++) {
            if(r[i]%2 == 1) {
                oddRows++;
            }            
        }
        
        //count odd columns
        int oddColumns = 0;
        for(int i =0; i < n; i++){ 
            if(c[i]%2 == 1) {
                oddColumns++;
            }
        }

        //return Final value
        return oddRows * n + oddColumns * m - 2*oddRows*oddColumns;
    }
    static void print(int[][] matrix){
        for(int[] row : matrix){
            for(int element : row){
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int[][] indices = {{0,0},{1,1}};

        System.out.println(oddCells(2,2,indices));
    }
}
