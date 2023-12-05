import java.util.TreeMap;

public class lc975 {
    public int oddEvenJumps(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][2];
        // dp[i][0] represents the number of good jumps starting from i with odd number of jumps
        // dp[i][1] represents the number of good jumps starting from i with even number of jumps
        // dp[i][0] = dp[j][1] if arr[i] <= arr[j] for some j > i
        // dp[i][1] = dp[j][0] if arr[i] >= arr[j] for some j > i
        // dp[i][0] = dp[j][0] if arr[i] == arr[j] for some j > i
        // dp[i][1] = dp[j][1] if arr[i] == arr[j] for some j > i
        // dp[n - 1][0] = dp[n - 1][1] = 1
        int res = 1;
        boolean[] higher = new boolean[n], lower = new boolean[n];
        higher[n - 1] = lower[n - 1] = true;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(arr[n - 1], n - 1);
        for (int i = n -2; i >= 0; i--) {
            Integer hi = map.ceilingKey(arr[i]), lo = map.floorKey(arr[i]);
            if (hi != null) {
                higher[i] = lower[map.get(hi)];
            }
            if (lo != null) {
                lower[i] = higher[map.get(lo)];
            }
            if (higher[i]) {
                res++;
            }
            map.put(arr[i], i);
        }
        return res;
    }
}
