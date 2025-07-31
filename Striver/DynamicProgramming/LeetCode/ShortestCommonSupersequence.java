package Striver.DynamicProgramming.LeetCode;

public class ShortestCommonSupersequence {
    public String shortestCommonSupersequence(String str1, String str2) {
        return helperTab(str1, str2);
    }

    static String helperTab(String text1, String text2){
        int n = text1.length();
        int m = text2.length();

        int[][] dpIndexShift = new int[n + 1][m + 1];

        //Base Case - No need to explicitly state that as array is initialized with 0. 
        // for(int i = 0; i <= n; i++) dpIndexShift[i][0] = 0;
        // for(int j = 0; j <= m; j++) dpIndexShift[0][j] = 0;

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
                }else{
                    dpIndexShift[i][j] = 0 + Math.max(dpIndexShift[i - 1][j], dpIndexShift[i][j - 1]);
                }
            }
        }
        
        int lenLCS = dpIndexShift[n][m];

        StringBuilder shortestCommonSupersequence = new StringBuilder();

        int i = n, j = m;

        while(i > 0 && j > 0){
            if(text1.charAt(i - 1) == text2.charAt(j - 1)){
                shortestCommonSupersequence.append(text1.charAt(i - 1));
                i--;j--;
            }else if(dpIndexShift[i - 1][j] > dpIndexShift[i][j - 1]){
                shortestCommonSupersequence.append(text1.charAt(i - 1));
                i--;
            }else{
                shortestCommonSupersequence.append(text2.charAt(j - 1));
                j--;
            }
        }

        while(i > 0) shortestCommonSupersequence.append(text1.charAt(-1 + i--));

        while(j > 0) shortestCommonSupersequence.append(text2.charAt(-1 + j--));

        shortestCommonSupersequence.reverse();

        return shortestCommonSupersequence.toString();
    }
}
