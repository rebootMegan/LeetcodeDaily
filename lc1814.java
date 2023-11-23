import java.util.HashMap;
import java.util.*;

public class lc1814 {
    /**
     * You are given an array nums that consists of non-negative integers. Let us define rev(x) as the reverse of the non-negative integer x. For example, rev(123) = 321, and rev(120) = 21. A pair of indices (i, j) is nice if it satisfies all of the following conditions:
     *
     * 0 <= i < j < nums.length
     * nums[i] + rev(nums[j]) == nums[j] + rev(nums[i])
     * Return the number of nice pairs of indices. Since that number can be too large, return it modulo 109 + 7.
     */
    public int  countNicePairs(int[] nums) {
        //nums[i] + rev(nums[j]) == nums[j] + rev(nums[i])
        //x = nums[i] and y = nums[j] and rewrite the formula:
        //x + rev(y) == y + rev(x)  => x - rev(x) == y - rev(y)
        int[] arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = nums[i] - rev(nums[i]);
        }
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        int mod = (int) 1e9 + 7;
        for (int num : arr) {
            ans = (ans + map.getOrDefault(num, 0)) % mod;
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return ans;
    }
    public int rev(int num ) {
        int result = 0;
        while (num > 0) {
            result = result * 10 + num % 10;
            num /= 10;
        }
        return result;
    }
}
