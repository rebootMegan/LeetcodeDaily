package slidingwindow;

public class lc727 {
    /**
     * Given strings s1 and s2, return the minimum contiguous substring part of s1, so that s2 is a subsequence of the part.
     *
     * If there is no such window in s1 that covers all characters in s2, return the empty string "". If there are multiple such minimum-length windows, return the one with the left-most starting index.
     * @param s1
     * @param s2
     * @return
     */
    public String minWindow(String S, String T) {
        /**
         *  we can traverse from left to right, find a possible candidate until reach the first ending character of T
         * eg: for the string s = abcdebdde and t = bde, we should traverse s string until we find first e,
         * i.e. abcde, then traverse back from current "e" to find if we have other combination of bde with smaller
         * @param right: fast pointer that always points the last character of T in S
         * @param left: slow pointer that used to traverse back when right pointer find the last character of T in S
         * @param tIndex: third pointer used to scan string T
         * @param minLen: current minimum length of subsequence
         */
        if (S.length() == 0 || T.length() == 0) {
            return "";
        }
        int right = 0;
        int minLen = Integer.MAX_VALUE;
        String result = "";
        while(right < S.length()) {
            int tIndex = 0;
            while (right < S.length()) {
                if (S.charAt(right) == T.charAt(tIndex)) {
                    tIndex++;
                }
                if (tIndex == T.length()) {
                    break;
                }
                right++;
            }
            //if right pointer is over the boundary
            if (right == S.length()) break;
            //use another slow pointer to traverse from right to left
            int left = right;
            tIndex = T.length()- 1;
            while (left >=0 ) {
                if (S.charAt(left) == T.charAt(tIndex)) {
                    tIndex--;
                }
                if (tIndex < 0) break;
                left--;
            }
            if (right - left +1 < minLen) {
                minLen = right - left + 1;
                result = S.substring(left, right + 1);
            }
            right = left + 1;
        }
        return result;
    }
}
