import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.function.BinaryOperator;

    public class lc2638 {
        public long countTheNumOfKFreeSubsets(int[] nums, int k) {
            long[] dp = new long[1000];
            dp[0] = 1;
            dp[1] = 2;
            for (int i = 2; i < 1000; i++) {
                dp[i] = 1 + dp[i - 1] + dp[i - 2];
            }

            Arrays.sort(nums);
            List<List<Integer>> chains = new ArrayList<>();
            Map<Integer, List<Integer>> curList = new HashMap<>();

            for (int a : nums) {
                if (curList.containsKey(a - k)) {
                    curList.get(a - k).add(a);
                    curList.put(a, curList.remove(a - k));
                } else {
                    List<Integer> newList = new ArrayList<>();
                    newList.add(a);
                    curList.put(a, newList);
                    chains.add(newList);
                }
            }
            List<Long> res = chains.stream().map(chain -> dp[chain.size() - 1]).collect(Collectors.toList());
            return res.stream().reduce(1L, (x, y) -> x * (y + 1));
        }

        public static void main(String[] args) {
            lc2638 counter = new lc2638();
            int[] nums = {2,3,5,8}; // Example input
            int k = 5; // Example k value
            System.out.println("Number of K-Free Subsets: " + counter.countTheNumOfKFreeSubsets(nums, k));
        }
    }
