package lc;

import java.util.HashSet;
import java.util.TreeSet;

public class LC_3 {
    public static int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int left = 0, right = 0;
        HashSet<Character> map = new HashSet<>();
        int max = 0;
        while(right < len){
            if (!map.contains(s.charAt(right))){
                map.add(s.charAt(right++));
                max = Math.max(max, right - left);
            } else {
                map.remove(s.charAt(left++));
            }
        }
        return max;
    }

    public static void main(String[] args) {
        lengthOfLongestSubstring("ynyu");
    }
}
