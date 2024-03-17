package LCR;

import java.util.Stack;

public class LCR_036 {
    public int evalRPN(String[] tokens) {
        if (tokens == null ||tokens.length < 1) return 0;
        Stack<Integer> s = new Stack<>();
        for (String token : tokens) {
            switch (token) {
                case "+" -> {
                    int sec = s.pop();
                    int fir = s.pop();
                    s.push(sec + fir);
                }
                case "-" -> {
                    int sec = s.pop();
                    int fir = s.pop();
                    s.push(fir - sec);
                }
                case "*" -> {
                    int sec = s.pop();
                    int fir = s.pop();
                    s.push(fir * sec);
                }
                case "/" -> {
                    int sec = s.pop();
                    int fir = s.pop();
                    s.push(fir / sec);
                }
                default -> s.push(Integer.parseInt(token));
            }
        }
        return s.peek();
    }
}
