
public class lc280 {
    //wiggle sort
    //nums[0] <= nums[1] >= nums[2] <= nums[3]....
    public void wiggleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if(((i % 2 == 0) && nums[i] > nums[i + 1]) || ((i % 2 == 1) && nums[i] < nums[i + 1])) {
                swap(nums, i, i + 1);
            }
        }
    }

    private void swap(int[] nums, int i, int i1) {
        int k =nums[i];
        nums[i] = nums[i1];
        nums[i1] = k;
    }
}
