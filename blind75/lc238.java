package blind75;

public class lc238 {
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        ans[0] =1;
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            ans[i] = nums[i - 1] * ans[i - 1];
        }
        int r = 1;
        for (int i = len - 1; i>= 0; i--) {
            // 对于索引 i，左边的乘积为 answer[i]，右边的乘积为 R
            ans[i] = ans[i] * r;
            r *= nums[i];
        }
        return ans;
    }
}
