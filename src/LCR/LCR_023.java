package LCR;
//给定两个单链表的头节点 headA 和 headB ，请找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
public class LCR_023 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
          val = x;
          next = null;
        }
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        ListNode a = headA, b = headB;
        int m = 0, n = 0;
        while (a != null){
            a = a.next;
            m++;
        }
        while (b != null){
            b = b.next;
            n++;
        }
        a = headA;
        b = headB;
        if (m > n){
            for (int i = 0; i < m - n; i++){
                a = a.next;
            }
        } else {
            for (int i = 0; i < n - m; i++){
                b = b.next;
            }
        }
        while (a != b){
            a = a.next;
            b = b.next;
        }
        return a;
    }
}
