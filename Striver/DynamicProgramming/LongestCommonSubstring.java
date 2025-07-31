package Striver.DynamicProgramming;

public class LongestCommonSubstring {
    static int lCS(String text1, String text2){
        return helperTab(text1, text2);
    }

    static int helperTab(String text1, String text2){
        int n = text1.length();
        int m = text2.length();

        int[][] dpIndexShift = new int[n + 1][m + 1];

        //Base Case - No need to explicitly state that as array is initialized with 0. 
        // for(int i = 0; i <= n; i++) dpIndexShift[i][0] = 0;
        // for(int j = 0; j <= m; j++) dpIndexShift[0][j] = 0;

        int maxLenLCS = Integer.MIN_VALUE;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                //This whole can be skip using i,j -> 1 
                // if(i == 0 || j == 0){
                    // No need to explicitly state it.
                    // dpIndexShift[i][j] = 0;
                    // continue;
                // }
                if(text1.charAt(i - 1) == text2.charAt(j - 1)){
                    dpIndexShift[i][j] = 1 + dpIndexShift[i - 1][j - 1];
                    maxLenLCS = Math.max(dpIndexShift[i][j], maxLenLCS);
                }else{
                    dpIndexShift[i][j] = 0;
                }
            }
        }

        return maxLenLCS;
    }
    public static void main(String[] args) {
        String text1 = "abzd";
        String text2 = "abcd";

        System.out.println(lCS(text1, text2));
    }
}
