package LCR;

import java.util.Stack;

public class LCR_028 {
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    };
    public Node flatten(Node head) {
        if (head == null) return null;
        Node cur = head;
        Stack<Node> s = new Stack<>();
        while (true){
            if (cur.child == null){
                if (cur.next != null)
                    cur = cur.next;
                else {
                    if (s.empty()) break;
                    else {
                        Node next = s.pop();
                        cur.next = next;
                        next.prev = cur;
                        cur = next;
                    }
                }
            } else {
                if (cur.next != null)
                    s.push(cur.next);
                Node child = cur.child;
                cur.next = child;
                child.prev = cur;
                cur = child;
            }
        }
        return head;
    }
//    递归方法
    Node pre;
    public Node flatten2(Node head) {
        if (head == null) return head;
        pre = null;
        DFS(head);
        return head;
    }
    public void DFS(Node head) {
        if (head == null) return;
        if (pre != null) {
            pre.next = head;
            head.prev = pre;
            pre.child = null;
        }
        Node next = head.next;
        pre = head;
        DFS(head.child);
        DFS(next);
    }
}
