package LCR;

import java.util.ArrayList;
import java.util.List;

public class LCR_085 {
    public StringBuffer sb = new StringBuffer();
    public List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        traceBack(n, 0, 0);
        return res;
    }

    public void traceBack(int n, int cur, int rest){
        if (cur == n && rest == 0) {
            res.add(sb.toString());
            return;
        }
        if (cur < n){
            sb.append('(');
            traceBack(n, cur + 1, rest + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (rest > 0){
            sb.append(')');
            traceBack(n, cur, rest - 1);
            sb.deleteCharAt(sb.length() - 1);
        }

    }
}
