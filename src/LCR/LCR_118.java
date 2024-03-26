package LCR;

public class LCR_118 {
    int[] parent;

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < n; i++) {
            int[] e = edges[i];
            int x = e[0], y = e[1];
            if (find(parent, x) != find(parent, y))
                union(parent, x, y);
            else return e;
        }
        return new int[]{};
    }

    public void union(int[] parent, int x, int y){
        parent[find(parent, x)] = find(parent, y);
    }

    public int find(int[] parent, int x){
        if (x != parent[x]){
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }
}
