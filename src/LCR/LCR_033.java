package LCR;

import java.util.*;

public class LCR_033 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs){
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String res = Arrays.toString(ch);
            List<String> list = map.getOrDefault(res, new ArrayList<>());
            list.add(str);
            map.put(res, list);
        }
        return new ArrayList<>(map.values());
    }
}
