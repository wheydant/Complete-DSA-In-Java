package KunalKushwaha.Assignments.String;

public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[][] dp = new boolean[m + 1][n + 1];

        dp[0][0] = true;

        // pattern like a*, a*b* can be complete empty string last index will always be true then
        for(int j = 2; j <= n; j++){
            if(p.charAt(j - 1) == '*')
                dp[0][j] = dp[0][j - 2];
        }

        // System.out.println(Arrays.deepToString(dp));
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                char pc = p.charAt(j - 1);

                if(pc == '*'){
                    // Zero occurrences of the preceding element - ba*c -> bc
                    dp[i][j] = dp[i][j - 2];

                    // One or more occurrences: check if preceding element p[j - 2] matches s[i - 1]
                    char pPrev = p.charAt(j - 2);
                    if(pPrev == '.' || pPrev == s.charAt(i - 1)){
                        // dp[i][j] == dp[i][j - 2] it has this value.
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                        //dp[i - 1][j] a*b aaab
                    }
                }else {
                    //Single match or exact match
                    if(pc == '.' || pc == s.charAt(i - 1))
                        dp[i][j] = dp[i - 1][j - 1];
                    else
                        dp[i][j] = false;
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        System.out.println(new RegularExpressionMatching().isMatch("aa", "a*"));
        System.out.println(new RegularExpressionMatching().isMatch("aaa", "a*"));
        System.out.println(new RegularExpressionMatching().isMatch("aaa", "a*b"));
        System.out.println(new RegularExpressionMatching().isMatch("aab", "a.b"));
        System.out.println(new RegularExpressionMatching().isMatch("aa", "a*"));
        System.out.println(new RegularExpressionMatching().isMatch("ab", ".*"));
        System.out.println(new RegularExpressionMatching().isMatch("abc", "a**abc"));
        System.out.println(new RegularExpressionMatching().isMatch("abc", "a*b*c*"));
        System.out.println(new RegularExpressionMatching().isMatch("xyzaaab", "xyzc*a*b*"));
    }
}
