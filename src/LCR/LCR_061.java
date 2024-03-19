package LCR;

import java.util.*;

public class LCR_061 {
    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(o -> -(o[0] + o[1])));
        int i1 = 0, i2 = 0;
        while (i1 < nums1.length){
            if (heap.size() == k){
                int[] top = heap.peek();
                if (nums1[i1] + nums2[i2] < top[0] + top[1]){
                    heap.poll();
                    heap.add(new int[]{nums1[i1] , nums2[i2]});
                }
            } else {
                heap.add(new int[]{nums1[i1] , nums2[i2]});
            }
            i2++;
            if (i2 == nums2.length) {
                i2 = 0;
                i1++;
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        int len = heap.size();
        for (int i = len - 1; i >=0; i--) {
            List<Integer> list = new ArrayList<>();
            int[] p = heap.poll();
            list.add(p[0]);
            list.add(p[1]);
            res.add(list);
        }
        return res.reversed();
    }

    public static void main(String[] args) {
        kSmallestPairs(new int[]{1,7,11}, new int[]{2,4,6}, 3);
    }
}
