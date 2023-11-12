import java.util.HashMap;

public class lc2537 {
    public long countGood(int[] nums, int k) {
        long ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int j = 0;
        long countPairs = 0;

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {

                int val = map.get(nums[i]);
                //to replace the  the previous pair with new pairs
                countPairs -= ((long) val * (val - 1) / 2);
                map.put(nums[i], map.get(nums[i]) + 1);
                val = map.get(nums[i]);
                countPairs += ((long) val * (val - 1) / 2);

            } else {
                map.put(nums[i], 1);
            }

            // System.out.println(countPairs);
            //sliding the window to right
            while (j <= i && countPairs >= k) {
                int cur = map.get(nums[j]);
                countPairs -= (long) cur * (cur - 1) / 2;
                map.put(nums[j], cur - 1);
                cur = map.get(nums[j]);
                countPairs += (long) (cur) * (cur - 1) / 2;
                j++;
                ans += (nums.length - i);
            }

        }
        return ans;

    }
}