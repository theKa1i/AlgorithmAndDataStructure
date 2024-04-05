package lc;

public class LC_206 {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null, cur = head, temp = head;
        while(cur != null){
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
