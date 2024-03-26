package LCR;

import java.util.HashSet;

public class LCR_117 {
    public int numSimilarGroups(String[] strs) {
        UnionFind find = new UnionFind(strs.length);
        for (int i = 0; i < strs.length; i++){
            for (int j = i + 1; j < strs.length; j++)
                find.union(strs, i, j);
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < find.parent.length; i++) {
            set.add(find.find(strs, i));
        }
        return set.size();
    }

    class UnionFind{
        int[] parent;
        UnionFind(int len){
            parent = new int[len];
            for (int i = 0; i < len; i++){
                parent[i] = i;
            }
        }

        public void union(String[] strs, int x, int y){
            if (check(strs[x], strs[y])){
                parent[find(strs, x)] = find(strs, y);
            }
        }

        public int find(String[] strs, int x){
            if (x == parent[x]){
                return x;
            }
            parent[x] = find(strs, parent[x]);
            return parent[x];
        }

        public boolean check(String a, String b) {
            int num = 0;
            for (int i = 0; i < a.length(); i++) {
                if (a.charAt(i) != b.charAt(i)) {
                    num++;
                    if (num > 2) {
                        return false;
                    }
                }
            }
            return true;
        }

        public void swap(char[] cs, int x, int y){
            char a = cs[x];
            cs[x] = cs[y];
            cs[y] = a;
        }
    }
}