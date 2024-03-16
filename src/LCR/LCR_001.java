package LCR;


//给定两个整数 a 和 b ，求它们的除法的商 a/b ，要求不得使用乘号 '*'、除号 '/' 以及求余符号 '%' 。

//整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
//假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231, 231−1]。本题中，如果除法结果溢出，则返回 231 − 1

public class LCR_001 {
    public int div(int a, int b) {
        int x = Math.abs(a);
        int y = Math.abs(b);
        int res = 0;
        for (int i = 31; i > -1; i = i - 1){
            if ((x >> i) >= y){
                res |= (1 << i);
                x = x - (y << i);
            }
        }
        return (a ^ b) < 0 ? -res : res;
    }

    public int multi(int a, int b){
        int res = 0;
        while (b != 0){
            if ((b & 1) != 0){
                res += a;
            }
            a <<= 1;
            b >>>= 1;
        }
        return res;
    }

    public int divide(int a, int b){
        if (b == 0) return Integer.MAX_VALUE;
        if (a == Integer.MIN_VALUE && b == Integer.MIN_VALUE) return 1;
        else if (b == Integer.MIN_VALUE) return 0;
        else if (a == Integer.MIN_VALUE){
            if (b == 1) return Integer.MIN_VALUE;
            if (b == -1) return Integer.MAX_VALUE;
            int res = div(a + 1, b);
            return res + div(a - multi(res, b), b);
        } else {
            return div(a, b);
        }
    }

}
