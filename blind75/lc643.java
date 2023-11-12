package blind75;

//给你一个由 n 个元素组成的整数数组 nums 和一个整数 k 。
//
//请你找出平均数最大且 长度为 k 的连续子数组，并输出该最大平均数。

//示例 1：

//输入：nums = [1,12,-5,-6,50,3], k = 4
//输出：12.75
//解释：最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
public class lc643 {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        int n = nums.length;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        int maxsum = sum;
        for (int i = k; i < n; i++) {
            sum = sum - nums[i - k] + nums[i];
            maxsum = Math.max(maxsum, sum);
        }
        return 1.0 * maxsum / k;
    }
}
