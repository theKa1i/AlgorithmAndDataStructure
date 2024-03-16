package LCR;
//给定一个非负整数 n ，请计算 0 到 n 之间的每个数字的二进制表示中 1 的个数，并输出一个数组。
public class LCR_003 {
    public int[] countBits(int n) {
        int[] counts = new int[n + 1];
        counts[0] = 0;
        for (int i = 1; i <= n; i++){
            if (i % 2 == 1) counts[i] = counts[i - 1] + 1;
            else {
                counts[i] = counts[i >> 1];
            }
        }
        return counts;
    }
}
