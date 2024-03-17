package LCR;
//给定一个字符串 s ，请计算这个字符串中有多少个回文子字符串。
//
//具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。

//MANACHER算法
public class LCR_020 {
    public int countSubstrings(String s) {
        return manacher(s);
    }

    public int manacher(String s){
        StringBuffer sb = new StringBuffer("?#");
        for (char c : s.toCharArray()){
            sb.append(c);
            sb.append('#');
        }
        sb.append('!');
        char[] t = sb.toString().toCharArray();
        int n = t.length - 1;
        int[] f = new int[n];
        int res = 0;
        int l_max = 0, r_max = 0;
        for (int i = 1; i < n; ++i){
            // 若 i 比最右回文子串还靠右，则对于 i 的回文情况全无所知：
            //          因此，只能设回文半径为 1 向外找最大回文半径
            // 若 i 在一个已知的回文子串内部，则可知：
            //          “（重点）在回文串内”："i"周围的元素，与"i在回文串左侧对应点"周围的元素一致，
            //          所以，i的回文半径至少为 min(f[i在回文串左边对应点], i到回文串边界的距离)
            //          即为：min(f[lMax + rMax - i], rMax + 1 - i)
            f[i] = i > r_max ? 1 : Math.min(f[l_max + r_max - i], r_max - i + 1);

            // 确定 f[i] 的最小值后，向两侧找到最大的回文半径
            // 前面在t前后加上不同的，不会出现的字符，就是为了不在这里写越界的特判
            while(t[i + f[i]] == t[i - f[i]]){
                f[i] ++;
            }
            // 如果以 i 为中心的回文串更加靠右，则更新 lMax, rMax
            // lMax, rMax 始终记录着最靠右的回文子串的左右端点
            if ( i + f[i] - 1 > r_max){
                r_max = i + f[i] - 1;
                l_max = i - f[i] + 1;
            }
            res += f[i] / 2;
        }
        return res;
    }
}
