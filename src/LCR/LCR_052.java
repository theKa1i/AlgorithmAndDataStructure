package LCR;

public class LCR_052 {
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
    public TreeNode pre, head;
    public TreeNode increasingBST(TreeNode root) {
        inOrder(root);
        pre.left = null;
        pre.right = null;
        return head;
    }

    public void inOrder(TreeNode root){
        if (root == null) return;
        inOrder(root.left);
        if (head == null) head = root;
        if (pre != null) {
            pre.right = root;
            pre.left = null;
        }
        pre = root;
        inOrder(root.right);
    }
}
