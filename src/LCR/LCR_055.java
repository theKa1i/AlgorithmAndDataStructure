package LCR;

public class LCR_055 {
}
class BSTIterator {
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
    public BSTIterator(TreeNode root) {
        dfs(root);
    }

    public int next() {
        int x = head.val;
        head = head.right;
        return x;
    }

    public boolean hasNext() {
        return head != null;
    }
    TreeNode pre, head;
    public void dfs(TreeNode root){
        if (root == null) return;
        dfs(root.left);
        if (head == null) pre = head = root;
        else {
            pre.right = root;
            root.left = null;
            pre = root;
        }
        dfs(root.right);
    }
}