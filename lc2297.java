import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class lc2297 {
    public long minCost(int[] nums, int[] costs) {
        Deque<Integer> one = new ArrayDeque<>();
        Deque<Integer> two = new ArrayDeque<>();
        long[] dp = new long[nums.length];
        Arrays.fill(dp, Long.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!one.isEmpty() && nums[one.peekLast()] <= nums[i]) {
                one.pollLast();
            }
            while (!two.isEmpty() && nums[two.peekLast()] >= nums[i]) {
                two.pollLast();
            }
            one.push(i);
            two.push(i);
        }
        return dp[nums.length - 1];
    }
}
