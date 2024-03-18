package LCR;

public class LCR_050 {
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
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        return dfs(root, 0, targetSum) + pathSum(root.left, targetSum) + pathSum(root.right, targetSum);
    }

    public int dfs(TreeNode root, long curSum, int targetSum){
        if (root == null) return 0;
        int res = 0;
        curSum += root.val;
        if (curSum == targetSum) res++;
        res += dfs(root.left, curSum, targetSum) + dfs(root.right, curSum, targetSum);
        return res;
    }
}
