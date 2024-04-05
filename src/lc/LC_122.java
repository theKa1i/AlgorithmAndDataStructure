package lc;

import java.util.Stack;

public class LC_122 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        Stack<Integer> s = new Stack<>();
        int res = 0;
        s.push(prices[0]);
        for (int i = 1; i < n; i++) {
            if (prices[i] < s.peek()){
                int max = s.pop();
                int min = 0;
                while (!s.empty()) min = s.pop();
                if (min != 0) res += (max - min);
            }
            s.push(prices[i]);
        }
        if (!s.empty()){
            int max = s.pop();
            int min = 0;
            while (!s.empty()) min = s.pop();
            if (min != 0) res += (max - min);
        }
        return res;
    }
}
