package LCR;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class LCR_113 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Set<Integer>[] graph = new Set[numCourses];
        int[] indegree = new int[numCourses];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new HashSet<>();
        }
        for (int[] pre : prerequisites){
            int prev = pre[1], next = pre[0];
            if (graph[prev].add(next)){
                indegree[next]++;
            }
        }
        int[] res = new int[numCourses];
        int p = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) queue.offer(i);
        }
        while (!queue.isEmpty()){
            int head = queue.poll();
            res[p++] = head;
            for (int n : graph[head]){
                if (--indegree[n] == 0) queue.offer(n);
            }
        }
        if (p < numCourses) return new int[]{};
        return res;
    }
}
