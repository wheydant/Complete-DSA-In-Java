package KunalKushwaha.Assignments.Bitwise;

import java.util.Arrays;

public class MinimumNumberOfFlipsToConvertBinaryMatrixToZeroMatrix{
    int helper(int requiredZero,int[][] mat){
        if(requiredZero == 0) return 0;

        int minFlip = Integer.MAX_VALUE;

        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[i].length; j++){
				System.out.println(Arrays.deepToString(mat));
                if(mat[i][j] == -1) continue;
                else{
                    int[] zero = flip(i, j, mat);//new Zero, new One
                    int val = mat[i][j];
                    requiredZero = requiredZero - zero[0] + zero[1];
                    mat[i][j] = -1;
					System.out.println(Arrays.deepToString(mat));
                    minFlip = Math.min(minFlip, 1 + helper(requiredZero, mat));
                    mat[i][j] = val;
                    zero = flip(i, j, mat);
					System.out.println(Arrays.deepToString(mat));
                    requiredZero = requiredZero - zero[0] + zero[1];
                }
            }
        }
        return minFlip;
    }
    int[] flip(int i, int j, int[][] mat){
        int[] del = {-1, 0, 1, 0, -1};

        int[] zeroOne = {0, 0};
        if(mat[i][j] == 1){
            zeroOne[0]++;
        }else{
            zeroOne[1]++;
        }

        for(int d = 0; d < 4; d++){
            int dI = i + del[d];
            int dJ = j + del[d + 1];

            if(dI < 0 || dJ < 0|| dI >= mat.length || dJ >= mat[dI].length) continue;
            if(mat[dI][dJ] == 1){
                zeroOne[0]++;
                mat[dI][dJ] = 0;
            }else{
                zeroOne[1]++;
                mat[dI][dJ] = 1;
            }
        }

        return zeroOne;
    }
    public int minFlips(int[][] mat) {
        int zero = 0;
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[i].length; j++){
                if(mat[i][j] == 0) zero++;
            }
        }
        int totalZero = mat.length * mat[0].length;
        if(zero == totalZero) return 0;
        int requiredZero = totalZero - zero;
        int ans = helper(requiredZero, mat);

        return (ans == Integer.MAX_VALUE)? -1: ans;
    }

	public static void main(String[] args) {
		System.out.println(new MinimumNumberOfFlipsToConvertBinaryMatrixToZeroMatrix().minFlips(new int[][]{{0,0},{0,1}}));
	}
}