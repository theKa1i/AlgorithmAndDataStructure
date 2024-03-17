package LCR;

public class LCR_029 {
    class Node {
        public int val;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    };
    public Node insert(Node head, int insertVal) {
        if (head == null) {
            Node ak = new Node(insertVal);
            ak.next = ak;
            return ak;
        }
        Node behind = head, front = head.next;
        while (true){
            if (front.val >= insertVal && behind.val < insertVal){
                behind.next = new Node(insertVal, front);
                break;
            }
            if (front.val < behind.val){
                if (insertVal > behind.val || insertVal <= front.val) {
                    behind.next = new Node(insertVal, front);
                    break;
                }
            }
            front = front.next;
            behind = behind.next;
            if (front == head){
                behind.next = new Node(insertVal, front);
                break;
            }
        }
        return head;
    }
}
