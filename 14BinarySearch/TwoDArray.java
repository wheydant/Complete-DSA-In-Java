public class TwoDArray {
    public static int twoDBinarySearch(int[][] matrix, int target){
        int row = 0;
        int col = matrix[0].length - 1;
        while(row < matrix.length && col >= 0){
            if(matrix[row][col] == target){
                return matrix[row][col];
            }else if(matrix[row][col] < target){
                row ++;
            }else{
                col --;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[][] matrix = {
            {10, 20, 30, 40},
            {15, 25, 35, 45},
            {28, 29, 37, 49},
            {33, 34, 38, 50},
        };
        System.out.println(twoDBinarySearch(matrix, 100));
    }
}
