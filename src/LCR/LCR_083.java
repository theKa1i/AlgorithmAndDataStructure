package LCR;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LCR_083 {
    public List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        backTrace(nums, 0);
        return res;
    }

    public void backTrace(int[] nums, int cur){
        if (cur == nums.length){
            ArrayList<Integer> a = (ArrayList<Integer>) Arrays.stream(nums).boxed().collect(Collectors.toList());
            res.add(a);
            return;
        }
        for (int i = cur; i < nums.length; i++){
            swap(nums, i , cur);
            backTrace(nums, cur + 1);
            swap(nums, i, cur);
        }
    }

    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
