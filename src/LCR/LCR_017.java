package LCR;

import java.util.Arrays;

public class LCR_017 {
    public String minWindow(String s, String t) {
        int m = s.length(), n = t.length();
        if (m < n) return "";
        int[] cnt = new int[60];
        int flag = 0;
        for (int i = 0; i < n; i++) {
            cnt[t.charAt(i) - 'A']++;
            cnt[s.charAt(i) - 'A']--;
        }
        for (int c:cnt)
            if (c > 0) flag++;
        if (flag == 0) return s.substring(0, n);
        int l = 0, r = n, ml = 0, mr = m;
        for (; r < m; r++){
            int in = s.charAt(r) - 'A';
            cnt[in]--;
            if (cnt[in] == 0) flag--;
            if (flag != 0) continue;
            while (true){
                int out = s.charAt(l) - 'A';
                cnt[out]++;
                l++;
                if (cnt[out] == 1) {
                    flag++;
                    break;
                }
            }
            if (r - l + 1 < mr - ml){
                mr = r;
                ml = l - 1;
            }
        }
        return mr == m ? "" : s.substring(ml, mr + 1);
    }

    public static void main(String[] args) {
    }
}
