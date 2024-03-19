package LCR;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class LCR_074 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        int ptr = 0;
        Stack<int[]> stack = new Stack<>();
        for (int[] p : intervals){
            if (stack.empty()) stack.push(p);
            else {
                if (p[0] <= stack.peek()[1]){
                    int[] pop = stack.pop();
                    int[] input = new int[]{pop[0], Math.max(pop[1], p[1])};
                    stack.push(input);
                } else stack.push(p);
            }
        }
        int[][] res = new int[stack.size()][2];
        for (int i = res.length - 1; i >= 0; i--){
            res[i] = stack.pop();
        }
        return res;
    }
}
