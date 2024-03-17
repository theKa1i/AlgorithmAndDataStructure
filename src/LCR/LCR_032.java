package LCR;

import java.util.HashMap;
import java.util.Map;

public class LCR_032 {
    public boolean isAnagram(String s, String t) {
        if (s.isEmpty() || t.isEmpty() || s.length()!=t.length() || s.equals(t)) return false;
        Map<Character, Integer> map = new HashMap<>();
        char[] ss = s.toCharArray(), tt = t.toCharArray();
        int len = ss.length;
        for (int i = 0; i < len; i++){
            map.put(ss[i], map.getOrDefault(ss[i] , 0) + 1);
            map.put(tt[i], map.getOrDefault(tt[i], 0) - 1);
        }
        for (int a : map.values()){
            if (a != 0) return false;
        }
        return true;
    }
}
