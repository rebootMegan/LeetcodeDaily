package lintcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class lc401 {
    //find the smallest kth from a sorted matrix
    //the matrix is in ascending order from left to right, from top to down
    class Pair {
        public int x, y, val;
        public Pair(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }
    class PairComparator implements Comparator<Pair> {
        public int compare(Pair a, Pair b) {
            return a.val - b.val;
        }
    }
    public class Solution {
        public int kthSmallest(int[][] matrix ,int k) {
            int[] dx = new int[]{0,1};
            int[] dy = new int[]{1,0};
            int n = matrix.length;
            int m = matrix[0].length;
            boolean[][] hash = new boolean[n][m];
            PriorityQueue<Pair> minheap = new PriorityQueue<>(k, new PairComparator());
            minheap.add(new Pair(0, 0, matrix[0][0]));

            for (int i = 0; i <k - 1; i++) {
                Pair cur = minheap.poll();
                for (int j = 0; j < 2; j++) {
                    int nextx = cur.x + dx[j];
                    int nexty = cur.y + dy[j];
                    Pair nextPair = new Pair(nextx, nextx, 0);
                    if (nextx < n && nexty < m && !hash[nextx][nexty]) {
                        hash[nextx][nexty] = true;
                        nextPair.val = matrix[nextx][nexty];
                        minheap.add(nextPair);
                    }
                }
            }
            return minheap.peek().val;
        }
    }

    class ResultType {
        public int num;
        public boolean exists;
        public ResultType(boolean e, int n) {
            exists = e;
            num = n;
        }
    }
    //binary search approach
    public int kthSmallest2(int[][] matrix, int k) {
        int n =matrix.length, m = matrix[0].length;
        int left = matrix[0][0], right = matrix[n -1][m - 1];
        //left +1 < right
        while (left <= right) {
            int mid = left + (right - left)/ 2;
            ResultType type = check(mid, matrix);
            if (type.exists && type.num == k) {
                return mid;
            }else if (type.num < k) {
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return left;
    }

    private ResultType check(int value, int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        boolean exists = false;
        int num = 0;
        int i =n - 1, j = 0;
        while (i >= 0 && j < m) {
            if (matrix[i][j] == value) {
                exists= true;
            }
            if (matrix[i][j] <= value) {
                j++;
                num += i + 1;
            }else {
                i--;
            }
        }
        return new ResultType(exists, num);
    }
}

