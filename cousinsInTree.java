import blind75.TreeNode;

public class cousinsInTree {
    boolean isCousin;
    int recordedDepth = -1;
    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root, 0, x, y);
        return isCousin;
    }
    public boolean dfs(TreeNode node, int depth, int x, int y) {
        if (node == null) return false;
        // Don't go beyond the depth restricted by the first node found.
        if (recordedDepth != -1 && depth > recordedDepth) {
            return false;
        }
        if (node.val == x || node.val == y) {
            // Save depth for the first node found.
            if (recordedDepth == -1) {
                recordedDepth = depth;
            }
            // Return true, if the second node is found at the same depth.
            return recordedDepth == depth;
        }
        boolean left = dfs(node.left, depth + 1, x, y);
        boolean right = dfs(node.right, depth + 1, x, y);
        // this.recordedDepth != depth + 1 would ensure node x and y are not
        // immediate child nodes, otherwise they would become siblings.
        if (left && right && this.recordedDepth != depth + 1) {
            this.isCousin = true;
        }
        return left || right;
    }
}
