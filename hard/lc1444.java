package hard;

public class lc1444 {
    /**
     * 1444. Number of Ways of Cutting a Pizza
     * Given a rectangular pizza represented as a rows x cols matrix containing the following characters: 'A' (an apple) and '.' (empty cell) and given the integer k. You have to cut the pizza into k pieces using k-1 cuts.
     *
     * For each cut you choose the direction: vertical or horizontal, then you choose a cut position at the cell boundary and cut the pizza into two pieces. If you cut the pizza vertically, give the left part of the pizza to a person. If you cut the pizza horizontally, give the upper part of the pizza to a person. Give the last piece of pizza to the last person.
     *
     * Return the number of ways of cutting the pizza such that each piece contains at least one apple. Since the answer can be a huge number, return this modulo 10^9 + 7.
     */
    public int ways(String[] pizza, int k) {
        int rows = pizza.length, cols = pizza[0].length();
        int[][] apples = new int[rows + 1][cols+ 1];
        int dp[][][] = new int[k][rows][cols];
        for (int row = rows - 1; row >= 0; row--) {
            for(int col = cols - 1; col >= 0; col--) {
                apples[row][col] = (pizza[row].charAt(col) == 'A' ? 1 : 0) +
                        apples[row+1][col] + apples[row][col+1] - apples[row+1][col+1];
                dp[0][row][col] = apples[row][col] > 0 ? 1: 0;
            }
        }
        int mod = 1000000007;
        for (int remain = 1; remain < k; remain++) {
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    for (int next_row = row + 1; next_row < rows; next_row++) {
                        if (apples[row][col] - apples[next_row][col] > 0 ) {
                            dp[remain][row][col] += dp[remain-1][next_row][col];
                            dp[remain][row][col] %= mod;
                        }
                    }
                    for (int next_col = col + 1; next_col < cols; next_col++) {
                        if (apples[row][col] - apples[row][next_col] > 0) {
                            dp[remain][row][col] += dp[remain-1][row][next_col];
                            dp[remain][row][col] %= mod;
                        }
                    }
                }
            }
        }
        return dp[k -1][0][0];
    }
}

