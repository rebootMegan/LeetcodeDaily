import java.util.*;

public class lc2146 {
    /**
     * Hint 1
     * Could you determine the rank of every item efficiently?
     * Hint 2
     * We can perform a breadth-first search from the starting position and know the length of the shortest path from start to every item.
     * Hint 3
     * Sort all the items according to the conditions listed in the problem, and return the first k (or all if less than k exist) items as the answer.
     */
    public List<List<Integer>> highestRankedKItems(int[][] grid, int[] pricing, int[] start, int k) {
        List<List<Integer>> res = new ArrayList<>();
        int m = grid.length, n = grid[0].length;
        PriorityQueue<node> pq = new PriorityQueue<node>((a, b) -> {
            if (a.steps != b.steps) {
                return b.steps - a.steps;
            } else {
                int val1 = grid[a.i][a.j];
                int val2 = grid[b.i][b.j];
                if (val1 != val2) {
                    return val2 - val1;
                }else {
                    if (a.i != b.i) {
                        return b.i - a.i;
                    }else {
                        return b.j - a.j;
                    }
                }
            }
        });
        LinkedList<node> q = new LinkedList<>();
        q.addLast(new node(start[0], start[1], 0));
        boolean[][] visited = new boolean[m][n];
        visited[start[0]][start[1]]= true;
        int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};

        //q is used for BFS, pq is used for finding the shortest path
        while (!q.isEmpty()) {
            node cur = q.removeFirst();
            int price = grid[cur.i][cur.j];
            if (price != 1 && pricing[0] <= price && price <= pricing[1]) {  //in the pricing range
                pq.add(cur);
                if (pq.size() > k) {
                    pq.remove();
                }
            }
            for (int i =0; i < 4; i++) {
                int x = dir[i][0] + cur.i;
                int y = dir[i][1] + cur.j;
                if (x < 0 || y < 0 || x == m || y == n || visited[x][y] || grid[x][y] == 0) {
                    continue;
                }
                visited[x][y] = true;
                q.add(new node(x,y,cur.steps + 1));
            }
        }
        while (pq.size() > 0) {
            node temp = pq.remove();
            List<Integer> l = new LinkedList<>();
            l.add(temp.i);
            l.add(temp.j);
            res.add(l);
        }
        Collections.reverse(res);
        return res;
    }

    private class node {
        int steps;
        int i, j;

        public node(int i, int j, int steps) {
            this.i = i;
            this.j = j;
            this.steps = steps;
        }
    }

}