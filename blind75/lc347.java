package blind75;

import java.util.*;

public class lc347 {
    public int[] topKFrequent(int[] nums, int k) {
        if (nums.length == k){
            return nums;
        }
        Map<Integer, Integer> count = new HashMap<>();
        for (int n : nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }
        Queue<Integer> q = new PriorityQueue<>(Comparator.comparingInt(count::get));
        for (int n : count.keySet()) {
            q.add(n);
            if (q.size() > k) {
                q.poll();
            }
        }
        int[] top = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            top[i] = q.poll();
        }
        return top;
    }
}
//O(NlgK)
//Space complexity : O(N+k) to store the hash map with not more N elements and a heap with K elements
