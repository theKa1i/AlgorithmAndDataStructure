package LCR;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a ，b ，c ，使得 a + b + c = 0 ？请找出所有和为 0 且 不重复 的三元组。
public class LCR_007 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int r = nums.length;
        for (int i = 0; i < r - 1; i++) {
            int p1 = i + 1, p2 = r - 1;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            while (p1 < p2){
                if (nums[i] + nums[p1] + nums[p2] > 0) p2--;
                else if (nums[i] + nums[p1] + nums[p2] < 0) p1++;
                else {
                    ArrayList<Integer> a = new ArrayList<>(Arrays.asList(nums[i], nums[p1], nums[p2]));
                    if (!res.contains(a)) res.add(a);
                    p1++;
                    p2--;
                }
            }
        }

        return res;
    }
}
