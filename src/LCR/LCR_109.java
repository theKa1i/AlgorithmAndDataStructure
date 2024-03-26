package LCR;

import java.util.*;

public class LCR_109 {
    public int openLock(String[] deadends, String target) {
        if (target.equals("0000")) return 0;

        HashSet<String> dead = new HashSet<>(Arrays.asList(deadends));
        if (dead.contains(target) || dead.contains("0000")) return -1;

        Queue<String> queue = new LinkedList<>();
        HashSet<String> seen = new HashSet<>();

        queue.add("0000");
        int step = 0;
        while(!queue.isEmpty()){
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                List<String> list = getNext(cur);
                for (String n : list){
                    if (!seen.contains(n) && !dead.contains(n)){
                        if (n.equals(target)) return step;
                        queue.add(n);
                        seen.add(n);
                    }
                }
            }
        }
        return -1;
    }

    public List<String> getNext(String cur){
        if (cur == null) return new ArrayList<>();
        List<String> next = new ArrayList<>();
        char[] c = cur.toCharArray();
        for (int i = 0; i < c.length; i++){
            int up = (c[i] - '0' + 9) % 10;
            int down = (c[i] - '0' + 1) % 10;
            char ori = c[i];
            c[i] = (char)(up + '0');
            next.add(new String(c));
            c[i] = (char)(down + '0');
            next.add(new String(c));
            c[i] = ori;
        }
        return next;
    }
}
