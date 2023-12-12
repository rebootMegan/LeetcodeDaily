import blind75.TreeNode;
import java.util.*;


public class lc863 {
    Map<TreeNode, Integer> map = new HashMap<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> res = new ArrayList<>();
         find(root, target);
         search(root, 0, k, res);
         return res;
    }
    public void find(TreeNode root, TreeNode target) {
        if (root == null) return;
        if (root == target) {
            map.put(root,0);
            return;
        }
        find(root.left, target);
        if (map.containsKey(root.left)) {
            map.put(root, map.get(root.left) + 1);
            return;
        }
        find(root.right, target);
        if (map.containsKey(root.right)) {
            map.put(root, map.get(root.right) + 1);
            return;
        }
        return;
    }
    public void search(TreeNode root, int distance, int k, List<Integer> res) {
        if (root == null) return;
        if (map.containsKey(root)) {
            distance = map.get(root);
        }
        if (distance == k) {
            res.add(root.val);
        }
        search(root.left, distance + 1, k, res);
        search(root.right, distance + 1, k, res);
    }
}
