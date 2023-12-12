package hard;
import java.util.*;
public class lc632 {
    /**
     * You have k lists of sorted integers in non-decreasing order. Find the smallest range that includes at least one number from each of the k lists.
     * We define the range [a, b] is smaller than range [c, d] if b - a < d - c or a < c if b - a == d - c.
     * @param nums
     * @return
     */
    public int[] smallestRange(List<List<Integer>> nums) {
        int n = nums.size();
        int[] ans = new int[2];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int range = Integer.MAX_VALUE;
        int[] index = new int[n];
        boolean flag = true;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> nums.get(a).get(index[a]) - nums.get(b).get(index[b]));
        for (int i = 0; i < n; i++) {
            pq.offer(i);
            max = Math.max(max, nums.get(i).get(0));
        }
        while (flag) {
            int minIndex = pq.poll();
            min = nums.get(minIndex).get(index[minIndex]);
            if (range > max - min) {
                range = max - min;
                ans[0] = min;
                ans[1] = max;
            }
            index[minIndex]++;
            if (index[minIndex] == nums.get(minIndex).size()) {
                flag = false;
                break;
            }
            pq.offer(minIndex);
            max = Math.max(max, nums.get(minIndex).get(index[minIndex]));
        }
        return ans;
    }
}
