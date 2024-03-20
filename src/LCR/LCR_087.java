package LCR;

import java.util.ArrayList;
import java.util.List;

public class LCR_087 {
    List<String> temp = new ArrayList<>();
    List<List<String>> res = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        if (s.length() > 16) return new ArrayList<>();
        traceBack(0, s);
        List<String> strings = new ArrayList<>();
        for (List<String> r : res){
            StringBuffer sb = new StringBuffer();
            sb.append(r.getFirst()).append('.').append(r.get(1)).append('.')
                            .append(r.get(2)).append('.').append(r.get(3));
            strings.add(sb.toString());
        }
        return strings;
    }

    public void traceBack(int cur, String s){
        if (temp.size() == 4 && cur == s.length()){
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = cur; i < cur + 3 && i < s.length(); i++) {
            String sub = s.substring(cur, i + 1);
            int par = Integer.parseInt(sub);
            boolean log = sub.charAt(0) != '0' && sub.length() > 1;
            log |= sub.length() == 1;
            if (par <= 255 && log){
                temp.add(sub);
                traceBack(i + 1, s);
                temp.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        int a = Integer.parseInt("25525511135");
        System.out.println(a);
    }
}
