package LCR;

public class LCR_102 {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0, n = nums.length;
        for (int i : nums){
            sum += i;
        }
        if(target > sum || target < -sum) return 0;
        int[] dp = new int[2 * sum + 1];
        if (nums[0] == 0) dp[sum] = 2;
        else {
            dp[sum - nums[0]] = 1;
            dp[sum + nums[0]] = 1;
        }
        for (int i = 1; i < n; ++i){
            int[] dp2 = new int[2 * sum + 1];
            for (int j = 2 * sum; j >= 0; --j){
                int left = j - nums[i] >= 0 ? dp[j - nums[i]] : 0;
                int right = j + nums[i] < dp.length ? dp[j + nums[i]] : 0;
                dp2[j] = left + right;
            }
            dp = dp2;
        }
        return dp[sum + target];
    }
}
