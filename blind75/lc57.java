package blind75;

import java.util.ArrayList;
import java.util.List;

public class lc57 {
    /**
     * 给你一个 无重叠的 ，按照区间起始端点排序的区间列表。
     *
     * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
     *
     * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
     * 输出：[[1,5],[6,9]]
     * @param intervals
     * @param newInterval
     * @return
     * 当我们需要插入一个新的区间 S=[left,right]S = [\textit{left}, \textit{right}]S=[left,right] 时，我们只需要：
     * 找出所有与区间S 重叠的区间集合 X 中的所有区间连带上区间 S 合并成一个大区间；
     * 最终的答案即为不与X重叠的区间以及合并后的大区间。
     *
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int left = newInterval[0];
        int right = newInterval[1];
        boolean place = false;
        List<int[]> ansList = new ArrayList<>();
        for (int[] interval : intervals) {
            if (interval[0] > right) {

                if (!place) {
                    ansList.add(new int[]{left, right});
                    place = true;
                }
                ansList.add(interval);
            }else if (interval[1]< left) {
                ansList.add(interval);
            }else {
                // 与插入区间有交集，计算它们的并集
                left = Math.min(left, interval[0]);
                right = Math.max(right, interval[1]);
            }
        }
        if (!place) {
            ansList.add(new int[]{left, right});
        }
        int[][] ans =new int[ansList.size()][2];
        for (int i = 0; i < ansList.size(); i++) {
            ans[i] = ansList.get(i);
        }
        return ans;
    }
}
