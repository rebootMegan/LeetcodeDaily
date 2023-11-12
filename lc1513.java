public class lc1513 {
    //number of substring contains only 1
    /**
     * Given a binary string s, return the number of substrings with all characters 1's. Since the answer may be too large, return it modulo 109 + 7.
     * Example 1:
     *
     * Input: s = "0110111"
     * Output: 9
     * Explanation: There are 9 substring in total with only 1's characters.
     * "1" -> 5 times.
     * "11" -> 3 times.
     * "111" -> 1 time.
     */

    public int numSub(String s) {
        long count = 0 , res = 0 , mod = (int)1e9+7 ;
        for(int i = 0 ; i < s.length() ; i++){
            count+=s.charAt(i)-'0';
            if(s.charAt(i)-'0'==0){
                res+=((count*(count+1))/2);
                count = 0 ;
            }
        }
        res+=((count*(count+1))/2);
        return (int)(res%mod);
    }
}
