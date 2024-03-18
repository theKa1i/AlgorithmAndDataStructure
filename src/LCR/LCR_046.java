package LCR;

import java.util.ArrayList;
import java.util.List;

public class LCR_046 {
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
    public List<Integer> list = new ArrayList<>();
    public int max_height = 0;
    public List<Integer> rightSideView(TreeNode root) {
        dfs(root, 1);
        return list;
    }

    public void dfs(TreeNode root, int cur_height){
        if (root == null) return;
        if (cur_height > max_height){
            max_height = cur_height;
            list.add(root.val);
        }
        dfs(root.right, cur_height + 1);
        dfs(root.left, cur_height + 1);
    }
}
