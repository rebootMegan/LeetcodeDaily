import java.util.Arrays;

public class lc2270 {
    //https://leetcode.com/problems/number-of-ways-to-split-array/


    public int waysToSplit(int[] nums) {

        int n = nums.length;
        int[] prefixSum = new int[n];

        // Calculate prefix sum array
        prefixSum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }

        // Use Arrays.stream for simplicity
        return (int) Arrays.stream(prefixSum, 0, n - 1)
                .filter(leftSum -> leftSum >= prefixSum[n - 1] - leftSum)
                .count();
    }
    //public class Solution {
    //    public int numberOfWaysToSplitArray(int[] nums) {
    //        long totalSum = 0;
    //        for (int num : nums) {
    //            totalSum += num;
    //        }
    //
    //        long leftSum = 0;
    //        int count = 0;
    //        for (int i = 0; i < nums.length - 1; i++) {
    //            leftSum += nums[i];
    //            if (leftSum >= totalSum - leftSum) {
    //                count++;
    //            }
    //        }
    //        return count;
    //    }
    //}
}

