package lintcode;
//maze

/**
 * 在迷宫中有一个球，里面有空的空间和墙壁。球可以通过滚上，下，左或右移动，
 * 但它不会停止滚动直到撞到墙上。当球停止时，它可以选择下一个方向。
 *
 * 给定球的起始位置，目的地和迷宫，确定球是否可以停在终点。
 *
 * 迷宫由二维数组表示。1表示墙和0表示空的空间。你可以假设迷宫的边界都是墙。开始和目标坐标用行和列索引表示。
 */
public class lc787 {
    /**
     * @param maze: the maze
     * @param start: the start
     * @param destination: the destination
     * @return: whether the ball could stop at the destination
     * dfs
     * 我们可以使用深度优先搜索对整颗搜索树进行遍历。
     * 我们从起始位置开始，每次选择一条路线进行搜索，并用一个二维布尔数组 visited 表示是否曾经到达过位置 (i, j) ，若在某一次搜索到位置 (i, j) 时，visited[i, j] = true，那么我们可以进行回溯，不必继续搜索下去。
     */
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        return dfs(maze, start, destination, visited);
    }
    private boolean dfs(int[][] maze, int[] start, int[] destination, boolean[][] visited) {
        if (visited[start[0]][start[1]]) {
            return false;
        }
        if (start[0] == destination[0] && start[1] == destination[1]) {
            return true;
        }
        visited[start[0]][start[1]] = true;
        int r = start[1] + 1, l = start[1] - 1, u = start[0] - 1, d = start[0] + 1;
        while (r < maze[0].length && maze[start[0]][r] == 0) // right
            r++;
        if (dfs(maze, new int[] {start[0], r - 1}, destination, visited)) {
            return true;
        }
        while (l >= 0 && maze[start[0]][l] == 0) { //left
            l--;
        }
        if (dfs(maze, new int[]{start[0], l + 1}, destination, visited)) {
            return true;
        }
        while (u >= 0 && maze[u][start[1]] == 0) { //up
            u--;
        }
        if (dfs(maze, new int[]{u + 1, start[1]}, destination, visited)) {
            return true;
        }
        while (d < maze.length && maze[d][start[1]] == 0) { //down
            d++;
        }
        if (dfs(maze, new int[]{d - 1, start[1]}, destination, visited)) {
            return true;
        }
        return false;
    }
}
//time O(mn)
//space O(mn)
