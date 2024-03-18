package LCR;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LCR_044 {
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
    public List<Integer> largestValues(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> max = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        int maxx = Integer.MIN_VALUE;
        int cur_rest = 1, next_rest = 0;
        queue.add(root);
        while (!queue.isEmpty()){
            if (cur_rest != 0){
                TreeNode pop = queue.poll();
                maxx = Math.max(maxx, pop.val);
                cur_rest--;
                if (pop.left != null) {
                    queue.add(pop.left);
                    next_rest++;
                }
                if (pop.right != null){
                    queue.add(pop.right);
                    next_rest++;
                }
            } else {
                cur_rest = next_rest;
                next_rest = 0;
                max.add(maxx);
                maxx = Integer.MIN_VALUE;
            }
        }
        max.add(maxx);
        return max;
    }
}
