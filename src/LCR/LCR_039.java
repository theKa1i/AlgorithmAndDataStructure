package LCR;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class LCR_039 {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        if (len < 1) return 0;
        Stack<List<Integer>> stack = new Stack<>();
        int[] left_nearest = new int[len], right_nearest = new int[len];
        for (int i = 0; i < len; i++){
            while (!stack.empty()){
                if (heights[i] < heights[stack.peek().getFirst()]){
                    ArrayList<Integer> index = (ArrayList<Integer>) stack.pop();
                    for (Integer t : index){
                        right_nearest[t] = i;
                        left_nearest[t] = stack.empty() ? -1 : stack.peek().getLast();
                    }
                } else break;
            }
            if (!stack.empty() && heights[i] == heights[stack.peek().getFirst()]) stack.peek().add(i);
            else {
                ArrayList<Integer> x = new ArrayList<>();
                x.add(i);
                stack.push(x);
            }
        }
        while (!stack.empty()){
            ArrayList<Integer> index = (ArrayList<Integer>) stack.pop();
            for (int t : index){
                right_nearest[t] = len;
                left_nearest[t] = stack.empty() ? -1 : stack.peek().getLast();
            }
        }
        int max = 0;
        for (int i = 0; i < len; i++) {
            max =Math.max((right_nearest[i] - left_nearest[i] - 1) * heights[i], max);
        }
        return max;
    }

}
