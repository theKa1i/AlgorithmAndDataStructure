package LCR;

import java.util.*;

public class LCR_082 {
    public List<List<Integer>> res = new ArrayList<>();
    public List<Integer> temp = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int c : candidates){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        ArrayList<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());

        traceBack(list, 0, target);
        return res;
    }

    public void traceBack(ArrayList<Map.Entry<Integer, Integer>> list, int index, int rest){
        if (index == list.size()){
            if (rest == 0) {
                List<Integer> a = new ArrayList<>(temp);
                res.add(a);
            }
            return;
        }
        Map.Entry<Integer, Integer> entry = list.get(index);
        int num = entry.getKey(), time = entry.getValue();
        for (int i = 0; i * num <= rest && i <= time; i++) {
            for (int j = 0; j < i; j++) {
                temp.add(num);
            }
            traceBack(list, index + 1, rest - i * num);
            for (int j = 0; j < i; j++) {
                temp.removeLast();
            }
        }
    }
}
