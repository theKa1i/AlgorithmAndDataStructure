package LCR;

public class LCR_104 {
    public int combinationSum4(int[] nums, int target) {
        int n = nums.length;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int j = 1; j < dp.length; ++j){
            for (int num : nums){
                if (j - num >= 0)
                    dp[j] += dp[j - num];
            }
        }
        return dp[target];
    }
}
