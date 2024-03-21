package LCR;

import java.util.Arrays;

public class LCR_103 {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int coin : coins) {
            for (int j = coin; j <= amount; ++j) {
                dp[j] = Math.min(dp[j], dp[j - coin] + 1);
            }
        }
        if (dp[amount] > amount) return -1;
        return dp[amount];
    }
}
