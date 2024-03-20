package LCR;

public class LCR_089 {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        int[] dp = new int[nums.length];
        int n = dp.length;
        dp[n - 1] = nums[n - 1];
        dp[n - 2] = Math.max(nums[n - 1], nums[n - 2]);
        for (int i = dp.length - 3; i >= 0; i--){
            dp[i] = Math.max(dp[i + 2] + nums[i], dp[i + 1]);
        }
        return dp[0];
    }
}
