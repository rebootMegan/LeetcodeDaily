import java.util.Arrays;
import java.util.HashMap;

public class lc2501 {
    public int longestSquareStreak(int[] nums) {
        HashMap<Integer, Integer> dp = new HashMap<>();
        int res= 0;
        Arrays.sort(nums);
        for (int a : nums) {
            int root = (int) Math.sqrt(a);
            if (root * root == a) {
                dp.put(a, dp.getOrDefault(root, 0) + 1);
            } else {
                dp.put(a, 1);
            }
            res = Math.max(res, dp.get(a));
        }
        return res < 2 ? -1 : res;
    }
}
