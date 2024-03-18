package LCR;

public class LCR_053 {
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
    public TreeNode pre;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (p.right != null) {
            TreeNode node = p.right;
            while (node!=null){
                pre =node;
                node = node.left;
            }
            return pre;
        }
        TreeNode ptr = root;
        pre = new TreeNode(Integer.MAX_VALUE);
        while (ptr != null){
            if (ptr.val > p.val){
                if (ptr.val < pre.val)
                    pre = ptr;
                ptr = ptr.left;
            } else {
                ptr = ptr.right;
            }
        }
        return pre.val == Integer.MAX_VALUE? null:pre;
    }
}
