package LCR;

public class LCR_096 {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length(), n = s2.length();
        if(m + n != s3.length()) return false;
        if(m < n){
            String x = s1;
            s1 = s2;
            s2 = x;
            m = s1.length();
            n = s2.length();
        }
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 0; i <= m; ++i){
            for (int j = 0; j <= n; ++j){
                if(i > 0)   dp[j] = dp[j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
                if(j > 0)   dp[j] = dp[j] || (dp[j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
            }
        }
        return dp[n];
    }
}
