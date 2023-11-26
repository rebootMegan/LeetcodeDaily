import java.util.LinkedList;
import java.util.Queue;

public class lc909 {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        boolean[] visited = new boolean[n * n + 1];
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        visited[1] = true;
        int step = 0;
        while (!q.isEmpty()) {
            int size= q.size();
            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                if (cur == n * n) {
                    return step;
                }
                for (int j = 1; j <= 6 && cur + j <= n * n; j++) {
                    int next = cur + j;
                    int[] pos = getPos(next ,n);
                    if (board[pos[0]][pos[1]] != -1) {
                        next = board[pos[0]][pos[1]];
                    }
                    if (!visited[next]) {
                        visited[next] = true;
                        q.offer(next);
                    }
                }
            }
            step++;
        }
        return -1;
    }
    public int[] getPos(int next, int n) {
        int r = (next - 1) / n;
        int x = n - 1 - r;
        int y = r % 2 == 0 ? next - 1 - r * n : n - 1 - (next - 1 - r * n);
        return new int[]{x, y};
    }
}
