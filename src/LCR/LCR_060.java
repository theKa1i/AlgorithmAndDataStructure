package LCR;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LCR_060 {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int[] res = new int[k];
        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        for (Map.Entry<Integer, Integer> s : map.entrySet()){
            if (heap.size() < k) heap.add(new int[]{s.getKey(), s.getValue()});
            else {
                if (heap.peek()[1] < s.getValue()){
                    heap.poll();
                    heap.add(new int[]{s.getKey(), s.getValue()});
                }
            }
        }
        for (int i = 0; i < k; i++) {
            res[i] = heap.poll()[0];
        }
        return res;
    }
}
