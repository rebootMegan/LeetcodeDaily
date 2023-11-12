package lintcode;

import java.util.*;

public class lc1207 {
    //给你一个整数数组 arr，请你帮忙统计数组中每个数的出现次数。
    //
    //如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return map.size() == new HashSet<>(map.values()).size();
    }
}
