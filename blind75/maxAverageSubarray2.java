package blind75;

public class maxAverageSubarray2 {
    //给出一个整数数组，有正有负。找到这样一个子数组，他的长度大于等于 k，且平均值最大。
    //
    //保证数组的大小 >= k
    //输入:
    //[1,12,-5,-6,50,3]
    //3
    //输出:
    //15.67
    //解释:
    // (-6 + 50 + 3) / 3 = 15.67

    /**
     * 二分出 average 之后，把数组中的每个数都减去 average，然后的任务就是去求这个数组中，是否有长度 >= k 的 subarray，他的和超过 0。
     * @param nums
     * @param k
     * @param avg
     * @return
     */
    protected boolean check(int[] nums, int k, double avg) {
        //rightsum refers to the prefixSum which count up till current position
        //leftsum refers to the prefixSum which sums up till points to the k left to current position
        //minLeftsum refers to the min prefixsum so far
        double rightSum = 0, leftSum = 0;
        double minLeftSum = 0;
        for (int i =0; i < k; i++) {
            rightSum += nums[i] - avg;
        }
        for (int i = k; i <= nums.length; i++) {
            if (rightSum - minLeftSum >= 0) {
                return true;
            }
            if (i < nums.length) {
                rightSum += nums[i] - avg;
                leftSum += nums[i - k] - avg;
                minLeftSum = Math.min(minLeftSum, leftSum);
            }
        }
        return false;
    }
    public double maxAverage(int[] nums, int k) {
        double left, right, mid;
        left = right = nums[0];
        for (int i = 0; i < nums.length; i++) {
            left = Math.min(nums[i], left);
            right = Math.max(nums[i], right);
        }
        while (left + 1e-5 < right) {
            mid = left + (right - left) / 2;
            if (check(nums, k, mid)) {
                left = mid;
            }else {
                right = mid;
            }
        }
        return left;
    }
}
