package indexingSort;

public class lc268 {
    public int missingNumber(int[] nums) {
        int[] arr = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            arr[nums[i]]++;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) return i;
        }
        return -1;
    }
    public static int missingNumberXor(int[] nums) {
//        a XOR a = 0
//        a XOR b XOR a = b
//        0 XOR a = a
        int xor = 0;
        int i;
        //XOR all the array elements
        for (i = 0; i < nums.length; i++) {
            xor= xor ^ nums[i];
        }
        //XOR the result with the length of the array
        for (i = 0; i <= nums.length; i++) {
            xor = xor ^ i;
        }
        return xor;
    }
//By XORing all the numbers in the array and the numbers from 0 to n, the missing number will be the result since every number except the missing one will be XORed twice and thus cancel out.
    public static void main(String[] args) {
        int[] nums = {9,6,4,2,3,5,7,0,1};
        int res = missingNumberXor(nums);
        System.out.println(res);
    }
}
