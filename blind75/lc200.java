package blind75;

import java.util.*;

public class lc200 {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    bfs(grid, i, j, m, n);
                }
            }
        }
        return count;
    }
    private final int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private void bfs(char[][] grid, int i, int j,  int m, int n) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            for (int[] dir : dirs) {
                int ii = curr[0] + dir[0], jj = curr[1] + dir[1];
                if (ii < 0 || ii >= m || j < 0 || jj >= n || grid[ii][jj] == '0') {
                    continue;
                }
                queue.offer(new int[] {ii, jj});
                grid[ii][jj] = '0';
            }
        }
        return;
    }
}

