package LCR;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LCR_084 {
    boolean[] vis;
    public List<Integer> temp = new ArrayList<>();
    public List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        vis = new boolean[nums.length];
        Arrays.sort(nums);
        traceBack(nums, 0);
        return res;
    }

    public void traceBack(int[] nums, int cur){
        if (cur == nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (vis[i] || (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1]))
                continue;
            temp.add(nums[i]);
            vis[i] = true;
            traceBack(nums, cur + 1);
            vis[i] = false;
            temp.removeLast();
        }
    }
}
