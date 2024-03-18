package LCR;

public class LCR_047 {
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
    public static TreeNode pruneTree(TreeNode root) {
        if (formZeroSubTree(root)) return null;
        clip(root);
        return root;
    }
    public static boolean formZeroSubTree(TreeNode root){
        if (root == null) return true;
        boolean left = formZeroSubTree(root.left);
        boolean right = formZeroSubTree(root.right);
        boolean b = root.val == 0 && left && right;
        if (b) root.val = 2;
        return b;
    }

    public static void clip(TreeNode root){
        if (root.left != null){
            if (root.left.val == 2) root.left = null;
            else clip(root.left);
        }
        if (root.right != null){
            if (root.right.val == 2) root.right = null;
            else clip(root.right);
        }
    }
}
