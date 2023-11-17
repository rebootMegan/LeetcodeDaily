package blind75;

public class lc230 {
    int res = 0;
    int rank = 0;
    public int kthSmallest(TreeNode root, int k) {
        traverse(root, k);
        return res;
    }
    public void traverse(TreeNode root, int k) {
        if (root == null) return;
        traverse(root.left, k);
        rank++;
        if (k == rank) {
            res= root.val;
            return;
        }
        traverse(root.right, k);
    }
}
