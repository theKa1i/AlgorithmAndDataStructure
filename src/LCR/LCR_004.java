package LCR;

//给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
public class LCR_004 {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < 32; i++){
            int sum = 0;
            for (int j : nums){
                sum += (j >> i) & 1;
            }
            if (sum % 3 != 0){
                res |= (1 << i);
            }
        }

        return res;
    }
}
