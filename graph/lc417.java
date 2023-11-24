package graph;

import java.util.*;

public class lc417 {
    private int[][] directions = new int[][] {{0,1},{1,0},{-1,0},{0,-1}};
    private int numrows;
    private int numcols;
    private int[][] land;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        if (heights.length == 0 || heights[0].length == 0) {
            return new ArrayList<>();
        }
        numrows = heights.length;
        numcols = heights[0].length;
        land = heights;
        Queue<int[]> pacific = new LinkedList<>();
        Queue<int[]> atlantic = new LinkedList<>();
        for (int i = 0; i < numrows; i++) {
            pacific.offer(new int[]{i, 0});
            atlantic.offer(new int[] {i, numcols - 1});
        }
        for (int i =0; i < numcols; i++) {
            pacific.offer(new int[]{0, i});
            atlantic.offer(new int[]{numrows - 1, i});
        }
        boolean[][] pacificReachable = bfs(pacific);
        boolean[][] atlanticReachable = bfs(atlantic);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < numrows; i++) {
            for (int j =0; j < numcols; j++) {
                if (pacificReachable[i][j] && atlanticReachable[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }
    private boolean[][] bfs(Queue<int[]> queue) {
        boolean[][] res = new boolean[numrows][numcols];
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            res[cell[0]][cell[1]] = true;
            for (int[] dir : directions) {
                int newrow = cell[0] + dir[0];
                int newcol = cell[1] + dir[1];
                if (newrow < 0 || newcol < 0 || newrow >= numrows || newcol >= numcols) {
                    continue;
                }
                if (res[newrow][newcol]) continue;
                if (land[newrow][newcol] < land[cell[0]][cell[1]]) continue;
                queue.offer(new int[]{newrow, newcol});
            }
        }
        return res;
    }
}
