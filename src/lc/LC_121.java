package lc;

public class LC_121 {
    public int maxProfit(int[] prices) {
        int ptr = 0, max = 0;
        for (int i = 0; i < prices.length; i++){
            if (prices[i] < prices[ptr]) ptr = i;
            else if (prices[i] - prices[ptr] > max)
                max = prices[i] - prices[ptr];
        }
        return max;
    }
}
