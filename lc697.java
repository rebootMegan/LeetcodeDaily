import java.util.*;

public class lc697 {
    public int findShortestSubarray(int[] nums) {
        Map<Integer, int[]> countMap = new HashMap<>();
        int maxDegree = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (!countMap.containsKey(nums[i])) {
                countMap.put(nums[i], new int[] {1, i, i});
            }
            else {
                int[] countData = countMap.get(nums[i]);
                countData[0]++;
                countData[2] = i;
            }
            maxDegree = Math.max(maxDegree, countMap.get(nums[i])[0]);
        }
        int minLength = Integer.MAX_VALUE;
        for (Map.Entry<Integer,int[]> entry : countMap.entrySet()) {
            int[] countData = entry.getValue();
            if (countData[0] == maxDegree) {
                minLength = Math.min(minLength, countData[2] - countData[1]+ 1);
            }
        }
        return minLength;
    }

    public static void main(String[] args) {
        lc697 solution = new lc697();
        int[] nums = {1, 2, 2, 3, 1};
        System.out.println("The length of the smallest subarray is: " +solution.findShortestSubarray(nums));
    }
}
