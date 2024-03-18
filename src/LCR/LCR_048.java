package LCR;

import java.util.LinkedList;
import java.util.Queue;

public class LCR_048 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }
    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuffer sb = new StringBuffer();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode cur = queue.poll();
            if (cur == null) {
                sb.append("null").append("#");
            } else {
                sb.append(cur.val).append("#");
                queue.add(cur.left);
                queue.add(cur.right);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<TreeNode> queue = new LinkedList<>();
        String[] datas = data.split("#");
        if (datas[0].equals("null")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(datas[0]));
        queue.add(root);
        int index = 1;
        while (!queue.isEmpty()){
            TreeNode cur = queue.poll();
            if (!datas[index].equals("null")){
                cur.left = new TreeNode(Integer.parseInt(datas[index]));
                queue.add(cur.left);
            }
            index++;
            if (!datas[index].equals("null")){
                cur.right = new TreeNode(Integer.parseInt(datas[index]));
                queue.add(cur.right);
            }
            index++;
        }
        return root;
    }
}
