import java.util.Arrays;

public class multiDimArrSearch {
    public static void main(String[] args) {
        int[][] inputArr = {
            {1,2,3},
            {4,5},
            {6,7,8}
        };

        int target = 5;

        System.out.println(Arrays.toString(linearSearch(inputArr, target)));
    }

    public static  int[] linearSearch(int[][] inputArr, int target){
        if(inputArr.length == 0)
            return new int[]{-1,-1};
        
        for(int row = 0; row < inputArr.length; row ++){
            for(int col = 0; col < inputArr[row].length; col++){
                if(inputArr[row][col] == target)
                    return new int[]{row, col};
            }
        }

        return new int[]{-1,-1};
    }
}
