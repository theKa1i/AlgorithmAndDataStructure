package LCR;

public class LCR_101 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i : nums){
            sum += i;
        }
        if (nums.length < 2 | sum % 2 == 1) return false;
        int n = nums.length;
        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int i : nums){
            for (int j = target; j >= i; --j){
                dp[j] |= dp[j - i];
            }
        }
        return dp[target];
    }
}
