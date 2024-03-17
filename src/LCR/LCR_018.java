package LCR;

import java.util.Stack;

//给定一个字符串 s ，验证 s 是否是 回文串 ，只考虑字母和数字字符，可以忽略字母的大小写。
//
//本题中，将空字符串定义为有效的 回文串 。
public class LCR_018 {
    public boolean isPalindrome(String s) {
        if (s == null || s.isEmpty()) return false;
        char[] ch = s.toUpperCase().toCharArray();
        int l = 0, r = s.length() - 1;
        while (l < r) {
            char left = ch[l];
            if (!isValid(left)){
                l++;
                continue;
            }
            char right = ch[r];
            if (!isValid(right)){
                r--;
                continue;
            }
            if (left == right){
                l++;
                r--;
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean isValid(char c){
        int c1 = c - 'A';
        int c2 = c - '0';
        return (c1 >= 0 && c1 <= 25) || (c2 >= 0 && c2 <= 9);
    }

}
