package blind75;

import java.util.*;

public class lc347 {
    public int[] c(int[] nums, int k) {
        if (nums.length == k) {
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

//O(NlgK)
//Space complexity : O(N+k) to store the hash map with not more N elements and a heap with K elements

    class Solution {
        int[] unique;
        Map<Integer, Integer> count;

        public int[] topKFrequent(int[] nums, int k) {
            //build hash map
            count = new HashMap<>();
            for (int num : nums) {
                count.put(num, count.getOrDefault(num , 0) + 1);
            }
            //array of unique elements
            int n = count.size();
            unique = new int[n];
            int i = 0;
            for (int num : count.keySet()) {
                unique[i] = num;
                i++;
            }
            quickselect(0, n - 1, n- k);
            return Arrays.copyOfRange(unique, n - k, n);
        }

        private int partition(int left, int right, int pivot_index) {
            int pivot_frequency = count.get(unique[pivot_index]);
            swap(pivot_index, right);
            int store_index = left;

            for (int i = left; i <= right; i++) {
                if (count.get(unique[i]) < pivot_frequency) {
                    swap(store_index, i);
                    store_index++;
                }
            }
            swap(store_index, right);
            return store_index;
        }

        private void swap(int a, int b) {
            int tmp = unique[a];
            unique[a] = unique[b];
            unique[b] = tmp;
        }

        private void quickselect(int left, int right, int k_smallest) {
            //sort a list with left...right till kth less frequent element takes its place
            if (left == right) return;
            //select a random pivot_index
            Random random_num = new Random();
            int pivot_index = left + random_num.nextInt(right - left);
            //find the pivot position in a sorted list
            pivot_index = partition(left, right, pivot_index);
            //if the pivot is in its final sorted position
            if (k_smallest == pivot_index) {
                return;
            } else if (k_smallest < pivot_index) {
                //go left
                quickselect(left, pivot_index - 1, k_smallest);
            }else {
                quickselect(pivot_index + 1, right, k_smallest);
            }
        }
    }
}