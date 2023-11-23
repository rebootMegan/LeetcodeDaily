package blind75;

public class lc323 {

        public int countComponents(int n, int[][] edges) {
            int[] parent = new int[n];
            UnionFind uf = new UnionFind(n);

            for (int[] e : edges) {
                uf.union(e[0], e[1]);
            }

            return uf.count();
        }
    }

    class UnionFind {
        private int count = 0;
        private int[] parent, rank;

        public UnionFind(int n) {
            count = n;
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int p) {
            while (p != parent[p]) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }

        public void union(int p, int q) {
            int rootp = find(p);
            int rootq = find(q);
            if (rootp == rootq) return;
            if (rank[rootq] > rank[rootp]) {
                parent[rootp] = rootq;
            } else {
                parent[rootq] = rootp;
                if (rank[rootp] == rank[rootq]) {
                    rank[rootp]++;
                }
            }
            count--;
        }

        public int count() {
            return count;
        }
    }