package LCR;

public class LCR_058 {

}

class MyCalendar{
    class TreeNode{
        TreeNode left;
        TreeNode right;
        int start;
        int end;
        public TreeNode(int start, int end){
            this.start = start;
            this.end = end;
        }
        public TreeNode(){
        }
    }

    TreeNode root;
    public MyCalendar() {

    }

    public boolean book(int start, int end) {
        if (root == null){
            root = new TreeNode(start, end);
            return true;
        }

        TreeNode p = root;
        while (p != null){
            if (end <= p.start){
                if (p.left == null){
                    p.left = new TreeNode(start, end);
                    return true;
                }
                p = p.left;
            } else if (start >= p.end) {
                if (p.right == null) {
                    p.right = new TreeNode(start, end);
                    return true;
                }
                p = p.right;
            } else return false;
        }
        return false;
    }
}