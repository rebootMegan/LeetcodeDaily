public class lc2918 {

    public long minEqualSum(int[] nums1, int[] nums2) {
        long sum1 = 0, sum2 = 0; // Use long for potentially large sums
        int count1 = 0, count2 = 0; // Count zeros in both arrays

        // Calculate sum for nums1 and count zeros
        for (int x : nums1) {
            sum1 += x;
            if (x == 0) {
                count1++;
            }
        }

        // Calculate sum for nums2 and count zeros
        for (int x : nums2) {
            sum2 += x;
            if (x == 0) {
                count2++;
            }
        }

        // If nums1 has no zeros and its sum cannot be raised above sum2, return -1
        if (count1 == 0 && sum2 + count2 > sum1) {
            return -1;
        }
        // If nums2 has no zeros and its sum cannot be raised above sum1, return -1
        if (count2 == 0 && sum1 + count1 > sum2) {
            return -1;
        }

        // The minimum equal sum we can obtain is the maximum of the two sums plus their zeros
        return Math.max(sum1 + count1, sum2 + count2);
    }
}
