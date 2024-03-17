package LCR;
//给定一个链表的 头节点 head ，请判断其是否为回文链表。
//
//如果一个链表是回文，那么链表节点序列从前往后看和从后往前看是相同的。
public class LCR_027 {
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
    public boolean isPalindrome(ListNode head) {
        if (head == null) return false;
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow.next;
        slow.next = null;
        ListNode pre = null, cur = mid;
        while(cur != null){
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        while ( head != null && pre != null){
            if (head.val == pre.val){
                head = head.next;
                pre = pre.next;
            } else return false;
        }
        return true;
    }
}
