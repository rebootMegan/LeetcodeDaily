import java.util.*;

public class lc1675 {
    /**
     * You can perform two types of operations on any element of the array any number of times:
     *
     * If the element is even, divide it by 2.
     * For example, if the array is [1,2,3,4], then you can do this operation on the last element, and the array will be [1,2,3,2].
     * If the element is odd, multiply it by 2.
     * For example, if the array is [1,2,3,4], then you can do this operation on the first element, and the array will be [2,2,3,4].
     * The deviation of the array is the maximum difference between any two elements in the array
     * Return the minimum deviation the array can have after performing some number of operations.
     *
     * Example 1:
     * Input: nums = [1,2,3,4]
     * Output: 1
     * Explanation: You can transform the array to [1,2,3,2], then to [2,2,3,2], then the deviation will be 3 - 2 = 1.
     * @param nums
     * @return
     */
    public int minimumDeviation(int[] nums) {
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        List<List<Integer>> list =new ArrayList<>();
        for (int i = 0;i < n; i++) {
            List<Integer> candidates = new ArrayList<>();
            if (nums[i] % 2 == 0) {
                int temp = nums[i];
                candidates.add(temp);
                while (temp % 2 == 0) {
                    temp /= 2;
                    candidates.add(temp);
                }
            }else {
                candidates.add(nums[i] * 2);
                candidates.add(nums[i]);
            }
            //reverse candidates to sort from small to large
            Collections.reverse(candidates);
            list.add(candidates);
        }
        List<int[]> pointers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            pointers.add(new int[] {list.get(i).get(0), i, 0});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p[0]));
        pq.addAll(pointers);

        int currentEnd = 0;
        for (int i =0; i < n; i++) {
            currentEnd = Math.max(currentEnd, list.get(i).get(0));
        }
        //get minimum from pq
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currentStart = current[0];
            int index = current[1];
            int indexInCandidates = current[2];
            if (min > currentEnd - currentStart)  {
                min = currentEnd - currentStart;
            }
            //if the pointer reach last
            if (indexInCandidates == list.get(index).size() - 1) {
                return min;
            }
            int next = list.get(index).get(indexInCandidates + 1);
            currentEnd = Math.max(currentEnd, next);
            pq.offer(new int[] {next, index, indexInCandidates + 1});
        }
        return min;
    }
}
