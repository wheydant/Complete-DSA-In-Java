package KunalKushwaha.Assignments.Sorting;

import java.util.Arrays;

public class MatrixCellsInDistanceOrder{
    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        int totalElements = rows*cols;

        int[][] matrix = new int[totalElements][2];

        int i = 0;
        while(i < totalElements){
            for(int row = 0; row < rows; row++){
                for(int col = 0; col < cols; col++){
                    int[] index = new int[2];
                    index[0] = row;
                    index[1] = col;
                    matrix[i++] = index;
                }
            }
        }

        Arrays.sort(matrix, (a, b) -> (Math.abs(a[0] - rCenter) + Math.abs(a[1] - cCenter)) - (Math.abs(b[0] - rCenter) + Math.abs(b[1] - cCenter)));
        // System.out.println(Arrays.deepToString(matrix));

        return matrix;
    }
}