package LCR;

public class LCR_051 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return res;
    }

    public int dfs(TreeNode root){
        if (root == null) return 0;

        int left_max = dfs(root.left);
        int right_max = dfs(root.right);
        res = Math.max(res, left_max + right_max + root.val);
        return Math.max(Math.max(left_max, right_max) + root.val, 0);
    }
}
