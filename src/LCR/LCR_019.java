package LCR;
//给定一个非空字符串 s，请判断如果 最多 从字符串中删除一个字符能否得到一个回文字符串。
public class LCR_019 {
    public boolean validPalindrome(String s) {
        if (s == null || s.isEmpty()) return false;
        char[] ch = s.toCharArray();
        int chance = 2;

        int l = 0, r = s.length() - 1;
        while (l < r){
            if (ch[l] == ch[r]){
                l++;r--;
                continue;
            }
            if (chance == 0) return false;
            else {
                if (chance == 2) {
                    chance--;
                    l++;
                }
                else if (chance == 1) {
                    r--;
                    l--;
                    chance--;
                }
                else return false;
            }
        }
        return true;
    }
}

