package LCR;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//给定两个字符串 s 和 p，找到 s 中所有 p 的 变位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
//
//变位词 指字母相同，但排列不同的字符串。
public class LCR_015 {
    public List<Integer> findAnagrams(String s, String p) {
        int n = p.length(), m = s.length();
        List<Integer> list = new ArrayList<>();
        if (n > m) return list;
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];

        for (int i = 0; i < n; i++) {
            cnt1[s.charAt(i) - 'a']++;
            cnt2[p.charAt(i) - 'a']++;
        }

        if (Arrays.equals(cnt1, cnt2)) list.add(0);
        for (int i = n; i < m; ++i){
            cnt1[s.charAt(i) - 'a']++;
            cnt1[s.charAt(i - n) - 'a']--;
            if (Arrays.equals(cnt1, cnt2)) list.add(i - n + 1);
        }
        return list;
    }
}
