package LCR;
//给定单链表的头节点 head ，请反转链表，并返回反转后的链表的头节点。
public class LCR_024 {
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

    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode ptr = head;
        while (ptr.next != null){
            ListNode next = ptr.next;
            ptr.next = next.next;
            next.next = head;
            head = next;
        }
        return head;
    }
}
