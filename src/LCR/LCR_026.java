package LCR;
//给定一个单链表 L 的头节点 head ，单链表 L 表示为：
//
// L0 → L1 → … → Ln-1 → Ln
//请将其重新排列后变为：
//
//L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → …
//
//不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
public class LCR_026 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    public void reorderList(ListNode head) {
        if (head == null) return;
        ListNode slow = head, fast = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode pre = null, cur = slow.next;
        slow.next = null;
        while (cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        ListNode top = head, tail = pre;
        while(top != null && tail != null){
            ListNode tmp1 = top.next;
            ListNode tmp2 = tail.next;
            top.next = tail;
            top = tmp1;
            tail.next = top;
            tail = tmp2;
        }

    }
}
