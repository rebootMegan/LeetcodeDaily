import java.util.*;

public class mapstringChar {
    public boolean wordPattern(String pattern, String s) {
        //dog constructor constructor dog
        String[] stringArray = s.split(" ");
        Map<Character, String> map = new HashMap<>();
        if (pattern.length() != stringArray.length) {
            return false;
        }
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if (!map.containsKey(c)) {
                if (map.containsValue(stringArray[i])) {
                    return false;
                }
                map.put(c, stringArray[i]);
            }else {
                if (!map.get(c).equals(stringArray[i])) {
                    return false;
                }
            }
        }
        return true;
    }
}
