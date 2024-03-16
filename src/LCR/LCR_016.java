package LCR;

//给定一个字符串 s ，请你找出其中不含有重复字符的 最长连续子字符串 的长度。
public class LCR_016 {
    public int lengthOfLongestSubstring(String s) {
        if (s == "") return 0;
        int res = 0;
        int[] cnt = new int[256];
        int l = 0, r = 0;
        while (r < s.length()){
            int index = s.charAt(r) - '\0';
            if (cnt[index] <= 0) {
                cnt[index]++;
                r++;
                res = Math.max(res, r - l);
                continue;
            } else {
                cnt[s.charAt(l) - '\0']--;
                l++;
            }
        }
        return res;
    }
}
