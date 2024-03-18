package LCR;

public class LCR_049 {
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
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    public int dfs(TreeNode root, int curNum){
        if (root.left == null && root.right == null) return curNum + root.val;
        int res = 0;
        if (root.left != null) res += dfs(root.left, (curNum + root.val)*10);
        if (root.right != null) res += dfs(root.right, (curNum + root.val)*10);
        return res;
    }
}
