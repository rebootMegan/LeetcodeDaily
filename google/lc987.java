package google;

import blind75.TreeNode;
import javafx.util.Pair;

import java.util.*;
public class lc987 {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(root, 0));
        int min = 0, max = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            Map<Integer, List<Integer>> temp = new HashMap<>();
            for (int i = 0; i < size; i++) {
                Pair<TreeNode, Integer> p = queue.poll();
                TreeNode node = p.getKey();
                int col = p.getValue();
                min = Math.min(min, col);
                max = Math.max(max, col);
                if (!temp.containsKey(col)) {
                    temp.put(col, new ArrayList<>());
                }
                temp.get(col).add(node.val);
                if (node.left != null) {
                    queue.offer(new Pair<>(node.left, col - 1));
                }
                if (node.right != null) {
                    queue.offer(new Pair<>(node.right, col + 1));
                }
            }
            for (int key : temp.keySet()) {
                List<Integer> list = temp.get(key);
                Collections.sort(list);
                if (!map.containsKey(key)) {
                    map.put(key, new ArrayList<>());
                }
                map.get(key).addAll(list);
            }
        }
        for (int i = min; i <= max; i++) {
            ans.add(map.get(i));
        }
        return ans;
    }
}
