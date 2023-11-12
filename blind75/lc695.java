package blind75;
public class lc695 {
    /**
     * you are given an m * n matrix grid, island is 1
     * @param grid
     * @return the max area of island in a grid if no island, return 0
     */
    public int maxAreaOfIsland(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        int res = 0;
        int m = grid.length, n = grid[0].length;
        for (int i =0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    res = Math.max(res, dfs(grid,i, j));
                }
            }
        }
        return res;
    }
    //return the island area
    private int dfs(int[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n) return 0;
        if (grid[i][j] == 0) return 0;
        //mark this visited
        grid[i][j] = 0;
        return dfs(grid,i +1, j) + dfs(grid, i - 1, j)
                + dfs(grid, i, j - 1) + dfs(grid, i, j+1) + 1;
    }
}

//tc : O(r*c) //every visit once
//sc: O(r*c)
