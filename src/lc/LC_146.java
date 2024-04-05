package lc;

import java.util.HashMap;
import java.util.LinkedList;

public class LC_146 {

}
class LRUCache {
    public int capacity;
    public ListNode dummy = new ListNode();
    public HashMap<Integer, ListNode> map = new HashMap<>();
    public LRUCache(int capacity) {
        this.capacity = capacity;
        dummy.next = dummy;
        dummy.pre = dummy;
    }

    public int get(int key) {
        return getNode(key) == null ? -1 : getNode(key).val;
    }

    public void put(int key, int value) {
        ListNode node = map.get(key);
        if (node != null){
            node.val = value;
            return;
        }
        node = new ListNode(key, value);
        push(node);
        map.put(key, node);
        if (map.size() > capacity){
            ListNode del = dummy.pre;
            map.remove(del.key);
            remove(del);
        }
    }

    public ListNode getNode(int key){
        if (!map.containsKey(key)) return null;
        ListNode node = map.get(key);
        remove(node);
        push(node);
        return node;
    }

    public void push(ListNode node){
        node.pre = dummy;
        node.next = dummy.next;
        node.pre.next = node;
        node.next.pre = node;
    }

    public void remove(ListNode node){
          node.pre.next = node.next;
          node.next.pre = node.pre;
    }
}