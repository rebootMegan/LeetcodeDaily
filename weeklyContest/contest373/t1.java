package weeklyContest.contest373;

public class t1 {

    public boolean areSimilar(int[][] mat, int k) {
        int n = mat.length, m = mat[0].length;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < m; j++) {
                    if (mat[i][j] != mat[i][((j - k) % m + m) % m]) return false;
                }
            } else {
                for (int j = 0; j < m; j++) {
                    if (mat[i][j] != mat[i][(j + k) % m]) return false;
                }
            }
        }
        return true;
    }
}
