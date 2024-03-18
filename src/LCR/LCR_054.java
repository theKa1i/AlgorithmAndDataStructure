package LCR;

public class LCR_054 {
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
    public TreeNode convertBST(TreeNode root) {
        if (root == null) return null;
        dfs(root);
        return root;
    }
    int pre = 0;
    public int dfs(TreeNode root){
        if (root == null) return 0;
        dfs(root.right);
        pre = root.val + pre;
        root.val = pre;
        dfs(root.left);
        return pre;
    }
}
