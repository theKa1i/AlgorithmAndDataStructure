package LCR;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeMap;

public class LCR_075 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr2.length; i++){
            map.put(arr2[i], i);
        }
        int[][] sorts = new int[arr1.length][2];
        for (int i = 0; i < arr1.length; i++) {
            sorts[i][0] = arr1[i];
            sorts[i][1] = map.getOrDefault(arr1[i], Integer.MAX_VALUE);
        }
        Arrays.sort(sorts, (o1, o2) -> {
            if (o1[1] - o2[1] < 0) return -1;
            else if (o1[1] - o2[1] > 0) return 1;
            else return o1[0] - o2[0];
        });
        int[] res = new int[arr1.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = sorts[i][0];
        }
        return res;
    }
}
