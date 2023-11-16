package blind75;

public class lc45 {
    public int jump(int[] nums) {
        int ans = 0, n = nums.length;
        int curEnd = 0, curFar = 0;
        for (int i = 0; i < n- 1; i++) {
            curFar = Math.max(curFar, i + nums[i]);
            // If we finish the starting range of this jump,
            // Move on to the starting range of the next jump.
            if (i == curEnd) {
                ans++;
                curEnd = curFar;
            }
        }
        return ans;
    }
}
