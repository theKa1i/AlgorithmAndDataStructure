package lc;

public class LC_55 {
    public boolean canJump(int[] nums) {
        int dp = nums[0];
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            if (dp >= 1)
                dp = Math.max(dp - 1, nums[i]);
            else return false;
        }
        return true;
    }
}
