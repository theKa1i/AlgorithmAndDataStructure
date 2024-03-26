package LCR;


import java.util.LinkedList;
import java.util.Queue;

public class LCR_107 {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] seen = new boolean[m][n];

        int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (mat[i][j] == 0){
                    queue.add(new int[]{i, j});
                    seen[i][j] = true;
                }
            }
        }
        int[][] distance = new int[m][n];
        while(!queue.isEmpty()){
            int[] p = queue.poll();
            for (int i = 0; i < 4; i++){
                int x = p[0] + dir[i][0];
                int y = p[1] + dir[i][1];
                if (x >= 0 && x < m && y >= 0 && y < n && !seen[x][y]){
                    distance[x][y] = distance[p[0]][p[1]] + 1;
                    seen[x][y] = true;
                    queue.add(new int[]{x, y});
                }
            }
        }
        return distance;
    }
}
