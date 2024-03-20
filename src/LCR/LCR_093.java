package LCR;

import java.util.HashMap;

public class LCR_093 {
    public int lenLongestFibSubseq(int[] arr) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int n = arr.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            map.put(arr[i], i);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i][j], 2);
                if (map.containsKey(arr[i] + arr[j])){
                    int k = map.get(arr[i] + arr[j]);
                    dp[j][k] = dp[i][j] + 1;
                    res = Math.max(dp[j][k], res);
                }
            }
        }
        return res;
    }
}
