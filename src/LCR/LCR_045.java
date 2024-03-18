package LCR;

public class LCR_045 {
    public static class TreeNode {
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
    public int max_height = 0;
    public int value = 0;
    public int findBottomLeftValue(TreeNode root) {
        dfs(root, 1);
        return value;
    }

    public void dfs(TreeNode root, int cur_height){
        if (root == null) return;
        if (cur_height > max_height){
            max_height = cur_height;
            value = root.val;
        }
        dfs(root.left, cur_height + 1);
        dfs(root.right, cur_height + 1);
    }

}
