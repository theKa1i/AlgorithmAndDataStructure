package LCR;

import java.util.Arrays;
import java.util.Comparator;

public class LCR_065 {
    class Trie{
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
        public int insert(String word) {
            char[] words = word.toCharArray();
            boolean b = false;
            Node finals = root;
            finals.times++;
            for (int i = words.length - 1; i >= 0; i--){
                int key = words[i] - 'a';
                b = finals.next[key] == null;
                Node n = finals.next[key] == null ? new Node(0, 0) : finals.next[key];
                n.times++;
                finals.next[key] = n;
                finals = n;
            }
            finals.end++;
            if (b) return word.length() + 1;
            else return 0;
        }
    }
    public int minimumLengthEncoding(String[] words) {
        Trie trie = new Trie();
        Arrays.sort(words, 0, words.length, (o1, o2) -> o2.length() - o1.length());
        int res = 0;
        for (String s:words){
            res += trie.insert(s);
        }
        return res;
    }
}
