package LCR;

import java.util.ArrayList;
import java.util.List;

public class LCR_056 {
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
    List<Integer> list = new ArrayList<>();
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;
        if (list.contains(root.val)) return true;
        else{
            list.add(k - root.val);
        }
        return findTarget(root.left, k) || findTarget(root.right, k);
    }
}
