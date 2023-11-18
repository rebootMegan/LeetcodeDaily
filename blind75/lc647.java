package blind75;

public class lc647 {
    //palindrom substrings Given a string s, return the number of palindromic substrings in it.
    public int countSubstrings(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++){
            ans += helper(s, i, i);
            ans += helper(s, i, i + 1);
        }
        return ans;
    }
    public int helper(String ss, int lo, int hi) {
        int ans = 0;
        while (lo >= 0 && hi < ss.length()) {
            if (ss.charAt(lo) != ss.charAt(hi)) {
                break;
            }
            lo--;
            hi++;
            ans++;
        }
        return ans;
    }
}
