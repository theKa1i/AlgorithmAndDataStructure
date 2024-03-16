package LCR;

import java.util.HashMap;

//给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
public class LCR_011 {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n+1];
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) nums[i] = -1;
        }

        for (int i = 1; i <= n ; i++) {
            pre[i] = pre[i-1] + nums[i-1];
        }

        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < pre.length; i++) {
            int key = pre[i];
            if (!map.containsKey(key)) map.put(key, i);
            else {
                res = Math.max(res, i - map.get(key));
            }
        }
        return res;
    }
}
