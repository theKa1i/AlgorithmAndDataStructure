package LCR;

public class LCR_090 {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        return Math.max(dp(nums,0, nums.length - 1), dp(nums, 1, nums.length));
    }

    public int dp(int[] nums, int start, int end){
        int[] dp = new int[end - start];
        int n = dp.length;
        dp[n - 1] = nums[end - 1];
        dp[n - 2] = Math.max(nums[end - 1], nums[end - 2]);
        for (int i = n - 3; i >= 0; i--){
            dp[i] = Math.max(dp[i + 2] + nums[i + start], dp[i + 1]);
        }
        return dp[0];
    }
}
