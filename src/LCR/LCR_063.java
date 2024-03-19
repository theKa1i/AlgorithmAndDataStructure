package LCR;

import java.util.List;
import java.util.StringJoiner;

public class LCR_063 {
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
        public Trie() {
            root = new Node(0, 0);
        }
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
        public String checkAndReplace(String word) {
            Node search = root;
            char[] words = word.toCharArray();
            StringBuffer sb = new StringBuffer();
            for (char w : words){
                search = search.next[w - 'a'];
                if (search == null) return word;
                else sb.append(w);
                if (search.end > 0) return sb.toString();
            }
            return word;
        }
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();
        for (String s : dictionary){
            trie.insert(s);
        }
        String[] sentences = sentence.split(" ");
        StringBuffer sj = new StringBuffer();
        for (int i = 0; i < sentences.length; i++) {
            sentences[i] = trie.checkAndReplace(sentences[i]);
            sj.append(sentences[i]);
            if (i != sentences.length - 1) sj.append(" ");
        }
        return sj.toString();
    }
}

