package LCR;

import java.util.ArrayList;
import java.util.List;

public class LCR_080 {
    public List<List<Integer>> res = new ArrayList<>();
    public List<Integer> temp = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        traceBack(n, k, 1);
        return res;
    }

    public void traceBack(int n, int k, int cur){
        if (cur == n + 1 && k != 0) return;
        else if (cur <= n + 1 && k == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }
        temp.add(cur);
        traceBack(n, k - 1, cur + 1);
        temp.removeLast();
        traceBack(n, k, cur + 1);
    }

    public static void main(String[] args) {
        LCR_080 s = new LCR_080();
        s.traceBack(3, 2, 1);
    }
}
