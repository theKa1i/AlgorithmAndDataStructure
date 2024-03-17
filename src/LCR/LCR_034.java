package LCR;

import java.util.Comparator;

public class LCR_034 {
    public static boolean isAlienSorted(String[] words, String order) {
        Comp c = new Comp(order);
        for (int i = 0; i <words.length - 1; i++){
            if (c.compare(words[i], words[i+1]) > 0)
                return false;
        }
        return true;
    }

    static class Comp implements Comparator<String> {
        public final String order;

        Comp(String order) {
            this.order = order;
        }

        @Override
        public int compare(String o1, String o2) {
            int l1 = 0, l2 = 0;
            while (l1 < o1.length() && l2 < o2.length()){
                int comp = order.indexOf(o1.charAt(l1)) - order.indexOf(o2.charAt(l2));
                if (comp != 0) return comp;
                l1++;
                l2++;
            }
            if (l1 < o1.length()) return 1;
            if (l2 < o2.length()) return -1;
            return 0;
        }

        @Override
        public boolean equals(Object obj) {
            return false;
        }
    }

    public static void main(String[] args) {
        isAlienSorted(new String[]{"hello","leetcode"}, "hlabcdefgijkmnopqrstuvwxyz");
    }
}
