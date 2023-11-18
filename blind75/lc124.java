package blind75;

public class lc124 {
    int res = Integer.MAX_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return res;
    }
    public int helper(TreeNode root) {
        if (root == null) return 0;
        int left = Math.max(helper(root.left), 0);
        int right = Math.max(helper(root.right), 0);
        int new_path = root.val + left + right;
        res = Math.max(res, new_path);
        return Math.max(left, right) + root.val;
    }
}
