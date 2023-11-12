package blind75;

import java.util.*;

public class lc210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] indegree = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            int dest = prerequisites[i][0];
            int src = prerequisites[i][1];
            List<Integer> list = graph.getOrDefault(src, new ArrayList<>());
            list.add(dest);
            graph.put(src, list);
            indegree[dest] += 1;
        }
        return helper(graph, indegree);
    }

    private int[] helper(Map<Integer, List<Integer>> graph, int[] indegree) {
        int[] res = new int[indegree.length];
         Queue<Integer> q = new LinkedList<>();
         for (int i = 0; i < indegree.length; i++) {
             if (indegree[i] == 0) {
                 q.offer(i);
             }
         }
         int k =0;
         while (!q.isEmpty()) {
             int cur = q.poll();
             res[k++] = cur;
              if (graph.containsKey(cur)) {
                  for (int i : graph.get(cur)) {
                      if (--indegree[i] == 0) {
                          q.offer(i);
                      }
                  }
              }
         }
         if (k == indegree.length) return res;
         else return new int[]{};
    }

}
