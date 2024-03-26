package LCR;

import java.util.Arrays;

public class LCR_097 {
    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        if (m < n) return 0;
        int[] dp = new int[m + 1];
        Arrays.fill(dp, 1);

        for (int i = 1; i <= n; i++){
            int[] dp2 = new int[m + 1];
            for (int j = 1; j <= m; j++){
                if (s.charAt(j) != t.charAt(i))
                    dp2[j] = dp2[j - 1];
                else dp2[j] = dp2[j - 1] + dp[j - 1];
            }
            dp = dp2;
        }
        return dp[m];
    }
}
