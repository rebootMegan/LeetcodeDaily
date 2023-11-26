public class lc1319 {
    /**
     * Return the minimum number of times you need to do this in order to make all the computers connected. If it is not possible, return -1.
     * @param n
     * @param connections
     * @return
     */
    public int makeConnected(int n, int[][] connections) {
        int[] parent = new int[n];
        int m = connections.length;
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        int components = 0;
        int extraEdge = 0;
        for (int i = 0; i < m; i++) {
            int p1 = find(parent, connections[i][0]);
            int p2 = find(parent, connections[i][1]);
            if (p1 == p2) extraEdge++;
            else parent[p1] = p2;
        }
        for (int i = 0; i < n; i++) {
            if (parent[i] == i) {
                components++;
            }
        }
        return (extraEdge >= components - 1) ? components - 1 : -1;
    }

    private int find(int[] parent, int i) {
        if (parent[i] == i) return i;
        return parent[i] = find(parent, parent[i]);
    }
}
