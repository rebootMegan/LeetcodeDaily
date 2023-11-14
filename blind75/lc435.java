package blind75;

import java.util.Arrays;
import java.util.Comparator;

public class lc435 {
    /**
     * Given an array of intervals  where intervals[i] = [starti, endi],
     * return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.
     *
     * Example 1:
     * Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
     * Output: 1
     * Explanation: [1,3] can be removed and the rest of the intervals are non-overlapping
     * @param nums
     * @return
     */
    public int eraseOverlapIntervals(int[][] nums) {
        Arrays.sort(nums, Comparator.comparingInt(a -> a[1]));
        int ans = 0;
        int k = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i][0];
            int y = nums[i][1];
            if (x >= k) {
                k = y;
            }else {
                ans++;
            }
        }
        return ans;
    }
}
