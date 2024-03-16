package LCR;

public class LCR_013 {
}

class NumMatrix {
    public int[][] pre;
    public NumMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        this.pre = new int[row + 1][col + 1];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                this.pre[i + 1][j + 1] = matrix[i][j] + this.pre[i][j + 1] + this.pre[i + 1][j] - this.pre[i][j];
            }
        }
    }
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return this.pre[row2 + 1][col2 + 1] - this.pre[row1][col2 + 1] - this.pre[row2 + 1][col1] + this.pre[row1][col1];
    }
}