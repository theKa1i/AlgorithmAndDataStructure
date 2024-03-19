package LCR;

public class LCR_070 {
    public int singleNonDuplicate(int[] nums) {
        int res = 0;
        for (int num : nums){
            res ^= num;
        }
        return res;
    }
}
