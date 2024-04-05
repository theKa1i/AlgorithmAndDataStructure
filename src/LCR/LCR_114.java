package LCR;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class LCR_114 {
    public static String alienOrder(String[] words) {
        int[] indegree = new int[27];
        Set[] graph = new Set[27];
        int cnt = 0;
        for (String w : words){
            for (char c : w.toCharArray())
                if (graph[c - 'a' + 1] == null) {
                    graph[c - 'a' + 1] = new HashSet<>();
                    cnt++;
                }
        }
        for (int i = 0; i < words.length - 1; i++) {
            int p = getFirstDiffPairs(words[i], words[i + 1], graph);
            if (p >= 0){
                int pre = words[i].charAt(p) - 'a' + 1;
                int next = words[i + 1].charAt(p) - 'a' + 1;
                if (graph[pre].add(next)){
                    indegree[next]++;
                }
            } else if (p == -2) return "";
        }
        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < graph.length ; i++) {
            if (graph[i] != null && indegree[i] == 0)
                queue.offer(i);
        }

        while(!queue.isEmpty()){
            int pre = queue.poll();
            sb.append((char)(pre + 'a' - 1));
            Set<Integer> head = graph[pre];
            for (int next : head){
                if (--indegree[next] == 0){
                    queue.offer(next);
                }
            }
        }
        if (sb.length() != cnt) return "";
        return sb.toString();
    }

    public static int getFirstDiffPairs(String str1, String str2, Set[] graph){
        int p = 0;
        while (str1.charAt(p) == str2.charAt(p) ){
            graph[str1.charAt(p) - 'a' + 1] = new HashSet<Integer>();
            graph[str2.charAt(p) - 'a' + 1] = new HashSet<Integer>();
            p++;
            if (p >= str1.length() || p >= str2.length()) {
                if (str1.length() > str2.length()) return -2;
                return -1;
            }
        }
        return p;
    }

    public static void main(String[] args) {
        alienOrder(new String[]{"z","x","a","zb","zx"});
    }
}
