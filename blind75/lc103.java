package blind75;

import java.util.*;
import java.util.Queue;

public class lc103 {
    //binary tree zigzag level order traversal
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null){
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean leftToRight = true;
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                if (leftToRight){
                    list.add(node.val);
                }else {
                    list.add(0, node.val);
                }
                if (node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }

            }
            ans.add(list);
            leftToRight = !leftToRight;
        }
        return ans;
    }
}
