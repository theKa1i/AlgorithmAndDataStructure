package LCR;

public class LCR_077 {
      public class ListNode {
      int val;
      ListNode next;ListNode() {}
      ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode midNode = getMidNode(head);
        head = sortList(head);
        midNode = sortList(midNode);
        return mergeSort(head, midNode);
    }

    public ListNode mergeSort(ListNode head1, ListNode head2){
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (head1 != null && head2 != null){
            if (head1.val <= head2.val){
                cur.next = head1;
                head1 = head1.next;
            } else {
                cur.next = head2;
                head2 = head2.next;
            }
            cur = cur.next;
        }
        cur.next = head1 == null ? head2 : head1;
        return dummy.next;
    }

    public ListNode getMidNode(ListNode head){
          ListNode fast = head.next,slow = head;
          while (fast.next != null && fast.next.next != null){
              slow = slow.next;
              fast = fast.next.next;
          }
          ListNode mid = slow.next;
          slow.next = null;
          return mid;
    }
}
