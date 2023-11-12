import java.awt.*;
import java.util.ArrayList;

import java.util.*;
import java.util.List;

public class busRoutes {
    //return the least number of buses you must take to travel from source to target. Return -1 if it is not possible.
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) return 0;
        int n =routes.length;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i =0; i < n; i++) {
            Arrays.sort(routes[i]);
            graph.add(new ArrayList<>());
        }
        Set<Integer> seen = new HashSet<>();
        Queue<Point> queue = new ArrayDeque();
        Set<Integer> targets = new HashSet<>(); //the point we have reached before

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (interact(routes[i], routes[j])) {
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            //For each array, check if the source value is present using binarySearch
            if (Arrays.binarySearch(routes[i], source) >=0) {
                //returns the index of the search key if it is contained in the array;
                seen.add(i);
                queue.offer(new Point(i, 0));   //{idx, depth}
            }
            if (Arrays.binarySearch(routes, target) >= 0) {
                targets.add(i);
            }
        }

        //bfs
        while (!queue.isEmpty()) {
            Point info = queue.poll();
            int node =info.x, depth = info.y;
            if (targets.contains(node)) {
                return depth + 1;
            }
            for (Integer nei : graph.get(node)) {
                if (!seen.contains(nei)) {
                    queue.offer(new Point(nei, depth + 1));
                    seen.add(nei);
                }
            }
        }
        return -1;
    }

    /**
     * if two routes have interactions
     * @param a
     * @param b
     * @return
     */
    private boolean interact(int[] a, int[] b) {
        int i = 0,j =0;
        while (i < a.length && j < b.length) {
            if (a[i] == b[j]) return true;
            if (a[i] < b[j]) i++;
            else j++;
        }
        return false;
    }

}
