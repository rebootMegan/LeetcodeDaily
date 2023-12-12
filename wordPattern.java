import java.util.*;
public class wordPattern {
    /**
     * Given a pattern and a string str, find if str follows the same pattern.
     *
     * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.
     *
     * Examples:
     * pattern = "abba", str = "dog cat cat dog" should return true.
     * pattern = "abba", str = "dog cat cat fish" should return false.
     * pattern = "aaaa", str = "dog cat cat dog" should return false.
     * pattern = "abba", str = "dog dog dog dog" should return false.
     * Notes:
     * You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.
     */

    public boolean wordPattern(String pattern, String str) {
        if (pattern!= null && str != null && pattern.length() == 0 && str.length() == 0) return true;
        if (pattern == null || str == null || pattern.length() == 0 || str.length() == 0) return false;
        String[] strArr = str.split(" ");
        if (pattern.length() != strArr.length) return false;
        HashMap<Character, String> map = new HashMap<>();
        HashMap<String, Character> mapStr = new HashMap<>();
        for (int i = 0; i < strArr.length; i++) {
            if (!map.containsKey(pattern.charAt(i))) {
                map.put(pattern.charAt(i), strArr[i]);
            } else {
                if (!map.get(pattern.charAt(i)).equals(strArr[i])) {
                    return false;
                }
            }
            if (!mapStr.containsKey(strArr[i])) {
                mapStr.put(strArr[i], pattern.charAt(i));
            } else {
                if (!mapStr.get(strArr[i]).equals(pattern.charAt(i))) {
                    return false;
                }
            }
        }
        return true;
    }
}
