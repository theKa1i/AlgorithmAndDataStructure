package LCR;

import java.util.HashSet;

public class LCR_116 {
    public int findCircleNum(int[][] isConnected) {
        int num = isConnected.length;
        int[] parent = new int[num];
        for (int i = 0; i < num; i++) {
            parent[i]  = i;
        }
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                if (isConnected[i][j] == 1)
                    union(parent, i, j);
            }
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < num; i++) {
            set.add(find(parent, i));
        }
        return set.size();
    }

    public int find(int[] parent, int x){
        if (x == parent[x]) return x;
        parent[x] = find(parent, parent[x]);
        return parent[x];
    }

    public void union(int[] parent, int x, int y){
        parent[find(parent, x)] = find(parent, y);
    }
}
