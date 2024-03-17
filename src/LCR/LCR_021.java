package LCR;
//给定一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
public class LCR_021 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return new ListNode();
        ListNode virtual = new ListNode(0, head);
        ListNode behind = virtual, front = head;
        for (int i = 0; i < n; i++) {
            front = front.next;
        }
        while(front != null){
            front = front.next;
            behind = behind.next;
        }
        behind.next = behind.next.next;
        return virtual.next;
    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}