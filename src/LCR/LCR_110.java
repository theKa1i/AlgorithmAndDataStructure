package LCR;

import java.util.ArrayList;
import java.util.List;

public class LCR_110 {
    public List<List<Integer>> res = new ArrayList<>();
    public List<Integer> temp = new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        temp.add(0);
        dfs(graph, 0, graph.length - 1);
        return res;
    }

    public void dfs(int[][] graph, int cur, int target){
        if (cur == target) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int next : graph[cur]){
            temp.add(next);
            dfs(graph, next , target);
            temp.removeLast();
        }
    }
}
