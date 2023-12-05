import java.util.Arrays;

public class lc1101 {
    public int earlistAcq(int[][] logs, int n) {
        Arrays.sort(logs, (a, b) -> a[0] - b[0]);
        int[] parent = new int[n];
        int count = n;
        for (int[] log : logs) {
            if (find(parent, log[1]) != find(parent, log[2])) {
                union(parent, log[1], log[2]);
                count--;
            }
            if (count == 1) return log[0];
        }
        return -1;
    }
    private int find(int[] parent, int i) {
        if (parent[i] == 0) {
            parent[i] = i;
        }
        return parent[i] == i ? i : find(parent, parent[i]);
    }
    private void union(int[] parent, int i, int j) {
        int pi = find(parent, i), pj = find(parent, j);
        if (pi != pj) {
            parent[pi] = pj;
        }
    }
}
