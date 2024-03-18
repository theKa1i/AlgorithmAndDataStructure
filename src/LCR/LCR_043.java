package LCR;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LCR_043 {
}




class CBTInserter {
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
    public ArrayList<TreeNode> tree = new ArrayList<>();
    public CBTInserter(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode e = queue.poll();
            tree.add(e);
            if (e.left != null) queue.add(e.left);
            if (e.right != null) queue.add(e.right);
        }
    }
    public int insert(int v) {
        int index = tree.size();
        int parent = (index - 1) / 2;
        TreeNode e = new TreeNode(v);
        tree.add(e);
        TreeNode p = tree.get(parent);
        if (index == parent * 2 + 1) p.left = e;
        else p.right = e;
        return p.val;
    }

    public TreeNode get_root() {
        return tree.getFirst();
    }
}