package LCR;

public class LCR_091 {
    public int minCost(int[][] costs) {
        int[][] dp = new int[costs.length][3];
        int n = dp.length;
        dp[n - 1] = costs[n - 1];
        for (int i = n - 2; i >= 0; i--){
            dp[i][0] = Math.min(dp[i + 1][1], dp[i + 1][2]) + costs[i][0];
            dp[i][1] = Math.min(dp[i + 1][0], dp[i + 1][2]) + costs[i][1];
            dp[i][2] = Math.min(dp[i + 1][0], dp[i + 1][1]) + costs[i][2];
        }

        return Math.min(Math.min(dp[0][0], dp[0][1]), dp[0][2]);
    }
}
