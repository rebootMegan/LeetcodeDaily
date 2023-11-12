import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class swiminRisingWater {
    /**The rain starts to fall. At time t, the depth of the water everywhere is t.
     * squares individually are at most t. You can swim infinite distances in zero time. Of course, you must stay within the boundaries of the grid during your swim.
     *
     * Return the least time until you can reach the bottom right square (n - 1, n - 1) if you start at the top left square (0, 0).
     * @param grid
     * @return
     */
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int lo = grid[0][0], hi = n * n;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (!possible(mid, grid)) {
                lo = mid + 1;
            }else {
                hi = mid;
            }
        }
        return lo;
    }
    private boolean possible(int T, int[][] grid) {
        int n = grid.length;
        Set<Integer> seen = new HashSet<>();
        seen.add(0);
        int[] dr = new int[]{1,-1,0,0};
        int[] dc = new int[]{0,0,1,-1};
        Stack<Integer> stack = new Stack<>();
        stack.add(0);
        while (!stack.isEmpty()) {
            int k = stack.pop();
            int r = k / n, c = k % n;
            if (r == n - 1 && c == n - 1) return true;
            for (int i = 0; i < 4; i++) {
                int cr = r + dr[i], cc = c + dc[i];
                int ck = cr * n + cc;
                if (cr >= 0 && cr < n && cc >= 0 && cc < n && !seen.contains(ck)
                && grid[cr][cc] <= T) {
                    stack.add(ck);
                    seen.add(ck);
                }
            }
        }
        return false;
    }
}
