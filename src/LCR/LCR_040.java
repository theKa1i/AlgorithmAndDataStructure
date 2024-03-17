package LCR;

public class LCR_040 {
    public int maximalRectangle(String[] matrix) {
        if (matrix.length < 1) return 0;
        int area = 0;
        int[] heights = new int[matrix[0].length()];
        for (String s : matrix){
            for (int i = 0; i < heights.length; i++) {
                heights[i] = s.charAt(i) - '0' == 0 ? 0 : heights[i] + 1;
            }
            area = Math.max(area, maximal(heights));
        }
        return area;
    }

    private int maximal(int[] heights){
        int len = heights.length;
        int[] stack = new int[len + 1];
        stack[0] = -1;
        int ptr = 1;
        int area = 0;
        for (int i = 0; i < len; i++) {
            while(ptr > 0 && heights[stack[ptr]] >= heights[i]){
                area = Math.max(area, heights[stack[ptr--]] * (i - stack[ptr] - 1));
            }
            stack[++ptr] = i;
        }
        while (ptr > 0){
            area = Math.max(area, heights[stack[ptr--]] * (len - stack[ptr] - 1));
        }
        return area;
    }
}
