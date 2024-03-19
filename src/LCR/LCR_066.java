package LCR;

import java.util.HashMap;
import java.util.Map;

public class LCR_066 {
}

class MapSum {
    class Node{
        int end = 0;
        int times = 0;

        Node[] next;
        Node(int end, int times){
            this.end = end;
            this.times = times;
            next = new Node[26];
        }
    }
    /** Initialize your data structure here. */
    public Node root;
    public Map<String, Integer> map = new HashMap<>();
    public MapSum() {
        root = new Node(0, 0);
    }

    public void insert(String key, int val) {
        int pre = map.getOrDefault(key, 0);
        map.put(key, val);
        val = val - pre;
        char[] words = key.toCharArray();
        Node finals = root;
        finals.times++;
        for (char w : words){
            int k = w - 'a';
            Node n = finals.next[k] == null ? new Node(0, 0) : finals.next[k];
            n.times += val;
            finals.next[k] = n;
            finals = n;
        }
        finals.end++;
    }

    public int sum(String prefix) {
        Node search = root;
        char[] words = prefix.toCharArray();
        for (char w : words){
            search = search.next[w - 'a'];
            if (search == null) return 0;
        }
        return search.times;
    }
}