package LCR;

import java.util.ArrayList;
import java.util.List;

public class LCR_086 {
    public List<List<String>> res = new ArrayList<>();
    public List<String> temp = new ArrayList<>();
    boolean[][] dp;
    public String[][] partition(String s) {
        dp = new boolean[s.length()][s.length()];
        dpSearch(s);
        traceBack(s, 0);
        String[][] ans = new String[res.size()][];
        for (int i = 0; i < res.size(); i++) {
            List<String> t = res.get(i);
            ans[i] = t.toArray(new String[0]);
        }
        return ans;
    }

    public void dpSearch(String s){
        dp[0][0] = true;
        for (int i = 1; i < s.length(); i++) {
            dp[i][i] = true;
            dp[i - 1][i] = s.charAt(i) == s.charAt(i - 1);
        }
        for (int i = s.length() - 3; i >=0 ; i--) {
            for (int j = i + 2; j < s.length(); j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1];
            }
        }
    }

    public void traceBack(String s, int cur){
        if (cur == s.length()){
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = cur; i < s.length(); i++){
            if (dp[cur][i]){
                temp.add(s.substring(cur, i + 1));
                traceBack(s, i + 1);
                temp.removeLast();
            }
        }
    }

}
