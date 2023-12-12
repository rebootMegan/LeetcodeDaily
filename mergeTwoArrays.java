import java.util.ArrayList;
import java.util.*;

public class mergeTwoArrays {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        List<int[]> resultList = new ArrayList<>();
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i][0] == nums2[j][0]) {
                // If ids are equal, sum their values
                resultList.add(new int[]{nums1[i][0], nums1[i][1] + nums2[j][1]});
                i++;
                j++;
            }else if (nums1[i][0] < nums2[j][0]) {
                resultList.add(nums1[i]);
                i++;
            }else {
                resultList.add(nums2[j]);
                j++;
            }
        }
        // Add remaining elements from nums1 and nums2
        while (i < nums1.length) {
            resultList.add(nums1[i]);
            i++;
        }
        while (j < nums2.length) {
            resultList.add(nums2[j]);
            j++;
        }
        return resultList.toArray(new int[resultList.size()][]);
    }
}
