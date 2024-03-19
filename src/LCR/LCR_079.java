package LCR;

import java.util.ArrayList;
import java.util.List;

public class LCR_079 {
    public List<List<Integer>> res = new ArrayList<>();
    public List<Integer> temp = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        traceBack(0, nums);
        return res;
    }

    public void traceBack(int cur, int[] nums){
        if (cur == nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[cur]);
        traceBack(cur + 1, nums);
        temp.removeLast();
        traceBack(cur + 1, nums);
    }
}
