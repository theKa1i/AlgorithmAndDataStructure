package LCR;

import java.util.*;

public class LCR_108 {
    public HashMap<String, List<String>> graph = new HashMap<>();
    public HashMap<String, Integer> distance = new HashMap<>();
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        wordList.add(beginWord);
        for (String c : wordList){
            ArrayList<String> ss = new ArrayList<>();
            for (String d : wordList){
                if (checkSame(c, d)) ss.add(d);
            }
            graph.put(c, ss);
            distance.put(c, Integer.MAX_VALUE);
        }
        Queue<String> queue = new LinkedList<>();
        if (!graph.containsKey(endWord)) return 0;
        distance.put(beginWord, 0);
        queue.add(beginWord);
        while(!queue.isEmpty()){
            String x = queue.poll();
            if (x.equals(endWord)) return distance.get(x) + 1;
            for (String node : graph.get(x)){
                if (distance.get(node) == Integer.MAX_VALUE){
                    distance.put(node, distance.get(x) + 1);
                    queue.add(node);
                }
            }
        }
        return 0;
    }

    public boolean checkSame(String a, String b){
        if (a.length() != b.length()) return false;
        int p = 0;
        boolean check = false;
        for (; p < a.length(); p++){
            if (a.charAt(p) != b.charAt(p))
                if (!check) check = true;
                else return false;
        }
        return check;
    }
}
