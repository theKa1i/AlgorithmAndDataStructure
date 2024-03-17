package LCR;

import java.util.Stack;

public class LCR_038 {
    public static int[] dailyTemperatures(int[] temperatures) {
        if (temperatures == null || temperatures.length < 1) return new int[]{};
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++){
            while (!stack.empty()){
                if (temperatures[i] > temperatures[stack.peek()]){
                    int idx = stack.pop();
                    res[idx] = i - idx;
                } else break;
            }
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        dailyTemperatures(new int[]{73,74,75,71,69,72,76,73});
    }
}
