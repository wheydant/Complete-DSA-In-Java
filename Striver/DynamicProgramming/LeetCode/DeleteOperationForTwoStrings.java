package Striver.DynamicProgramming.LeetCode;

public class DeleteOperationForTwoStrings {
    public int minDistance(String word1, String word2) {
        String tempWord = word1;
        if(word2.length() > word1.length()){
            word1 = word2;
            word2 = tempWord;
        }
        return helperSO(word1, word2);
    }
    int helperSO(String text1, String text2){
        int n = text1.length();
        int m = text2.length();

        int[] dpPrev = new int[m + 1];

        //Base Case - No need to explicitly state that as array is initialized with 0. 
        // for(int i = 0; i <= n; i++) dpIndexShift[i][0] = 0;
        for(int j = 0; j <= m; j++) dpPrev[j] = 0;

        for(int i = 1; i <= n; i++){
            int[] dpCurr = new int[m + 1];
            for(int j = 1; j <= m; j++){
                //This whole can be skip using i,j -> 1 
                // if(i == 0 || j == 0){
                    // No need to explicitly state it.
                    // dpIndexShift[i][j] = 0;
                    // continue;
                // }
                if(text1.charAt(i - 1) == text2.charAt(j - 1)){
                    dpCurr[j] = 1 + dpPrev[j - 1];
                }else{
                    dpCurr[j] = 0 + Math.max(dpPrev[j], dpCurr[j - 1]);
                }
            }

            dpPrev = dpCurr;
        }

        int commonSubsequenceLen = dpPrev[m];

        //n + m is maximum number of operations we can perform to delete everything and make them same.

        //string 1 deletion
        int d1 = n - commonSubsequenceLen;

        //String 2 deletion
        int d2 = m - commonSubsequenceLen;

        int ans = d1 + d2;
        
        return n + m - 2*commonSubsequenceLen;
    }
}
