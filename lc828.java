import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class lc828 {
    public int uniqueLetterString(String s) {
        //输入: s = "ABC"
        //输出: 10
        //解释: 所有可能的子串为："A","B","C","AB","BC" 和 "ABC"。
        //     其中，每一个子串都由独特字符构成。
        //     所以其长度总和为：1 + 1 + 1 + 2 + 2 + 3 = 10

        Map<Character, List<Integer>> index = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!index.containsKey(c)) {
                index.put(c, new ArrayList<>());
                index.get(c).add(-1);
            }
            index.get(c).add(i);
        }
        int res =0;
        for (Map.Entry<Character, List<Integer>> entry : index.entrySet()) {
            List<Integer> arr = entry.getValue();
            arr.add(s.length());
            for (int i= 1; i < arr.size() - 1; i++) {
                res += (arr.get(i) - arr.get(i - 1)) * (arr.get(i + 1) - arr.get(i));
            }
        }
        return res;
    }
}
