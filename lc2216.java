public class lc2216 {
    /**
     * You are given a 0-indexed integer array nums. The array nums is beautiful if:
     * <p>
     * nums.length is even.
     * nums[i] != nums[i + 1] for all i % 2 == 0.
     * Note that an empty array is considered beautiful.
     * <p>
     * You can delete any number of elements from nums. When you delete an element,
     * all the elements to the right of the deleted element will be shifted one unit to the left to fill the gap created and all the elements to the left of the deleted element will remain unchanged.
     * <p>
     * Return the minimum number of elements to delete from nums to make it beautiful.
     */
    public int minDeletion(int[] nums) {
        int ans = 0, n = nums.length;
        for (int i =0; i < nums.length - 1; i++) {
            //i - ans := the index after deletion
            if (nums[i] == nums[i + 1] && (i - ans) % 2 == 0) {
                ans++;
            }
        }
        return ans + (((n - ans) & 1) == 1 ? 1 : 0);
    }
}
