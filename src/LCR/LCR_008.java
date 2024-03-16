package LCR;

import java.util.Arrays;

//给定一个含有 n 个正整数的数组和一个正整数 target 。
//
//找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
public class LCR_008 {
    public int minSubArrayLen(int target, int[] nums) {
        if (nums.length == 0) return 0;
        int l =  0, r = 0;
        int min = nums.length + 1;
        int sum = nums[0];
        while(true){
            if (sum < target) {
                r++;
                if (r >= nums.length) break;
                sum += nums[r];
            } else {
                min = Math.min(min, r - l + 1);
                sum -= nums[l];
                if (l == r) r++;
                l++;
            }
        }
        if (min == nums.length + 1) return 0;
        return min;
    }
}
