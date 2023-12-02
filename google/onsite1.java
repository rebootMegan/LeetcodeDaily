package google;

public class onsite1 {
    /**
     * To solve this challenge, we need to implement a function that counts the number of lakes surrounded by land ('X') in a given grid. A lake is defined as a group of horizontally or vertically adjacent water cells ('.') that are surrounded by land cells.
     */


    private static final char LAND = 'X';
    private static final char WATER = '.';

    public static int countLakes(char[][] image) {
        int count = 0;
        boolean[][] visited = new boolean[image.length][image[0].length];

        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[i].length; j++) {
                if (image[i][j] == WATER && !visited[i][j]) {
                    if (isLake(image, i, j, visited)) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    private static boolean isLake(char[][] image, int i, int j, boolean[][] visited) {
        if (i < 0 || i >= image.length || j < 0 || j >= image[0].length) {
            return false; // Not surrounded by land if it touches the edge
        }

        if (visited[i][j] || image[i][j] == LAND) return true;

        visited[i][j] = true;

        boolean up = isLake(image, i - 1, j, visited);
        boolean down = isLake(image, i + 1, j, visited);
        boolean left = isLake(image, i, j - 1, visited);
        boolean right = isLake(image, i, j + 1, visited);

        return up && down && left && right;
    }

    public static void main(String[] args) {
        char[][] image = {
                {'X', '.', '.', '.', 'X', '.', '.', '.', 'X', '.'},
                {'.', 'X', '.', 'X', '.', 'X', '.', 'X', '.', '.'},
                {'X', '.', '.', '.', '.', '.', 'X', '.', '.', 'X'},
                {'.', 'X', '.', '.', 'X', '.', '.', 'X', '.', '.'},
                // Add the rest of the image rows here
        };

        System.out.println("Number of lakes: " + countLakes(image));
    }
}