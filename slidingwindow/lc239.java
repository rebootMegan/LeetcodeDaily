package slidingwindow;

import java.util.Deque;
import java.util.LinkedList;

public class lc239 {
    /**
     * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
     * 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位
     * 返回 滑动窗口中的最大值 。
     * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
     * 输出：[3,3,5,5,6,7]
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> q = new LinkedList<>();
        for (int i =0; i < k; i++) {
            while (!q.isEmpty() && nums[i] >= nums[q.peekLast()]) {
                q.pollLast();
            }
            q.offerLast(i);
        }
        int[] ans = new int[n - k + 1];
        ans[0] = nums[q.peekFirst()];
        for (int i = k; i < n; i++) {
            while (!q.isEmpty() && nums[i] >= nums[q.peekLast()]) {
                q.pollLast();
            }
            q.offerLast(i);
            while (q.peekFirst() <= i - k) {
                q.pollFirst();
            }
            ans[i - k + 1] = nums[q.peekFirst()];
        }
        return ans;
    }
}
//时间复杂度：O(n)
//空间复杂度：O(k) 方法一不同的是，在方法二中我们使用的数据结构是双向的，因此「不断从队首弹出元素」保证了队列中最多不会有超过 k+1k+1k+1 个元素，因此队列使用的空间为 O(k)O(k)O(k)。
