import java.util.Arrays;

public class lc2090 {
    //The k-radius average for a subarray of nums centered at some index i with the radius k is the average of all elements in nums between the indices i - k and i + k (inclusive). If there are less than k elements before or after the index i, then the k-radius average is -1.
    //
    //Build and return an array avgs of length n where avgs[i] is the k-radius average for the subarray centered at index i.
    //
    //The average of x elements is the sum of the x elements divided by x, using integer division. The integer division truncates toward zero, which means losing its fractional part.
    //
    //For example, the average of four elements 2, 3, 1, and 5 is (2 + 3 + 1 + 5) / 4 = 11 / 4 = 2.75, which truncates to 2.

    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n];
        if (n <=k * 2){
            Arrays.fill(res, -1);
            return res;
        }
        Arrays.fill(res, -1);
        long sum = 0;
        int left = 0, right = 0, windowSize = 2 * k + 1;
        while (right < n) {
            sum += nums[right];
            if (right - left + 1 == windowSize) {
                res[left + k] = (int) (sum / windowSize);
                sum -= nums[left];
                left++;
            }
            right++;
        }
        return res;
    }
}
