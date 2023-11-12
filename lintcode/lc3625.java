package lintcode;

import java.util.*;

public class lc3625 {
    //给出字符串 text 和字符串列表 words，
    // 返回所有的索引对 [i, j] 使得在索引对范围内的子字符串 text[i]…text[j]（包括 i 和 j）属于字符串列表 words。
    //e.g. test = "thestoryofleetcodeandme" , words =["story","fleet","leetcode"]
    //output : [[3,7],[9,13],[10,17]]
    //考察字典树
    public int[][] indexPairs(String text, String[] words) {
        Node root = new Node();
        Set<String> set = new HashSet<>();
        for (String word : words) {
            add(root, word);
            set.add(word);
        }
        char[] arr = text.toCharArray();
        int n =arr.length;
        List<int[]> ll = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                String sub = text.substring(i, j);
                if (search(root, sub)) {
                    ll.add(new int[] {i, j - 1});
                }
            }
        }
        int[][] ans = new int[ll.size()][2];
        for(int i = 0; i < ll.size(); i++) {
            ans[i] = ll.get(i);
        }
        return ans;
    }

    private boolean search(Node root, String word) {
        Node cur = root;
        char[] arr = word.toCharArray();
        for (char c :arr) {
            if (!cur.nexts.containsKey(c)) return false;
            cur = cur.nexts.get(c);
        }
        return cur.end > 0;
    }

    private void add(Node root, String word) {
        Node cur = root;
        cur.pass++;
        char[] arr = word.toCharArray();
        for (char c : arr) {
            if (!cur.nexts.containsKey(c)) {
                cur.nexts.put(c, new Node());
            }
            cur = cur.nexts.get(c);
            cur.pass++;
        }
        cur.end++;
    }

    static class Node {
        int pass = 0;
        int end = 0;
        Map<Character, Node> nexts = new HashMap<>();
    }
}
