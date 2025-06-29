package KunalKushwaha.Assignments.Searching;

import java.util.Arrays;

public class FindAPeakElementII {
    int findRowMax(int[] arr, int n){
        int maxIndex = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }
    boolean isPeak(int[] rowMaxIndex, int[][] mat, int n, int m){
        int[] del = {0, -1, 0, 1, 0};
        int row = rowMaxIndex[0];
        int col = rowMaxIndex[1];
        int peak = mat[row][col];
        for(int i = 0; i < 4; i++){
            int delRow = row + del[i];
            int delCol = col + del[i + 1];
            
            if(delRow >= 0 && delRow < n && delCol >= 0 && delCol < m){
                int adjVal = mat[delRow][delCol];
                if(adjVal >= peak) return false;
            }
        }

        return true;
    }
    //O(n*m)
    public int[] findPeakGridNM(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        for(int i = 0; i < n; i++){
            int[] rowMaxIndex = new int[]{i, findRowMax(mat[i], m)};
            System.out.println(Arrays.toString(rowMaxIndex));
            if(isPeak(rowMaxIndex, mat, n, m)){
                return rowMaxIndex;
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[][] mat = {
            {70, 50, 40, 30, 20},
            {100, 1, 2, 3, 4}
        };

        FindAPeakElementII q = new FindAPeakElementII();
        System.out.println(Arrays.toString(q.findPeakGrid(mat)));
    }

    public int[] findPeakGridMLogN(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int low = 0, high = n - 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int maxRow = 0;
            for (int i = 0; i < m; i++) {
                if (mat[i][mid] > mat[maxRow][mid]) {
                    maxRow = i;
                }
            }
            
            boolean leftIsBigger = mid > 0 && mat[maxRow][mid - 1] > mat[maxRow][mid];
            boolean rightIsBigger = mid < n - 1 && mat[maxRow][mid + 1] > mat[maxRow][mid];
            
            if (!leftIsBigger && !rightIsBigger) {
                return new int[]{maxRow, mid};
            } else if (leftIsBigger) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return new int[]{-1, -1};
    }
}
