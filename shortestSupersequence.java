public class shortestSupersequence {
    public static String shortestSupersequence(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j <= m; j++) {
            dp[0][j] = 0;
        }
        for (int id1 = 1; id1 <= n; id1++) {
            for (int id2 = 1; id2 <= m; id2++) {
                if (s1.charAt(id1 - 1) == s2.charAt(id2 - 1)) {
                    dp[id1][id2] = dp[id1 - 1][id2 - 1] + 1;
                }else {
                    dp[id1][id2] = Math.max(dp[id1 - 1][id2], dp[id1][id2 - 1]);
                }
            }
        }
        int len = dp[n][m];
        StringBuilder sb = new StringBuilder();
        int i = n, j = m;
        int idx = len - 1;
        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                sb.append(s1.charAt(i - 1));
                i--;
                j--;
                idx--;
            }else if (dp[i - 1][j] > dp[i][j - 1]) {
                sb.append(s1.charAt(i - 1));
                i--;
            }else {
                sb.append(s2.charAt(j - 1));
                j--;
            }
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String s1 = "brute", s2 = "groot";
        System.out.println(shortestSupersequence(s1, s2));
    }
}
