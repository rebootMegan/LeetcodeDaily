import java.util.HashMap;
import java.util.Map;

public class lc532 {
    /**
     * Given an array of integers nums and an integer k, return the number of unique k-diff pairs in the array.
     * A k-diff pair is an integer pair (nums[i], nums[j]), where the following are true:
     * 0 <= i, j < nums.length
     * i != j
     * |nums[i] - nums[j]| == k
     * @param nums
     * @param k
     * @return
     */
    public int findPairs(int[] nums, int k) {
        int result = 0;
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int n : nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : count.entrySet() ) {
            int x =entry.getKey();
            int val = entry.getValue();
            if (k > 0 && count.containsKey(x + k)) {
                result++;
            }else if (k == 0 && val > 1) {
                result++;
            }
        }
        return result;
    }
}
