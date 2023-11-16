package blind75;

public class lc547 {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        UnionFind uf = new UnionFind(n);
        int numOfComponents = n;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; ++j) {
                if (isConnected[i][j] == 1&& uf.find(i) != uf.find(j)) {
                    numOfComponents--;
                    uf.union(i, j);
                }
            }
        }
        return numOfComponents;
    }
    class UnionFind {
        int[] parent;
        int[] rank;
        public UnionFind(int size) {
            parent= new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
            }
            rank = new int[size];
        }
        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
        public void union(int x, int y) {
            int xp = find(x), yp = find(y);
            if (xp == yp) return;
            else if (rank[xp] < rank[yp]) {
                parent[xp] = yp;
            }else if (rank[xp] > rank[yp]) {
                parent[yp] = xp;
            }else {
                parent[yp] = xp;
                rank[xp]++;
            }
        }
    }
}
