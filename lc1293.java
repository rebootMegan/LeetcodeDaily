import java.util.Deque;
import java.util.LinkedList;

public class lc1293 {
    public int shortestPath(int[][] grid, int k) {
        int row = grid.length, col = grid[0].length;
        if (row == 1 && col == 1) {
            return 0;
        }
        int[][] dirs = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
        Deque<int[]> queue = new LinkedList<>();
        int[][] visited = new int[row][col];
        for (int i =0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                visited[i][j] = -1;
            }
        }
        queue.offer(new int[] {0, 0, k});
        visited[0][0] = k;
        int step = 0;
        while (!queue.isEmpty()) {
            int cursize = queue.size();
            step++;
            for (int i = 0; i < cursize; i++) {
                int[] curpos = queue.poll();
                int x = curpos[0], y = curpos[1];
                for (int j = 0; j < 4; j++) {
                    int nx = x + dirs[j][0];
                    int ny = y + dirs[j][1];
                    int currk = curpos[2];
                    if (nx >= 0 && ny >= 0 && nx < row && ny < col) {
                        if (nx == row - 1 && ny == col - 1) {
                            return step;
                        }
                        currk = grid[nx][ny] == 0 ? currk : --currk;
                        if (currk >= 0) {
                            if (visited[nx][ny] == -1 || (visited[nx][ny] != -1 && currk > visited[nx][ny])) {
                                queue.offer(new int[]{nx, ny, currk});
                            }
                        }
                    }
                }
            }
        }
        return -1;
    }
}
