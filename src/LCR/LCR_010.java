package LCR;

import java.util.HashMap;
import java.util.HashSet;

//给定一个整数数组和一个整数 k ，请找到该数组中和为 k 的连续子数组的个数。
public class LCR_010 {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int pre = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            int j = pre - k;
            if (map.containsKey(j))
                res += map.get(j);
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return res;
    }
}
