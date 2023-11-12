package slidingwindow;

import java.util.HashMap;

public class lc159 {

    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        int n = s.length();
        if (n < 3) return n;
        int res = 0;
        int[] freq = new int[256];
        int l = 0, r = 0;
        int currDistinct = 0;
        while (r < s.length()) {
            if(++freq[s.charAt(r++)] == 1) currDistinct++;
            while (currDistinct > 2) {
                if (--freq[s.charAt(l++)] == 0) currDistinct--;
            }
            res = Math.max(res, r- l);
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "ccaabbb";
        int res = lengthOfLongestSubstringTwoDistinct(s);
        System.out.println(res);
    }
}
