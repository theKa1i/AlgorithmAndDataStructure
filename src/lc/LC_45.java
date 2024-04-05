package lc;

public class LC_45 {
    public int jump(int[] nums) {
        int n = nums.length,max = 0, res = 0, temp = 0;
        for (int i = 0; i < n - 1; i++) {
            max = Math.max(max, nums[i] + i);
            if (i == temp) {
                temp = max;
                res++;
            }
        }
        return res;
    }
}
