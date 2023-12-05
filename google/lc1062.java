package google;

public class lc1062 {
    public int longestRepeatingSubstring(String s) {
        int n = s.length();
        int[][] dp = new int[n + 1][n + 1];
        // dp[i][j] represents the length of the longest repeating substring of s[0, i - 1] and s[0, j - 1]
        // dp[i][j] = dp[i - 1][j - 1] + 1 if s[i - 1] == s[j - 1]
        // dp[i][j] = 0 if s[i - 1] != s[j - 1]
        // dp[0][j] = 0
        // dp[i][0] = 0
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            char c1 = s.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                char c2 = s.charAt(j - 1);
                if (c1 == c2 && i != j) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    ans = Math.max(ans, dp[i][j]);
                }
            }
        }
        return ans;
    }
}
