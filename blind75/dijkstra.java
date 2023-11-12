package blind75;

import java.util.*;

public class dijkstra {
    public Map<Integer, Integer> shortestPath(int n, List<List<Integer>> edges, int src) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<>());
        }
        //s =src, d= dest, w = weight
        for (List<Integer> edge : edges) {
            int s = edge.get(0), d = edge.get(1), w = edge.get(2);
            adj.get(s).add(new int[] {d, w});
        }
        //compute shortest paths
        Map<Integer, Integer> shortest = new HashMap<>();
        PriorityQueue<int[]> minheap = new PriorityQueue<>(Comparator.comparingInt(a->a[0]));
        minheap.offer(new int[]{0, src});  //weight, node
        while (!minheap.isEmpty()) {
            int[] curr = minheap.poll();
            int w1 = curr[0], n1 = curr[1];
            if (shortest.containsKey(n1)) continue;
            shortest.put(n1, w1);

            for (int[] edge : adj.get(n1)) {
                int n2 = edge[0], w2 = edge[1];
                if (!shortest.containsKey(n2)) {
                    minheap.offer(new int[]{w1 + w2, n2});
                }
            }
        }
        for (int i = 0; i < n; i++) {
            shortest.putIfAbsent(i, -1);
        }
        return shortest;
    }
}
