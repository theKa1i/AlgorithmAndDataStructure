package LCR;

import java.util.ArrayList;
import java.util.HashMap;

public class LCR_062 {
}
class Trie {
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
    public Node root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new Node(0, 0);
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        char[] words = word.toCharArray();
        Node finals = root;
        finals.times++;
        for (char w : words){
            int key = w - 'a';
            Node n = finals.next[key] == null ? new Node(0, 0) : finals.next[key];
            n.times++;
            finals.next[key] = n;
            finals = n;
        }
        finals.end++;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node search = root;
        char[] words = word.toCharArray();
        for (char w : words){
            search = search.next[w - 'a'];
            if (search == null) return false;
        }
        return search.end > 0;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node search = root;
        char[] words = prefix.toCharArray();
        for (char w : words){
            search = search.next[w - 'a'];
            if (search == null) return false;
        }
        return search.times > 0;
    }
}