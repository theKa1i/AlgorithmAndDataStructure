package LCR;

import java.util.*;

public class LCR_119 {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        UnionFind find = new UnionFind(nums);
        for (int i = 0; i < n; i++) {
            find.union(nums[i], nums[i] + 1);
        }
        int max = 1;
        for (int num : nums) max = Math.max(max, find.find(num) - num + 1);
        return max;
    }

    class UnionFind{
        HashMap<Integer, Integer> map;
        public UnionFind(int[] nums){
            map = new HashMap<>();
            for (int n : nums) map.put(n, n);
        }

        public int find(int x){
            if (map.get(x) == x) return x;
            map.put(x, find(map.get(x)));
            return map.get(x);
        }

        public void union(int x, int y){
            if (map.containsKey(y)) map.put(x, y);
        }
    }
}
