package LCR;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class LCR_031 {

}

class LRUCache {
    private static class Node{
        int key, value;
        Node pre, next;
        Node(int k, int v){
            key = k;
            value = v;
        }
    }
    private final HashMap<Integer, Node> map = new HashMap<>();
    private final int cap;
    private final Node virtual = new Node(0, 0);
    public LRUCache(int capacity) {
        cap = capacity;
        virtual.pre = virtual;
        virtual.next = virtual;
    }

    public int get(int key) {
        Node node = getNode(key);
        return node == null ? -1 : node.value;
    }

    public void put(int key, int value) {
        Node node = getNode(key);
        if (node != null){
            node.value = value;
            return;
        }
        node = new Node(key, value);
        map.put(key, node);
        push(node);
        if (map.size() > cap){
            Node k = virtual.pre;
            map.remove(k.key);
            remove(k);
        }
    }

    private Node getNode(int key){
        if (!map.containsKey(key)) return null;
        Node node = map.get(key);
        remove(node);
        push(node);
        return node;
    }

    private void remove(Node x){
        x.pre.next = x.next;
        x.next.pre = x.pre;
    }

    private void push(Node x){
        x.pre = virtual;
        x.next = virtual.next;
        x.pre.next = x;
        x.next.pre = x;
    }
}