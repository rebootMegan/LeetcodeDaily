package google;

public class lc1562 {
    /**Return the latest step at which there exists a group of ones of length exactly m. If no such group exists, return -1.
     * Input: arr = [3,5,1,2,4], m = 1
     * Output: 4
     * Explanation:
     * Step 1: "00100", groups: ["1"]
     * Step 2: "00101", groups: ["1", "1"]
     * Step 3: "10101", groups: ["1", "1", "1"]
     * Step 4: "11101", groups: ["111", "1"]
     * Step 5: "11111", groups: ["11111"]
     * The latest step at which there exists a group of size 1 is step 4.
     * @param arr
     * @param m
     * @return
     */
    public int findLatestStep(int[] arr, int m) {
         //Initialize an array groups of size n + 2 to keep track of the boundaries of the groups.
        // groups[i] will store the size of the group that i is a part of. The extra two elements handle edge cases (start and end of the array).
        //Initialize a counter array count of size n + 1 to keep track of the number of groups of each size.
        // count[i] represents how many groups of size i are there.
        //Iterate over the elements of arr. For each element arr[i], we need to update the group sizes in groups and the counts in count.
        //After each update, check if there is a group of size m. If yes, store the current step i.
        //After iterating through all elements of arr, return the stored step or -1 if no such step exists.
        int n = arr.length;
        if (m > n) return -1;
        if (m == n) return n;
        int[] groups = new int[n + 2];
        int[] count = new int[n + 1];
        int latestStep = -1;
        for (int i = 0; i < n; i++) {
            int index = arr[i];
            int left = groups[index - 1];
            int right = groups[index + 1];
            int groupSize = left + right + 1;
            groups[index - left] =groupSize;
            groups[index + right]= groupSize;
            count[left]--;
            count[right]--;
            count[groupSize]++;
            if (count[m] > 0) {
                latestStep = i + 1;
            }
        }
        return latestStep;

    }
}
