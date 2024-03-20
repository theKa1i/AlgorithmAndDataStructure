package LCR;

import java.util.Arrays;

public class LCR_094 {
    public int minCut(String s) {
        int n = s.length();
        boolean[][] dp1 = new boolean[n][n];
        for (int i = 0; i < n - 1; i++) {
            dp1[i][i] = true;
            dp1[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
        }
        dp1[n - 1][n - 1] = true;
        for (int i = n - 3; i >= 0; i--){
            for (int j = i + 1; j < n ; j++) {
                dp1[i][j] = dp1[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
            }
        }

        int[] dp2 = new int[n];
        Arrays.fill(dp2, Integer.MAX_VALUE);
        for (int i = 0; i < n; i++) {
            if (dp1[0][i]) dp2[i] = 0;
            else {
                for (int j = 1; j <= i; j++) {
                    if (dp1[j][i])
                        dp2[i] = Math.min(dp2[i], dp2[j - 1] + 1);
                }
            }
        }
        return dp2[n - 1];
    }
}
