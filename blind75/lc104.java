package blind75;

public class lc104 {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        else {
            int left_height = maxDepth(root.left);
            int right_height = maxDepth(root.right);
            return Math.max(left_height, right_height) + 1;
        }
    }
}
