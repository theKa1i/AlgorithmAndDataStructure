package LCR;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class LCR_115 {
    public boolean sequenceReconstruction(int[] nums, int[][] sequences) {
        int n = nums.length;
        int[] indegree = new int[n + 1];
        Set[] graph = new Set[n + 1];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new HashSet<Integer>();
        }

        for (int[] seq : sequences){
            int len = seq.length;
            for (int i = 0; i < len - 1; i++) {
                int pre = seq[i], next = seq[i + 1];
                if (graph[pre].add(next)){
                    indegree[next]++;
                }
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < graph.length; i++) {
            if (indegree[i] == 0)
                queue.offer(i);
        }

        while(!queue.isEmpty()){
            if (queue.size() > 1) return false;
            int pre = queue.poll();
            Set<Integer> head = graph[pre];
            for (Integer next : head){
                if (--indegree[next] == 0)
                    queue.offer(next);
            }
        }
        return true;
    }
}
