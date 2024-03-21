package LCR;

public class LCR_106 {
    public int[] color;
    public boolean res = true;
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        color = new int[n];
        for (int i = 0 ; i < n && res; ++i){
            if (color[i] == 0) dfs(graph, i, 1);
        }
        return res;
    }

    public void dfs(int[][] grid, int cur, int color){
        this.color[cur] = color;
        int next = color == 1 ? 2 : 1;
        for (int neighbor : grid[cur]){
            if (this.color[neighbor] == 0){
                dfs(grid, neighbor, next);
                if (!res) return;
            } else if (this.color[neighbor] != next){
                res = false;
                return;
            }
        }
    }
}
