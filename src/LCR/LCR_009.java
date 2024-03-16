package LCR;
//给定一个正整数数组 nums和整数 k ，请找出该数组内乘积小于 k 的连续的子数组的个数。
public class LCR_009 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;

        int n = nums.length, res = 0, multi = 1, l = 0;
        for (int r = 0; r < n; r++){
            multi *= nums[r];
            while (multi >= k){
                multi /= nums[l++];
            }
            res += r - l + 1;

        }
        return res;
    }
}
