package LCR;

public class LCR_105 {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1)
                    max = Math.max(max, dfs(grid, i, j));
            }
        }
        return max;
    }

    public int dfs(int[][] grid, int x, int y){
        int m = grid.length, n = grid[0].length;
        if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] != 1){
            return 0;
        }
        grid[x][y] = 2;
        return 1 + dfs(grid, x + 1, y) + dfs(grid, x - 1, y) + dfs(grid, x, y + 1) + dfs(grid, x, y - 1);
    }
}
