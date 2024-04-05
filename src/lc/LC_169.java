package lc;

import java.util.HashMap;
import java.util.Map;

public class LC_169 {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        Map.Entry<Integer, Integer> entry = null;
        for (Map.Entry<Integer, Integer> e : map.entrySet()){
            if (entry == null || e.getValue() > entry.getValue()){
                entry = e;
            }
        }
        return entry.getKey();
    }
}
