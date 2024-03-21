package LCR;

import java.util.List;

public class LCR_100 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.getLast().size();
        int[] dp = new int[n];
        for (int i = 0; i < n ; ++i) {
            dp[i] = triangle.getLast().get(i);
        }

        for (int i = triangle.size() - 2; i >= 0; --i) {
            List<Integer> temp = triangle.get(i);
            for (int j = 0; j < temp.size(); ++j){
                dp[j] = Math.min(dp[j], dp[j + 1]) + temp.get(j);
            }
        }
        return dp[0];
    }
}
