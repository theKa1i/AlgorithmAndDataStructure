package LCR;

import java.util.ArrayList;
import java.util.List;

public class LCR_081 {
    public List<Integer> temp = new ArrayList<>();
    public List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        traceBack(candidates, 0, target);
        return res;
    }

    public void traceBack(int[] candidates, int index, int rest){
        if (index == candidates.length) {
            if (rest == 0)
                res.add(new ArrayList<>(temp));
            return;
        }
        for (int piece = 0; candidates[index] * piece <= rest; piece++){
            for (int i = 0; i < piece; i++)
                temp.add(candidates[index]);
            traceBack(candidates, index + 1, rest - candidates[index] * piece);
            for (int i = 0; i < piece; i++)
                temp.removeLast();
        }
    }
}
