package lc;

public class ListNode {
    int key, val;
    ListNode next;
    ListNode pre;
    ListNode() {}
    ListNode(int key, int val) { this.key = key; this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
