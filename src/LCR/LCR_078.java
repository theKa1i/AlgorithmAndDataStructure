package LCR;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LCR_078 {
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

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length < 1) return null;
        ListNode dummy = new ListNode(), cur = dummy;
        PriorityQueue<ListNode> heap = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
//        heap.addAll(Arrays.asList(lists));
        for (ListNode listNode : lists){
            if (listNode != null) heap.add(listNode);
        }
        while (!heap.isEmpty()){
            ListNode min = heap.poll();
            cur.next = min;
            cur = min;
            if (min.next != null) heap.add(min.next);
        }
        return dummy.next;
    }
}
