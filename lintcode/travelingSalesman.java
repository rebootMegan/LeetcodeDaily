package lintcode;

//给 n 个城市(从 1 到 n)，城市和无向道路成本之间的关系为3元组 [A, B, C]（在城市 A 和城市 B 之间有一条路，成本是 C）
// 我们需要从 1 号城市开始找到的旅行所有城市的付出最小的成本。
public class travelingSalesman {
    /**
     * @param n: an integer,denote the number of cities
     * @param roads: a list of three-tuples,denote the road between cities
     * @return: return the minimum cost to travel all cities
     */
    public int minCost(int n, int[][] roads) {
        int inf = 100000000;
        int[][] graph = constructGraph (roads, n);
        int stateSize = 1 << n;
        int[][] f = new int[stateSize][n + 1];
        for (int i = 0; i <stateSize; i++) {
            for (int j = 0; j < stateSize; j++) {
                f[i][j] = inf;
            }
        }
        f[1][1] = 0;
        for (int state = 0; state < stateSize; state++) {
            for(int i = 2; i < n + 1; i++) {
                if ((state & (1 << (i - 1))) == 0) {
                    continue;
                }
                int prevState = state ^ (1 << (i - 1));
                for (int j = 1 ; j <n + 1; j++) {
                    if ((prevState & (1 << (j - 1))) == 0) {
                        continue;
                    }
                    f[state][i] = Math.min(f[state][i], f[prevState][j] + graph[j][i]);
                }
            }
        }
        int minCost = inf;
        for (int i =0; i < n + 1; i++) {
            minCost = Math.min(minCost, f[stateSize - 1][i]);
        }
        return minCost;
    }

    private int[][] constructGraph(int[][] roads, int n) {
        int[][] graph = new int[n + 1][n + 1];
        int inf = 1000000000;
        for (int i = 0; i < n + 1; i++) {
            for (int j =0 ; j < n + 1; j++) {
                graph[i][j] = inf;
            }
        }
        int roadsLength =roads.length;
        for (int i =0; i < roadsLength; i++) {
            int a = roads[i][0], b=roads[i][1] , c = roads[i][2];
            graph[a][b] = Math.min(graph[a][b], c);
            graph[b][a] = Math.min(graph[b][a], c);
        }
        return graph;
    }
}
