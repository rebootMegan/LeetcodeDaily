package blind75;

public class lc53 {
    public int maxSubarray(int[] nums){
        int n = nums.length, maxsum =nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i - 1] > 0) {
                nums[i] += nums[i - 1];
            }
            maxsum = Math.max(nums[i], maxsum);
        }
        return maxsum;
    }
}
