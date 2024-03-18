package LCR;

import java.util.LinkedList;
import java.util.Queue;

public class LCR_042 {

}

class RecentCounter {
    public Queue<Integer> queue = new LinkedList<>();
    public RecentCounter() {

    }

    public int ping(int t) {
        while (!queue.isEmpty() && t - queue.peek() > 3000){
            queue.poll();
        }
        queue.add(t);
        return queue.size();
    }
}