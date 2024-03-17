package LCR;

import java.util.Stack;

//给定两个 非空链表 l1和 l2 来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
//
//可以假设除了数字 0 之外，这两个数字都不会以零开头。
public class LCR_025 {
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1, p2 = l2;
        Stack<Integer> s1 = new Stack<>(), s2 = new Stack<>();
        int carry = 0;
        while (p1 != null) {
            s1.push(p1.val);
            p1 = p1.next;
        }
        while (p2 != null){
            s2.push(p2.val);
            p2 = p2.next;
        }
        ListNode head = null;
        while (!s1.empty() || !s2.empty() || carry != 0){
            int a = s1.empty() ? 0 : s1.pop();
            int b = s2.empty() ? 0 :s2.pop();
            int sum = (a + b + carry);
            carry = sum / 10;
            sum %= 10;
            ListNode node = new ListNode(sum);
            node.next = head;
            head = node;
        }
        return head;
    }
}
