import java.util.Arrays;
import java.util.PriorityQueue;

public class lc2290 {
    //min obstacle removal to reach corner
    public int minObstacles(int[][] grid) {
        int[][] arr = new int[grid.length][grid[0].length];
        for (int[] a : arr) {
            Arrays.fill(a, Integer.MAX_VALUE);
        }
        int[][] dir = {{-1,0},{0,1},{0,-1},{1,0}};
        arr[0][0] = grid[0][0];
        PriorityQueue<pair> pq = new PriorityQueue<>((a,b) -> a.cost - b.cost);
        pq.add(new pair(0, 0, arr[0][0]));
        while (!pq.isEmpty()) {
            pair node = pq.poll();
            for (int[] d : dir) {
                int x = d[0] + node.i;
                int y = d[1] + node.j;
                if (x >= 0 && y >= 0 && x < grid.length && y < grid[0].length) {
                    if (node.cost + grid[x][y] <arr[x][y]) {
                        arr[x][y] = node.cost + grid[x][y];
                        pq.add(new pair(x, y, arr[x][y]));
                    }
                }
            }
        }
        return arr[grid.length - 1][grid[0].length - 1];
    }
}
class pair {
    int i, j;
    int cost;
    public pair(int i, int j, int cost) {
        this.i =i;
        this.j = j;
        this.cost = cost;
    }
}
