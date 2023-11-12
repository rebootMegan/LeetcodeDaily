package slidingwindow;

import java.awt.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

public class lc76 {
    /**
     * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
     * @param s
     * @param t
     * @return
     */
    Map<Character,Integer> ori = new HashMap<>();
    Map<Character, Integer> cnt = new HashMap<>();
    public String minWindow(String s, String t) {

        int tlen = t.length();
        for (int i =0; i < tlen; i++) {
            char c = t.charAt(i);
            ori.put(c, ori.getOrDefault(c, 0)+ 1);
        }
        int l = 0, r = -1;
        int len = Integer.MAX_VALUE, ansl = -1, ansr = -1;
        int slen = s.length();
        while (r < slen) {
            r++;
            if (r < slen && ori.containsKey(s.charAt(r))) {
                cnt.put(s.charAt(r), cnt.getOrDefault(s.charAt(r), 0) + 1)
;            }
            while (check() && l <= r) {
                if (r - l + 1 < len) {
                    len = r - l + 1;
                    ansl = l;
                    ansr = r + len;
                }
                if (ori.containsKey(s.charAt(l))) {
                    cnt.put(s.charAt(l), cnt.getOrDefault(s.charAt(l) , 0) - 1);
                }
                ++l;
            }
        }
        return ansl == -1 ? "" : s.substring(ansl, ansr);
    }
    private boolean check() {
        Iterator iter = ori.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            Character key = (Character) entry.getKey();
            Integer val = (Integer) entry.getValue();
            if (cnt.getOrDefault(key, 0) < val) {
                return false;
            }
        }
        return true;
    }
}
