package blind75;

public class lc115 {
    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        if (m < n) {
            return 0;
        }
        int[][] dp = new int[m + 1][n + 1];
        // dp[i][j] represents the number of distinct subsequences of s[0, i - 1] and t[0, j - 1]
        // dp[i][j] = dp[i - 1][j] + (s[i - 1] == t[j - 1] ? dp[i - 1][j - 1] : 0)
        // dp[i][0] = 1
        // dp[0][j] = 0
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }
        // for (int j = 0; j <= n; j++) {
        //     dp[0][j] = 0;
          // }
        for (int i = 1; i <= m; i++) {
            char c1 = s.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                char c2 = t.charAt(j - 1);
                dp[i][j] = dp[i - 1][j];
                if (c1 == c2) {
                    dp[i][j] += dp[i - 1][j - 1];
                }
            }
        }
        return dp[m][n];
    }
}
